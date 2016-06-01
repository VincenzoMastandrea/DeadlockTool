/*
 * @Author Vincenzo Mastandrea
 * Grammar definition for ASP
 */

grammar gASP;

@header{
import models.*;
import java.util.HashMap;
import java.util.LinkedList;
}

@members{
	public HashMap<String, ClassDecl> classTable;
	public ClassDecl currentClass;
	public Method currentMethod;
	public Environment environment;
}

// A program start with key "module" moduleName semicolon, class definitions and main function
program returns [Program prog]
				@init{HashMap<String, ClassDecl> classMap = new HashMap<>();
					  classTable = classMap;
				}
				:   (classDec {classMap.put($classDec.classObj.getClassName(),$classDec.classObj);})* main=body
				    {$prog = new Program(classMap, $main.stb);};


classSignature returns [ClassDecl classObj]
				@init{HashMap<String, LinkedList<Method>> methods = new HashMap<>();
					  $classObj = new ClassDecl();
					  currentClass = $classObj;
					  }
				: 	CLASS className=IDUC {$classObj.setClassName($className.text);}
				    LPAR (parameters=parDef) {$classObj.setParameters($parameters.pars);} RPAR
				;

classDec returns [ClassDecl classObj]
				@init{HashMap<String, LinkedList<Method>> methods = new HashMap<>();
					  LinkedList<Method> methodList = null;
					  $classObj = new ClassDecl();
					  currentClass = $classObj;
					  }
				: 	cs = classSignature {$classObj = $cs.classObj;}
				    LCBRACK fields=varDeclaration {$classObj.setFields($fields.vars);}
				    		(m=methodDef {if (methods.containsKey($m.method.getMethodName()))
				    	                	   { LinkedList<Method> list = methods.get($m.method.getMethodName());
				    	                         if ($m.method.isIn(list))
				    	                         { System.out.println("The method "+ $m.method.getMethodName() +
				    	                                              " has been defined more than once! Rename it");
				    	                           System.exit(0); }
				    	                         else
				    	                         { $m.method.setID(methods.get($m.method.getMethodName()).size());
												   methods.get($m.method.getMethodName()).add($m.method);
											     }
 					    					   }
					    					   else
					    					   {  methodList = new LinkedList<>();
					    						  $m.method.setID(0);
					    						  methodList.add($m.method);
					    	                      methods.put($m.method.getMethodName(),methodList);
					    	                   }
				    	    })*
				     RCBRACK
				    { $classObj.setMethods(methods);};

methodSignature returns [Method methodSign]
				  @init{environment = new Environment();
				  	    environment.putAllInt(currentClass.getParameters());
				  	    environment.putAll(currentClass.getFields());
				  		$methodSign = new Method();
				  	    currentMethod = $methodSign;
				  	    LinkedList<Variable> parameters = new LinkedList<>();
					    HashMap<String,Type> varDec = new HashMap<>();
						LinkedList<Statement> stmts = new LinkedList<>(); }
				  :	returnedType=type {$methodSign.setReturnedType($returnedType.varType);}
				    methodName=IDLC {$methodSign.setMethodName($methodName.text);}
				    LPAR (p=parDef) {$methodSign.setParameters($p.pars); environment.putAllInt($p.pars);}RPAR
				  ;



methodDef returns [Method method]
				  :	ms = methodSignature {$method = $ms.methodSign;}
				    b=body
				    {$method.setBody($b.stb); }
				  ;


body returns [StmtBlock stb]
			 @init{LinkedList<Statement> stmts = new LinkedList<>();
				  	HashMap<String,Type> vars = null;}
			 : LCBRACK (v=varDeclaration {vars=$v.vars; environment.putAll(vars);}) (st=stmt {stmts.add($st.s);})* RCBRACK {$stb = new StmtBlock(vars,stmts);}
			 ;


varDeclaration returns [HashMap<String,Type> vars]
				       @init{ $vars = new HashMap<>();}
		               : (v=varDec {$vars.put($v.dec.getName(),$v.dec.getType());})*;

varDec returns [Variable dec]
     		: od = objDec  {$dec = $od.dec;}
     		| id = intDec  {$dec = $id.dec;}
     		;

objDec returns [Variable dec]
     		: (t=objType v=variable SEMI  { $v.var.setType($t.varType); $dec = $v.var; } )
     		;

intDec returns [Variable dec]
     		   : (t=intType v=variable ASSIGN NUMBER SEMI  { $v.var.setType($t.varType); $dec = $v.var;} )
     		   ;

parDef returns [LinkedList<Variable> pars]
				@init{$pars = new LinkedList<>();
					  Type type = null;
			   		  Variable var = null;
			   		  int parIndex = 0;}
				: (tv=typeVariable { $pars.add((Integer) parIndex,$tv.par); })?
				  (tv1= secondPair { $pars.add((Integer) (parIndex +1),$tv1.par);}   )*;



typeVariable returns [Variable par]
					 : (t=type v=variable { $v.var.setType($t.varType); $par = $v.var; })
					 ;

secondPair returns [Variable par]
				: COMMA tv=typeVariable {$par=$tv.par;}
				;


type returns [Type varType]
            : it=intType   {$varType = $it.varType;}
            | ot=objType   {$varType = $ot.varType;};

intType returns [Type varType]
            : INT  {$varType = new TypeInt();};

objType returns [Type varType]
            : IDUC   {$varType = new TypeObject($IDUC.text);};


variable returns [Variable var]
				 :   v=IDLC {$var = new Variable($v.text);};

stmt returns [Statement s]
     		: sk  = skipStmt   {$s = $sk.s ;}
            | as  = assignStmt {$s = $as.s ;}
            | ite = ifStmt     {$s = $ite.s;}
            | rt  = returnStmt {$s = $rt.s ;}
            ;



skipStmt returns [Statement s] : SKIP SEMI {$s = new Skip();} ;

assignStmt returns [Statement s]
				   @init{  Variable var = null;
					       ExpressionSideEffects exprse = null; }
                   : l=IDLC {var = environment.getVar($l.text);} ASSIGN r=expressionSideEffect {exprse = $r.exprse;} SEMI {$s = new Assignment(var,exprse);};

ifStmt returns [Statement s]
			@init{  Expression cond = null;
					Statement stTrue = null;
					Statement stFalse = null; }
               : IF LPAR (guard=booleanExpression {cond = $guard.exprBool;}) RPAR
                 (trueSideS=stmt {stTrue = $trueSideS.s;}| trueSideSB=stmtblock {stTrue = $trueSideSB.stb;})
                 (els=elseStmt {stFalse = $els.s;} )?
                 {$s = new IfThenElse(cond,stTrue,stFalse);};


elseStmt returns [Statement s]
			@init{  Expression cond = null;
					Statement stTrue = null;
					Statement stFalse = null; }
               : (ELSE (falseSideS=stmt {$s = $falseSideS.s;}| falseSideSB=stmtblock {$s = $falseSideSB.stb;}) )
               ;


returnStmt returns [Statement s] : RETURN v=value SEMI {$s = new Return($v.val);};



stmtblock returns [StmtBlock stb]
				  @init{$stb = new StmtBlock();
				  		LinkedList<Statement> stmts = new LinkedList<>();}
			      : LCBRACK (st=stmt {stmts.add($st.s);})* RCBRACK {$stb.setStmts(stmts);}
			      ;

expressionSideEffect returns [ExpressionSideEffects exprse]
							 @init{LinkedList<Expression> param = new LinkedList<>();
							 	   Variable obj = null;}
							 : exp=expression	 {$exprse = $exp.expr    ;}
							 | mc = methodCall   {$exprse = $mc.expr     ;}
							 | newObj =newExp 	 {$exprse = $newObj.expr ;}
							 ;

methodCall returns [ExpressionSideEffects expr]
				   @init{LinkedList<Expression> param = new LinkedList<>();
					 	 Variable obj = null;}
				   : elem=element {obj = environment.getVar($elem.text);}DOT methodName=IDLC LPAR (par=expression {param.add($par.expr);})* RPAR
							   	  {$expr = new MethodCall(obj,$methodName.text,param);}
				   ;

expression returns [Expression expr]
   		    	   : v=value      				{$expr = $v.val;}
				   | el=element 				{$expr = $el.elem;}
				   | expra=arithmeticExpression	{$expr = $expra.exprArit;}
				   ;

newExp returns [ExpressionSideEffects expr]
			   @init{LinkedList<Expression> param = new LinkedList<>();}
			   : NEW className=IDUC LPAR (par=expression {param.add($par.expr);})* RPAR
							 			  {$expr = new New($className.text,param);}
			   ;

arithmeticExpression returns [Expression exprArit]
	 			     		: l=arithmeticExpression o=('*'|'/' | '+'|'-') r=arithmeticExpression
	 			       		   {$exprArit = new ExpressionBinaryOperation($l.exprArit,$o.text,$r.exprArit);}
	 			       		| n=valAritExp       {$exprArit = $n.exprArit  ;}
    						| v=variableExp      {$exprArit = $v.exprArit  ;}
    						| parAritExp
    						;


valAritExp returns [Expression exprArit]
                  : n=NUMBER    {$exprArit = new ExpressionIntValue(Integer.parseInt($n.text));}
    			  ;

variableExp returns [Expression exprArit]
				  : v=IDLC      {$exprArit = environment.getVar($v.text);}
				  ;

parAritExp returns [Expression exprArit]
			   : LPAR arithmeticExpression RPAR;

booleanExpression returns [Expression exprBool]
     				      : l=booleanExpression o=(OR | AND | EQUALS | DISTINCT | GT | LT | GEG | LEG) r=booleanExpression
					   		{$exprBool = new ExpressionBinaryOperation($l.exprBool,$o.text,$r.exprBool);}
					   	  | a=arithmeticExpression {$exprBool=$a.exprArit;}
    				 	  | e   = element  		   {$exprBool=$e.elem;}
    					  | '(' booleanExpression ')'
    					  ;

value returns [ExpressionValue val]
			  : NULL   	  {$val = new ExpressionNullValue();}
			  | THIS      {$val = new ExpressionThisValue();}
			  | n=NUMBER  {$val = new ExpressionIntValue(Integer.parseInt($n.text));}
			  ;

element returns [Element elem]
                : IDLC   	 {$elem = environment.getVar($IDLC.text);}
                | THIS     {$elem = new ExpressionThisValue();}
                ;


//lcbrak		: LCBRACK	;
//rcbrak		: RCBRACK	;

//TOKENS
AND      : '&&' 	    ;
ASSIGN	 : '='	        ;
CLASS	 : 'class'      ;
COLON    : ':'	        ;
COMMA    : ','	        ;
DISTINCT : '!='	        ;
DIV      : '/' 	        ;
DOT      : '.'	        ;
ELSE	 : 'else'       ;
EQUALS   : '=='	        ;
GEG      : '>='	        ;
GT       : '>' 	        ;
IF		 : 'if'	        ;
INT		 : 'Int'	    ;
LCBRACK  : '{'	        ;
LEG      : '<=' 	    ;
LPAR  	 : '('	        ;
LSBRACK  : '['	        ;
LT       : '<' 	        ;
MINUS    : '-' 	        ;
MOD		 : 'module'     ;
MULT     : '*' 	        ;
NEW		 : 'new'	    ;
NULL     : 'null'       ;
OR       : '||'         ;
PLUS     : '+' 	        ;
RCBRACK  : '}'	        ;
RETURN	 : 'return'     ;
RPAR  	 : ')'	        ;
RSBRACK  : ']'	        ;
SEMI     : ';'	        ;
SKIP     : 'skip'       ;
THIS	 : 'this'       ;

fragment CHAR 	: 'a'..'z' |'A'..'Z' ;
fragment CHARU  : 'a'..'z' |'A'..'Z' | '_';
fragment CHARUC : 'A'..'Z';
fragment CHARLC : 'a'..'z';



IDUC            : CHARUC (CHARU | DIGIT)* ;
IDLC            : CHARLC (CHARU | DIGIT)* ;


//ID              : (CHARLC | CHARUC | DIGIT | UNDER)* ;
//IDLC            : CHARLC ID ;
//IDUC            : CHARUC ID ;

fragment DIGIT	: '0'..'9';
NUMBER          : DIGIT+;

//SCAPED SEQUENCES
WS              : (' '|'\t'|'\n'|'\r')-> skip;
LINECOMENTS 	: '//' (~('\n'|'\r'))* -> skip;
BLOCKCOMENTS    : '/*'( ~('/'|'*')|'/'~'*'|'*'~'/'|BLOCKCOMENTS)* '*/' -> skip;