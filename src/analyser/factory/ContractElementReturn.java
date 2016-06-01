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

import com.gzoumix.semisolver.term.Term;
import models.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class ContractElementReturn extends ContractElement {

  public static String name = "ContractReturn";

  /* Constructors */
  public ContractElementReturn(List<Term> l) { super(name, l); }
  public ContractElementReturn(ASTNode pos, IRecord a, GroupName b){
    super(pos, name, new ArrayList<Term>(2));
    subterms.add(a);
    subterms.add(b);
  }

  /* Basic Get */

}

