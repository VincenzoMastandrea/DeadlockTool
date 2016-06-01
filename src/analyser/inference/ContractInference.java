package analyser.inference;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import choco.kernel.common.util.tools.ArrayUtils;

import com.gzoumix.semisolver.constraint.Constraint;
import com.gzoumix.semisolver.term.*;

import analyser.AnalyserLog;
import analyser.factory.*;
import analyser.generation.*;
import models.ClassDecl;
import models.*;
import models.Variable;

/**
 * Created by vmastand on 27/04/16.
 */
public class ContractInference {


    private static final String _runName = "run";
    private static final String _destinyName = "!destiny!";
    private static final String _this = "this";
    private static final String _future = "!future!";

    private AnalyserLog _log;
    private Factory _df;
    private Model _model;
    private TypingEnvironment _env;
    private GroupName _a;
    private RunningMethod _m;
    private ClassDecl _cd;
    private GroupName _X;

    public ContractInference(AnalyserLog log, Factory df, Model m) {
        _log   = log;
        _df    = df;
        _model = m;
        _env = new TypingEnvironment();
        _a = null;
        _cd = null;
    }

    public RecordPresent createInstance(ClassDecl cd, GroupName a) {
        LinkedList<RecordField> l = new LinkedList<RecordField>();
        boolean correctType = true;
        for (models.Variable f : cd.getParameters()) {
            if(f.getType() instanceof TypeObject) correctType = false;
        }
        ObjKindVar t = new ObjKindVar(new com.gzoumix.semisolver.term.Variable());
        return _df.newRecordPresent(t, a);
    }

    private RecordPresent createInstance(Type t, ClassDecl clthis, GroupName a) {
        return this.createInstance(clthis, a);
    }

    public void computeEnvironment() {
        if(_model instanceof Program)
            for (String key : ((Program) _model).getClasses().keySet()) {
                ClassDecl cl = ((Program) _model).getClasses().get(key);
                computeEnvironment(cl);
            }
    }

    // method declaration
    public void computeEnvironment(ClassDecl cd) {
        // Methods
        for (models.Method m : cd.getMethodList()) {
            _log.logNormal("Generating initial environment for the method \"" + cd.getClassName() + "." + m.getID() + "\"");
            // 1. Record of "this"
            IRecord rthis = createInstance(cd, _df.newGroupName());
            // 2. Simple variables for the method parameters
            LinkedList<IRecord> rparam = new LinkedList<IRecord>();
            for (Variable p : m.getParameters()) {
                rparam.add(_df.newRecordVariable());
            }
            // 3. Simple variable for the return object (or datatype)
            RecordVariable rres = _df.newRecordVariable();
            // 4. Finalize
            MethodInterface mIntf = _df.newMethodInterface(rthis, rparam, rres);
            _env.putMethod(cd.getClassName(), m.getID(), mIntf);
        }
    }

    /************************************/
    /* TYPE INFERENCE */
    /************************************/

    // ResultInferenceStmt stands for
    // 'deadlock.constraints.constraint.ConstraintGeneration_output'.
    // Suppose that 'ResultInferenceStmt' is class type containing three
    // value (Record r, Contract c,
    // deadlock.constraints.constraint.ConstraintStore U)
    // Suppose that ResultInferenceStmt has method getRecord() setRecord(),
    // getContract setContract addContract accumulateContract()
    // "the )( operator",
    // getdeadlock.constraints.constraint.ConstraintStore,
    // setdeadlock.constraints.constraint.ConstraintStore,
    // adddeadlock.constraints.constraint.Constraint(),
    // adddeadlock.constraints.constraint.ConstraintStore()

    // because of all the methods different from get/set needs the Factory, we
    // perform that operation outside ResultInferenceStmt class.
    // itfToClass is an HashMap that bind InterfaceName to ClassDelc, this is
    // done because in ABS Interface are type and Class are not.

    // ////////////////////////////////////////////////////////////////////////////
    // Rules
    // ////////////////////////////////////////////////////////////////////////////

    public ResultInference typeInference() {
        ResultInference res = new ResultInference();

        _log.logDebug("Initial Environment:\n" + _env.toString());

        // 1. methods
        //for (CompilationUnit cu : _model.getCompilationUnits()) { res.add(typeInference(cu)); }
        res.add(typeInference((Program) _model));

        return res;
    }

    /*
    DA IMPLEMENTARE
    */

    /*******************************/
    /*    Inference - T-PROGRAM    */
    /*******************************/

    public ResultInference typeInference(Program prog) {
        ResultInference res = new ResultInference();

        //Main

        _log.logDebug("Contract Inference for the program \"" + prog.getProgramName() + "\"");
        _log.beginIndent();
        _a = _df.newGroupName();
        _m = new RunningMethod("Main");
        ResultInferenceStmt resMain = typeInference(prog.getMF());
        res.add(resMain.getConstraint());
        Contract co = _df.newContractEmpty();
        for(TypingEnvironment te : resMain.getEnvironment())
            //co = _df.newContractUnion(prog.getMF(), co, _df.newContract(te.unsync(prog.getMF())));
            res.setMain(resMain.getContract());
        _log.endIndent();

        //Classes

        _log.logDebug("Contract Inference for Classes \"");
        _log.beginIndent();
        for (String key: prog.getClasses().keySet()) {
            ClassDecl cl = prog.getClasses().get(key);
            res.add(typeInference(cl));
        }
        _log.endIndent();
        return res;
    }

    /*******************************/
    /*     Inference - T-CLASS     */
    /*******************************/
    public ResultInference typeInference(ClassDecl cd) {
        ResultInference res = new ResultInference();
        _log.logDebug("Contract Inference for the class \"" + cd.getClassName() + "\"");
        _log.beginIndent();

        _cd = cd;

        // 1. Methods
        for (models.Method m : cd.getMethodList()) { res.add(typeInference(m)); }

        _env.clearFutures();
        _env.clearVariables();

        _log.endIndent();
        _log.logDebug("Inference for the class \"" + cd.getClassName() + "\" Finished");
        return res;
    }

    /********************************/
    /*     Inference - T-METHOD     */
    /********************************/

    public ResultInference typeInference(models.Method mImp) {
        _log.logDebug("Contract Inference for the method \"" + _cd.getClassName() + "." + mImp.getMethodName() + "\"");
        _log.beginIndent();

        // 1. Generate the environment for the contract inference
        _env.newScope();
        MethodInterface mi = _env.getMethod(_cd.getClassName(), mImp.getMethodName());

        _m = new RunningMethod(mImp.getMethodName());
        _X = _df.newGroupName();

        IRecord thisRecord = mi.getThis();
        List<IRecord> params = mi.getParameters();
        IRecord result = mi.getResult();
        _a = ((RecordPresent) thisRecord).getRoot();
        _env.putVariable(_this, thisRecord); // WARNING: problem with inference if futures in this
        Iterator<IRecord> it = params.iterator();
        for (Variable p : mImp.getParameters()) {
            if(p.getType().isFuture()) {
                TypingEnvironmentVariableTypeFuture f = new TypingEnvironmentVariableTypeFuture (thisRecord);
                _env.putVariable(p.getName(), f);
                _env.putFuture(f, new TypingEnvironmentFutureTypeUntick(it.next()));
            } else { _env.putVariable(p.getName(), it.next()); }
        }
        _env.putVariable(_destinyName, result);

        // 2. Add local variable to environment
        HashMap<String,Type> localVariable = mImp.getBody().getVars();

        for (String varName: localVariable.keySet()){
            Contract contract = _df.newContractEmpty();
            Constraint c = _df.newConstraint();
            ITypingEnvironmentVariableType X = _df.newRecordVariable();

            _env.putVariable(varName, X);
        }

        // 3. perform the inference
        ResultInferenceStmt resBlock = typeInference(mImp.getBody());

        // 4. give back the result.
        ResultInference res = new ResultInference();

        Contract co = _df.newContractEmpty();
        for(TypingEnvironment te : resBlock.getEnvironment())
            co = _df.newContractUnion(mImp, co, _df.newContract(te.unsync(mImp)));

        res.add(_cd.getClassName(), mImp.getMethodName(), _df.newMethodContract(mi, resBlock.getContract(), co));
        res.add(resBlock.getConstraint());

        _env.clearFutures();
        _env.clearVariables();

        _log.endIndent();
        _log.logDebug("Inference for Method Block Finished");
        return res;
    }

    // ////////////////////////////////////////////////////////////////////////////
    // 2.3. Statments

    /*******************************/
    /*     Inference - T-SEQ       */
    /*******************************/

    public ResultInferenceStmt typeInference(StmtBlock b) {
        _log.logDebug("Contract Inference for the StmtBlock");
        _log.beginIndent();
        _env.newScope();

        // accumulate contracts and constraint.Constraints
        // in the resulting output
        ResultInferenceStmt resStmt = null;
        Constraint c = _df.newConstraint();
        Contract contract = _df.newContractEmpty();
        List<TypingEnvironment> envs = new LinkedList<TypingEnvironment>();
        envs.add(_env);

        for (Statement s : b.getStmts()) {
            List<TypingEnvironment> cumul = new LinkedList<TypingEnvironment>();
            Contract current = null;
            for(TypingEnvironment tmpEnv: envs){
                _env = tmpEnv;
                resStmt = typeInference(s);
                c.add(resStmt.getConstraint());
                cumul.addAll(resStmt.getEnvironment());
                current = (current == null)? resStmt.getContract() : _df.newContractUnion(b, current, resStmt.getContract());
            }
            envs = cumul;
            contract.add(current);
        }
        _log.endIndent();
        _log.logDebug("Block Sub-Expression Finished");
        for(TypingEnvironment env: envs) { env.popScope(); }
        return new ResultInferenceStmt(contract, c, envs);
    }

    public ResultInferenceStmt typeInference(Statement s) {

        ResultInferenceStmt resStmt = null;
        if(s instanceof Assignment) resStmt = typeInference((Assignment) s);

        return resStmt;
    }

    public ResultInferenceStmt typeInference(Assignment astmt) {
        _log.logDebug("Contract Inference for the AssignStmt");
        _log.beginIndent();

        String name = astmt.getLeftSide().getName();

        Contract contract;
        Constraint c;
        ITypingEnvironmentVariableType X;

        ExpressionSideEffects exp = astmt.getRightSide();
        if (exp instanceof ExpressionValue) {
            ResultInferencePureExp resValue = typeInferenceAsPure((ExpressionValue) exp);
            contract = _df.newContractEmpty();
            c = _df.newConstraint();
            X = resValue.getVariableType();
        } else {
            ResultInferenceEffExp resValue = typeInference((ExpressionSideEffects) exp);
            contract = resValue.getContract();
            c = resValue.getConstraint();
            X = resValue.getRecord();
        }

        _log.endIndent();
        _log.logDebug("AssignStmt Sub-Expression Finished");
        if (_env.isField(name)) { c.addEquation(new ASTNodeInformation(astmt), _env.getVariableRecord(name), (IRecord)X); }
        else { _env.putVariable(name, X); }
        return new ResultInferenceStmt(contract, c, _env);
    }

    public ResultInferencePureExp typeInferenceAsPure(ExpressionValue exp) {
        _log.logWarning("WARNING: Contract inference not implemented for Expression \"" + exp.getClass().getName() + "\". Assumed Unit Type");
        return new ResultInferencePureExp(_df, _df.dummyDataType());
    }

    public ResultInferenceStmt typeInference(Skip skip) {
        return new ResultInferenceStmt( _df.newContractEmpty(), _df.newConstraint(), _env);
    }

    public ResultInferenceStmt typeInference(Return res) {
        _log.logDebug("Contract Inference for the ReturnStmt");
        _log.beginIndent();
        Contract contract = null;
        Constraint c = null;
        String varName = res.getReturnedExp().getName();
        ITypingEnvironmentVariableType v = _env.getVariable(varName);
        if(v instanceof IRecord) {
            contract = _df.newContractEmpty();
            c = _df.newConstraint();
        }
        else
        {
            IRecord f = _env.getFuture((TypingEnvironmentVariableTypeFuture) v).getRecord();
            contract = _df.newContractReturn(res,f,_X);
        }
        _log.endIndent();
        _log.logDebug("ReturnStmt Sub-Expression Finished");

        c.addEquation(new ASTNodeInformation(res), _env.getVariableRecord(_destinyName), _env.getRecord(resRetExp.getRecord()));

        return new ResultInferenceStmt(contract, c, resRetExp.getEnvironment());
    }

    public ResultInferenceStmt typeInference(ExpressionStmt exp) {
        _log.logDebug("Contract Inference for the ExpressionStmt");
        _log.beginIndent();
        ResultInferenceEffExp resExp = typeInference(exp.getExp());
        _log.endIndent();
        _log.logDebug("ExpressionStmt Sub-Expression Finished");
        return new ResultInferenceStmt(resExp.getContract(), resExp.getConstraint(), resExp.getEnvironment());
    }

    public ResultInferenceStmt typeInference(AssertStmt ass) {
        _log.logDebug("Contract Inference for the AssertStmt");
        return new ResultInferenceStmt( _df.newContractEmpty(), _df.newConstraint(), _env);
    }

    public ResultInferenceStmt typeInference(VarDeclStmt vd) {
        _log.logDebug("Contract Inference for the VarDeclStmt");
        _log.beginIndent();
        ResultInferenceStmt resVarDecl = typeInference(vd.getVarDecl());
        _log.endIndent();
        _log.logDebug("VarDeclStmt Sub-Expression Finished");
        return resVarDecl;
    }

    public ResultInferenceStmt typeInference(IfStmt ifstmt) {
        _log.logDebug("Contract inference of a Conditional Statement");
        _log.beginIndent();
        TypingEnvironment tmp = _env.copy();
        ResultInferenceStmt resThen = typeInference(ifstmt.getThen());
        List<TypingEnvironment> resultEnvs = new LinkedList<>();
        resultEnvs.addAll(resThen.getEnvironment());

        Contract contract;
        Constraint c = resThen.getConstraint();

        if (ifstmt.hasElse()) {
            this._env = tmp;
            ResultInferenceStmt resElse = typeInference(ifstmt.getElse());
            c.add(resElse.getConstraint());
            resultEnvs.addAll(resElse.getEnvironment());
            contract = _df.newContractUnion(ifstmt, resThen.getContract(), resElse.getContract());
        } else {
            resultEnvs.add(_env);
            contract = _df.newContractUnion(ifstmt, resThen.getContract(), _df.newContractEmpty());
        }
        _log.endIndent();
        _log.logDebug("IfStmt Sub-Statments Finished");

        return new ResultInferenceStmt(contract, c, resultEnvs);
    }

    // ////////////////////////////////////////////////////////////////////////////
    // 2.4. Expressions

    // 2.4.1. Pure Expressions

    public ResultInferencePureExp typeInferenceAsPure(ExpressionNullValue exp) {
        _log.logDebug("Contract Inference for the 'null' PureExp");
        return new ResultInferencePureExp(_df, _df.newRecordVariable());
    }

    public ResultInferencePureExp typeInferenceAsPure(ExpressionThisValue exp) {
        _log.logDebug("Contract Inference for the 'this' PureExp");
        return new ResultInferencePureExp(_df, _env.getVariableRecord(_this));
    }

    //Should be T-Value and T-Field
    public ResultInferencePureExp typeInferenceAsPure(VarOrFieldUse var) {
        _log.logDebug("Contract Inference for the VarOrFieldUse");
        return new ResultInferencePureExp(_df, _env.getVariable(var.getName()));
    }


    /***********************************************************/
    //INIT TEMPORARY VERSION OF DATATYPE MANAGEMENT
    public ResultInferencePureExp typeInferenceAsPure(StringLiteral lit) {
        _log.logDebug("Contract Inference for a String Literal");
        return new ResultInferencePureExp(_df, _df.dummyDataType());
    }

    public ResultInferencePureExp typeInferenceAsPure(IntLiteral lit) {
        _log.logDebug("Contract Inference for an Int Literal");
        return new ResultInferencePureExp(_df, _df.dummyDataType());
    }

    public ResultInferencePureExp typeInferenceAsPure(DataConstructorExp exp) {
        _log.logDebug("Contract Inference for a DataType Constructor");
        return new ResultInferencePureExp(_df, _df.dummyDataType());
    }

    public ResultInferencePureExp typeInferenceAsPure(LetExp exp) {
        _log.logDebug("Contract Inference for a Let Expression");
        return new ResultInferencePureExp(_df, _df.dummyDataType());
    }

    public ResultInferencePureExp typeInferenceAsPure(FnApp fn) {
        _log.logDebug("Contract Inference for a Function Application");
        return new ResultInferencePureExp(_df, _df.dummyDataType());
    }

    public ResultInferencePureExp typeInferenceAsPure(IfExp ifExp) {
        _log.logDebug("Contract Inference for an if Expression");
        return new ResultInferencePureExp(_df, _df.dummyDataType());
    }

    public ResultInferencePureExp typeInferenceAsPure(BoolExp bin) {
        _log.logDebug("Contract Inference for a Boolean Expression");
        return new ResultInferencePureExp(_df, _df.dummyDataType());
    }

    public ResultInferencePureExp typeInferenceAsPure(RelationalExpr bin) {
        _log.logDebug("Contract Inference for a Relational Expression");
        return new ResultInferencePureExp(_df, _df.dummyDataType());
    }

    public ResultInferencePureExp typeInferenceAsPure(ArithmeticExp bin) {
        _log.logDebug("Contract Inference for an Arithmetic Expression");
        return new ResultInferencePureExp(_df, _df.dummyDataType());
    }

    // reviewed //
    public ResultInferencePureExp typeInferenceAsPure(NegExp un) {
        _log.logDebug("Contract Inference for a Not Expression");
        return new ResultInferencePureExp(_df, _df.dummyDataType());
    }

    // reviewed //
    public ResultInferencePureExp typeInferenceAsPure(MinusExp un) {
        _log.logDebug("Contract Inference for a Minus Expression");
        return new ResultInferencePureExp(_df, _df.dummyDataType());
    }
    /*********************************************************/


    // TODO:
    // CaseExp : PureExp ::= Expr:PureExp Branch:CaseBranch* ;
    // CaseBranch ::= Left:Pattern Right:PureExp ;
    // abstract Pattern ;
    // PatternVarUse: Pattern ::= <Name>;
    // PatternVar: Pattern ::= Var:PatternVarDecl;
    // ConstructorPattern: Pattern ::= <Constructor> Param:Pattern*;
    // LiteralPattern: Pattern ::= Literal:LiteralExp;
    // UnderscorePattern: Pattern;

    // 2.4.2. Expressions with side effects.


    public ResultInferenceEffExp typeInference(NewExp newExp) {
        _log.logDebug("Contract Inference for the NewExp");
        _log.beginIndent();

        // 1. Create the record for the new object, and collect contract and
        // constraints from arguments
        ClassDecl cl = (ClassDecl) (newExp.lookup(new KindedName(Kind.CLASS, newExp.getClassName())));
        LinkedList<RecordField> fields = new LinkedList<RecordField>();
        int i = 0;
        Contract contract = _df.newContractEmpty();
        Constraint c = _df.newConstraint();
        // 1.1. Params
        _env.newScope();
        ResultInferencePureExp resParam;
        for (PureExp p : newExp.getParams()) {
            resParam = typeInferenceAsPure(p);
            ITypingEnvironmentVariableType x = _env.getRecord(resParam.getVariableType());
            IRecord r = _env.getRecord(x);
            fields.add(_df.newRecordField(cl.getParam(i).getName(), r));
            _env.putVariable(cl.getParam(i).getName(), r);
            c.add(resParam.getConstraint());
            i++;
        }
        // 1.2. Fields
        for (FieldDecl f : cl.getFields()) {
            if (f.hasInitExp()) {
                resParam = typeInferenceAsPure(f.getInitExp());
                fields.add(_df.newRecordField(f.getName(), (IRecord)resParam.getVariableType()));
                c.add(resParam.getConstraint());
            } else {
                fields.add(_df.newRecordField(f.getName(), _df.newRecordVariable()));
            }
        }
        // 1.3. Group Name
        GroupName aprime; // depends if the new object is in the same cog or not
        ObjKind t;
        if (!newExp.hasLocal())
        { aprime = _df.newGroupName();
            t = new ObjKindAct();
        }
        else
        { aprime = _a;
            t = new ObjKindPas();
        }
        IRecord r = _df.newRecordPresent(t, aprime, fields);

        // 1.4. Calling the init of r
        MethodInterface miinit = _df.newMethodInterface(r, new LinkedList<IRecord>(), _df.newRecordVariable());
        c.addSemiEquation(new ASTNodeInformation(newExp), _env.getMethod(cl.getName(), _initName), miinit);
        contract.add(_df.newContractInvk(newExp, _cd.getName(), _initName, miinit));
        _env.popScope();
        _log.endIndent();
        _log.logDebug("End Contract Inference for the NewExp");
        return new ResultInferenceEffExp( r, contract, c, _env);
    }

    public ResultInferenceEffExp typeInference(Call call) {
        _log.logDebug("Contract Inference for a " + ((call instanceof SyncCall) ? "Synchronous" : "Asynchronous") + "  method Call");
        _log.beginIndent();

        // 1. Get the method interface
        Type t = call.getCallee().getType();
        ClassDecl cl;
        if (t.isInterfaceType()) { cl = _intertoclass.get(((InterfaceType) t).getDecl()); }
        else { cl = _cd; }

        if (cl == null) {
            // we are in presence of an non implemented interface
            // in that case, we don't know how the method would behave, and
            // simply put a null contract.
            _log.endIndent();
            _log.logError("Class retrival failed!!!");
            return new ResultInferenceEffExp( _df.newRecordVariable(), _df.newContractEmpty(), _df.newConstraint(), _env);
        } else {
            // 2. Collect contracts and
            // deadlock.constraints.constraint.Constraints from the call
            ResultInferencePureExp resCallee = typeInference(call.getCallee());




            Contract contract = _df.newContractEmpty();
            Constraint c = _df.newConstraint();

            // cast to IRecord as the callee cannot be a future
            IRecord callee = (IRecord)resCallee.getVariableType();

            LinkedList<IRecord> s = new LinkedList<IRecord>();
            ResultInferencePureExp resParam;
            for (PureExp p : call.getParams()) {
                resParam = typeInferenceAsPure(p);
                s.add(_env.getRecord(resParam.getVariableType()));
            }

            // 3. Construct the record for the return value
            IRecord Y = _df.newRecordVariable();

            // 4. pack up the result
            MethodInterface mi = _df.newMethodInterface(callee, s, Y);
            c.addSemiEquation(new ASTNodeInformation(call), _env.getMethod(cl.getName(), call.getMethod()), mi);

            ITypingEnvironmentVariableType r;
            if (call instanceof SyncCall) {
                r = Y;
                contract.add(_df.newContractSyncInvk(call, cl.getName(), call.getMethod(), mi));
            } else {
                GroupName aprime = _df.newGroupName();
                IRecord calleeShape = createInstance(_cd, aprime);
                c.addEquation(new ASTNodeInformation(call), callee, calleeShape);
                r = new TypingEnvironmentVariableTypeFuture();
                _env.putFuture((TypingEnvironmentVariableTypeFuture)r, new TypingEnvironmentFutureTypeUntick(_df.newRecordFuture(t, aprime, Y), new ContractElementInvk(call, cl.getName(), call.getMethod(), mi)));
            }
            _log.endIndent();
            _log.logDebug("End Contract Inference for the Call");
            return new ResultInferenceEffExp( r, contract, c, _env);
        }
    }

    public ResultInferenceEffExp typeInference(GetExp exp) {
        _log.logDebug("Contract Inference for a GetExp");
        _log.beginIndent();

        // 1. first is calculate the inference of the expression 'e' of 'e.get'
        ResultInferencePureExp resPureExp = typeInferenceAsPure(exp.getPureExp());
        _log.endIndent();
        _log.logDebug("GetExp Sub-Expression Finished");

        Contract contract;
        Constraint c = _df.newConstraint();

        // 2. record for the result
        GroupName aprime = _df.newGroupName();
        IRecord X = _df.newRecordVariable();
        ObjKind t = _df.newObjKindVar();


        // 3. check if future is tick
        ITypingEnvironmentFutureType fType = _env.getFuture((TypingEnvironmentVariableTypeFuture)resPureExp.getVariableType());

        RunningMethod m = ((RecordFuture) fType.getRecord()).getMethod();

        if(fType instanceof TypingEnvironmentFutureTypeUntick){
            ContractConst cc = new ContractConst(((RecordFuture) fType.getRecord()).getObjKind(), new ObjKindAct());
            _env.putFuture((TypingEnvironmentVariableTypeFuture)resPureExp.getVariableType(), new TypingEnvironmentFutureTypeTick(fType.getRecord()));
            contract = _df.newContract(_df.newContractElementParallel( _df.newContractInvkG(exp, cc,
                    ((TypingEnvironmentFutureTypeUntick) fType).getContract(),
                    new ContractElementGet(exp, _a, _m, aprime, m)), _env.unsync(exp)));
        } else {
            contract = _df.newContractEmpty();
        }

        c.addEquation(new ASTNodeInformation(exp), _df.newRecordFuture(t, aprime, m, X), fType.getRecord());

        return new ResultInferenceEffExp(X, contract, c, _env);
    }

    // ////////////////////////////////////////////////////////////////////////////
    // 2.5. Guards

    public ResultInferencePureExp typeInference(ClaimGuard cg) {
        _log.logDebug("Contract Inference for a ClaimGuard");
        _log.beginIndent();
        ResultInferencePureExp res = typeInferenceAsPure(cg.getVar());
        _log.endIndent();
        return res;
    }

    // TODO; AndGuard, ExpGuard, DurationGuard

}

}
