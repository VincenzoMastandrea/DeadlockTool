package analyser.factory;

import java.util.LinkedList;
import java.util.List;

import com.gzoumix.semisolver.term.Term;

public class ObjKindAct extends GenericStructuredTerm implements ObjKind {

	public static String name = "ObjKindAct";
	
	public ObjKindAct() {
		super(name, new LinkedList<Term>());
		// TODO Auto-generated constructor stub
	}
	
//	public String toString(){
//		String kind = "a.";
//		return kind;
//	}
	
	
	@Override
	public String toString() {
		String kind = "a";
		return kind;
	}
}
