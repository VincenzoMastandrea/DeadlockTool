package analyser.generation;

import java.util.List;
import java.util.LinkedList;

import analyser.factory.Factory;
import analyser.factory.ITypingEnvironmentVariableType;
import analyser.factory.RecordDataType;
import com.gzoumix.semisolver.constraint.Constraint;

public class ResultInferencePureExp {

  private ITypingEnvironmentVariableType r;
  private Factory factory;
  private Constraint constraint;
  //private boolean isDataType;

  /* Constructor */
  public ResultInferencePureExp(Factory df, ITypingEnvironmentVariableType r) { this(df, r, df.newConstraint()); }
  public ResultInferencePureExp(Factory df, ITypingEnvironmentVariableType r, Constraint constraint) {
    factory = df; this.r = r; this.constraint = constraint; }

  /* Basic Get */
  public ITypingEnvironmentVariableType getVariableType() { return r; }
  public Constraint getConstraint() {return this.constraint; }

  public boolean isDataType() { return (r instanceof RecordDataType); }
	
}

