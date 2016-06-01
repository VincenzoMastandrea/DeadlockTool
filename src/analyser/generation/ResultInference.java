package analyser.generation;

import java.util.Map;
import java.util.HashMap;

import analyser.factory.EnvironmentMethod;
import com.gzoumix.semisolver.constraint.Constraint;
import analyser.factory.MethodContract;
import analyser.factory.Contract;

public class ResultInference {

  private HashMap<String, MethodContract> methods;
  private Constraint constraint;
  private EnvironmentMethod theta;

  private Contract contract;

  /* Constructor */
  public ResultInference(){
    this.methods = new HashMap<String, MethodContract>();
    this.constraint = null;
    this.contract = null;
    }

  /* Basic Get */

  public Map<String, MethodContract> getMethods(){ return this.methods; }
  public Constraint getConstraint(){ return this.constraint; }
  public Contract getMainContract() { return contract; }


  /* Basic Estension */
  public void add(Constraint c) {
    if(this.constraint == null) { this.constraint = c; }
    else if(c != null) { this.constraint.add(c); }	
  }

  public void add(String className, String methodName, MethodContract contract){
    this.methods.put(className + "." + methodName, contract);
  }

  public void add(ResultInference r) {
    this.methods.putAll(r.methods);
    this.add(r.constraint);
    if(r.getMainContract() != null) {
      setMain(r.getMainContract());
    }
  }

  public void setMain(Contract c) { this.contract = c;}

}


