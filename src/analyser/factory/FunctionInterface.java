/**
 * Copyright (c) 2009-2011, The HATS Consortium. All rights reserved. 
 * This file is licensed under the terms of the Modified BSD License.
 */
package analyser.factory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gzoumix.semisolver.term.Term;
import com.gzoumix.semisolver.term.TermVariable;
import com.gzoumix.semisolver.term.Variable;

public class FunctionInterface extends GenericStructuredTerm {

    public final static String name = "functionInterface";    
    
    public FunctionInterface(List<Term> l) { super(name, l); }
    public FunctionInterface(List<Term> l, Term rreturn) {
        super(name, new LinkedList<Term>());
        this.subterms.addAll(l);
        this.subterms.add(rreturn);
    }

}
