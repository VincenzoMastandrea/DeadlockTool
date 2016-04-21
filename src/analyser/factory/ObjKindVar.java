package analyser.factory;

import java.util.Set;

import com.gzoumix.semisolver.term.Term;
import com.gzoumix.semisolver.term.TermVariable;
import com.gzoumix.semisolver.term.Variable;

public class ObjKindVar extends TermVariable implements ObjKind{
	
//	public static String name = "ObjKindVar";
	
	public ObjKindVar(Variable v) { super(v); }
	
	public String toString(){
		String kind = "t";
		return kind;
	}
	
	
}
