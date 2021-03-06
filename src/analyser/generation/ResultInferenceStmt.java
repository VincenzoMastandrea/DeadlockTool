package analyser.generation;

import java.util.LinkedList;
import java.util.List;

import com.gzoumix.semisolver.constraint.Constraint;
import analyser.factory.Contract;

public class ResultInferenceStmt {


  private Contract contract;
  private Constraint constraint;
  private List<TypingEnvironment> environment;

  /* Constructor */
  public ResultInferenceStmt(Contract contract, Constraint constraint, TypingEnvironment env) {

    this.contract = contract;
    this.constraint = constraint;
    this.environment = new LinkedList<TypingEnvironment>();
    environment.add(env);
  }
  
  /* Constructor */
  public ResultInferenceStmt(Contract contract, Constraint constraint, List<TypingEnvironment> envList) {

    this.contract = contract;
    this.constraint = constraint;
    this.environment = new LinkedList<TypingEnvironment>();
    environment.addAll(envList);
  }

  /* Basic Get */

  public Contract getContract() { return this.contract; }
  public Constraint getConstraint() { return this.constraint; }
 
  public List<TypingEnvironment> getEnvironment/*List*/() { return this.environment; }

}

