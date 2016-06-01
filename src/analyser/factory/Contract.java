/**************************************************************************/
/*  Implementation of a simple semi-unification algorithm (Henglein 1993) */
/*  Copyright (C) 2012. Michael Lienhardt                                 */
/*                                                                        */
/*  This program is free software; you can redistribute it and/or modify  */
/*  it under the terms of the GNU General Public License as published by  */
/*  the Free Software Foundation; version 2 of the License.               */
/*                                                                        */
/*  This program is distributed in the hope that it will be useful, but   */
/*  WITHOUT ANY WARRANTY; without even the implied warranty of            */
/*  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU     */
/*  General Public License for more details.                              */
/*                                                                        */
/*  You should have received a copy of the GNU General Public License     */
/*  along with this program; if not, write to the Free Software           */
/*  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA         */
/*  02110-1301 USA                                                        */
/*                                                                        */
/**************************************************************************/

package analyser.factory;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

import com.gzoumix.semisolver.term.Term;

public class Contract extends GenericStructuredTerm {


  public static final String name = "Contract";

  /* Constructors */
  public Contract(List<Term> l) { super(name, l); }
  public Contract() { super(name, new LinkedList()); }

  public Contract(ContractElement e) { this(); this.getSubTerms().add(e); }

  /* Basic Extension */
  public void add(Contract c) { subterms.addAll(c.subterms); }

  // TODO: remove because uselless now.
  
  /* Basic Get */
  public List<ContractElement> getList() {
    List<ContractElement> res = new LinkedList<ContractElement>();
    for(Term t : getSubTerms()) { 
        res.add((ContractElement)t); 
    }
    return res;
  }

  /* toString */
  public String toString(){
    if(subterms.isEmpty()) return "0";
    
    Iterator<Term> i = subterms.iterator();
    String res = "";
    while (i.hasNext()) {
      res = res + (i.next().toString());
      if(i.hasNext()) res = res + "; ";
    }
    return res;
  }


}

