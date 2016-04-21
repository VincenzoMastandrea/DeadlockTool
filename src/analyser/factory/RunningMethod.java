package analyser.factory;

import java.util.LinkedList;

import com.gzoumix.semisolver.term.Term;
import com.gzoumix.semisolver.term.TermVariable;
import com.gzoumix.semisolver.term.Variable;

public class RunningMethod extends GenericStructuredTerm {

public static String prefix = "Method-";
	
	public RunningMethod(String methodName) {
	    super(prefix + methodName, new LinkedList<Term>());
	}
	
	/* Basic Get */
	  public String getName() {
	    int begin = this.getConstructor().lastIndexOf("-") + 1;
	    return getConstructor().substring(begin);
	  }

	  public String toString() { return "." + this.getName(); }
	
}
