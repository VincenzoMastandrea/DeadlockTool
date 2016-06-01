/**
 * Created by vmastand on 01/06/16.
 */
package analyser.factory;

import java.util.List;
import java.util.ArrayList;

import models.ASTNode;

import com.gzoumix.semisolver.term.Term;

public class ContractElementSync extends ContractElement {

    public static String name = "ContractGet";

    /* Constructors */
    public ContractElementSync(List<Term> l) { super(name, l); }
    public ContractElementSync(ASTNode pos, GroupName a, GroupName b){
        super(pos, name, new ArrayList<Term>(4));
        subterms.add(a);
        subterms.add(b);
    }


    /* Basic Get */
    public GroupName whosWaiting() { return (GroupName)subterms.get(0); }
    public RunningMethod whosWaitingMethod() { return (RunningMethod)subterms.get(1); }
    public GroupName whosWaited() { return (GroupName)subterms.get(2); }
    public RunningMethod whosWaitedMethod() { return (RunningMethod)subterms.get(3); }

    /* toString */
    public String toString() {
        return "(" + (this.whosWaiting().toString()) + "," + (this.whosWaited().toString()) + ")";
    }


}

