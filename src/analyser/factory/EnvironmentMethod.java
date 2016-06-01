package analyser.factory;

import com.gzoumix.semisolver.term.Term;
import com.gzoumix.semisolver.term.Variable;

import java.util.List;

/**
 * Created by vmastand on 28/04/16.
 */
public class EnvironmentMethod extends GenericStructuredTerm {

    public EnvironmentMethod(String name, List<Term> l) {
        super(name, l);
    }


}
