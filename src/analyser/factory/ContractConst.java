package analyser.factory;

import java.util.LinkedList;
import java.util.List;

import com.gzoumix.semisolver.term.Term;

public class ContractConst extends GenericStructuredTerm{

	public static String name = "ContractConst";
	
	public ContractConst(ObjKind t1, ObjKind t2) {
		super(name, new LinkedList<Term>());
		// TODO Auto-generated constructor stub
		subterms.add(t1);
		subterms.add(t2);
	}
	
	public String toString() {
	    return (subterms.get(0).toString() + " = " + subterms.get(1).toString());
	  }

}
