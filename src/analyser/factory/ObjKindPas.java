package analyser.factory;

import java.util.LinkedList;
import java.util.List;

import com.gzoumix.semisolver.term.Term;

public class ObjKindPas extends GenericStructuredTerm implements ObjKind {

	public static String name = "ObjKindPas";
	
	public ObjKindPas() {
		super(name, new LinkedList<Term>());
		// TODO Auto-generated constructor stub
	}
	
//	public String toString(){
//		String kind = "p.";
//		return kind;
//	}
	
	@Override
	public String toString() {
		String kind = "p";
		return kind;
	}

}
