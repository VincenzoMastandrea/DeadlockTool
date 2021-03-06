package analyser.generation;

/**
 * Created by vmastand on 20/04/16.
 */
        import java.util.List;
        import java.util.LinkedList;
        import java.util.Map;
        import java.util.HashMap;
        import java.util.Set;
        import java.util.HashSet;

        import models.*;
        import analyser.factory.DataTypeInterface;
        import com.gzoumix.semisolver.term.Term;
        import com.gzoumix.semisolver.constraint.Constraint;
        import analyser.factory.Contract;
        import analyser.factory.ContractElementParallel;
        import analyser.factory.Factory;
        import analyser.factory.FunctionInterface;
        import analyser.factory.IRecord;
        import analyser.factory.ITypingEnvironmentFutureType;
        import analyser.factory.ITypingEnvironmentVariableType;
        import analyser.factory.RecordPresent;
        import analyser.factory.MethodInterface;
        import analyser.factory.TypingEnvironmentFutureTypeUntick;
        import analyser.factory.TypingEnvironmentVariableTypeFuture;

public class TypingEnvironment {

    private static final String _connector = ".";


    // 1. Fields for declarations
    private Map<String, MethodInterface> methods; // Methods

    // 2. fields for inference of methods
    private Set<String>searchPath;

    private List<Map<String, ITypingEnvironmentVariableType>> variables;  // stack frame of mapping variable => record or future
    private Map<TypingEnvironmentVariableTypeFuture, ITypingEnvironmentFutureType> futures;  // mapping future => checked or unchecked


    /* Constructor */
    public TypingEnvironment() {
        methods    = new HashMap<>();
        searchPath = new HashSet<>();
        variables  = new LinkedList<>();
        futures    = new HashMap<>();
    }

    public TypingEnvironment copy() {
        TypingEnvironment res = new TypingEnvironment();
        res.methods = this.methods;
        res.searchPath = this.searchPath;
        res.variables = new LinkedList<>(this.variables);
        res.futures = new HashMap<>(this.futures);
        return res;
    }


    /* Basic Gets */
    // declarations
    public MethodInterface getMethod(String className, String methodName) {
        MethodInterface res = null;
        System.out.println("checking with \"" + _connector + className + _connector + methodName + "\"");
        res = methods.get(_connector + className + _connector + methodName);
        if(res != null) return res;
        return null;
    }

    // Variables
    public ITypingEnvironmentVariableType getVariable(String name) {
        ITypingEnvironmentVariableType res = null;
        for(Map<String, ITypingEnvironmentVariableType> map: variables) {
            res = map.get(name);
            if(res != null) return res;
        }
        if((res == null) && (name != "this")) {
            RecordPresent t = (RecordPresent)(getVariable("this"));
            res = t.getField(name); // possible nullPointerException
        }
        return res;
    }

    public IRecord getVariableRecord(String name) {
        ITypingEnvironmentVariableType var = this.getVariable(name);
        return (var instanceof IRecord)?(IRecord)var : this.getFuture((TypingEnvironmentVariableTypeFuture)var).getRecord();
    }

    public boolean isField(String name) {
        boolean res = true;
        for(Map<String, ITypingEnvironmentVariableType> map: variables) {
            res = (map.get(name) == null);
            if(!res) return false;
        }
        return true;
    }

    // Other gets
    public ITypingEnvironmentFutureType getFuture(TypingEnvironmentVariableTypeFuture fut){
        return futures.get(fut);
    }

    public ContractElementParallel unsync(ASTNode pos) {
        LinkedList<Contract> contracts = new LinkedList<Contract>();
        Contract c;

        for(ITypingEnvironmentFutureType t: this.futures.values()) {
            if(t instanceof TypingEnvironmentFutureTypeUntick) {
                c = new Contract();
                c.getSubTerms().add(((TypingEnvironmentFutureTypeUntick)t).getRecord());
                contracts.add(c);
            }
        }
        return new ContractElementParallel(pos, contracts);
    }

    public IRecord getRecord(ITypingEnvironmentVariableType x) {
        return (x instanceof IRecord)? (IRecord)x:
                this.getFuture(((TypingEnvironmentVariableTypeFuture)x)).getRecord();
    }

    /* Basic Extension */
    public void putMethod(String className, String methodName, MethodInterface mi) { methods.put(className + _connector + methodName, mi); }

    public void newScope() { variables.add(0, new HashMap<String, ITypingEnvironmentVariableType>()); }
    public void popScope() { variables.remove(0); }
    public void putVariable(String name, ITypingEnvironmentVariableType record) { variables.get(0).put(name, record); }
    public void putFuture(TypingEnvironmentVariableTypeFuture f, ITypingEnvironmentFutureType z) { futures.put(f, z); }

    public void clearFutures() { futures = new HashMap<>(); }
    public void clearVariables() { variables = new LinkedList<>(); }

    public void addSearchPath(String name) { searchPath.add(name); }
    public void resetSearchPath() { searchPath = new HashSet<>(); }
    public void setSearchPath(Set<String> path) { searchPath = path; }

    public String toStringVariables() {
        String res = "";
        Set<String> checkedVariables = new HashSet<>();
        for(Map<String, ITypingEnvironmentVariableType> el: variables) {
            for(Map.Entry<String, ITypingEnvironmentVariableType> e : el.entrySet()){
                if(!checkedVariables.contains(e.getKey())) {
                    res = res + "\t" + e.getKey() + " := " + e.getValue().toString() + "\n";
                    checkedVariables.add(e.getKey());
                }
            }
        }
        return res;
    }

    public String toString() {
        String res = "{ \n";
        Set<String> checkedVariables = new HashSet<>();
        for(Map<String, ITypingEnvironmentVariableType> el: variables) {
            for(Map.Entry<String, ITypingEnvironmentVariableType> e : el.entrySet()){
                if(!checkedVariables.contains(e.getKey())) {
                    res = res + "\t" + e.getKey() + " := " + e.getValue().toString() + "\n";
                    checkedVariables.add(e.getKey());
                }
            }
        }
        for(Map.Entry<String, MethodInterface> e : methods.entrySet()){
            res = res + "\t" + e.getKey() + " := " + e.getValue().toString() + "\n";
        }
        return res + "}";
    }

} // end class Environment


