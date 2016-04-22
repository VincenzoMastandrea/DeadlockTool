package analyser;

import java.util.ArrayList;
import java.util.Map;

import analyser.detection.DASolver;
import analyser.detection.FixPointSolver1;
import analyser.detection.FixPointSolver2;
import analyser.generation.*;
import analyser.inference.ContractInference;
import models.*;
import analyser.factory.*;
import java.io.PrintStream;
import com.gzoumix.semisolver.term.*;
import com.gzoumix.semisolver.constraint.*;
import com.gzoumix.semisolver.term.Variable;
import com.gzoumix.semisolver.substitution.*;



/**
 * Created by vmastand on 20/04/16.
 */
public class Analyser {

    private static int FixPoint1_0 = 1;
    private static int FixPoint2_0 = 2;
    private static int nbIteration = 2;


    public void deadlockAnalysis(Model m, boolean verbose, int fixPointVersion, PrintStream out) {

        Variable.varCounter =0;
        Long totalTimeInMs = 0L;

    /* 0, Create the initial data */
        Factory df = new Factory(verbose);
        AnalyserLog log = new AnalyserLog();
        if(verbose) { log.verbose(); }
        ContractInference ci = new ContractInference(log, df, m);

        ci.computeEnvironment();

     /* 1. Generate contracts */
        log.logDebug("Analyzing dependencies to look for deadlocks...");

        Long nanoTime = System.nanoTime();
        Long ellapsedTime = (System.nanoTime() - nanoTime) / 1000000L;
        totalTimeInMs += ellapsedTime;
        ResultInference InferenceOutput = ci.typeInference();
        Map<String, MethodContract> methodMap = InferenceOutput.getMethods();
        Constraint c = InferenceOutput.getConstraint();

        log.logDebug("###############################################################\n");
        log.logDebug("Contract and Constraint generation finished...");
        log.logDebug("Ellapsed time: " + ellapsedTime + "ms");
        log.logDebug("  Initial constraint:\n  -------------------");
        log.logDebug(InferenceOutput.getConstraint().toString() + "\n");
        log.logDebug("  Initial contracts:\n  -----------------");
        for(Map.Entry<String, MethodContract> entry : methodMap.entrySet()){
            log.logDebug("    \"" + entry.getKey() + "\": " + ((entry.getValue() != null) ? (entry.getValue().toString()) : ("null")));
        }
        log.logDebug("    \"main\": " + ((InferenceOutput.getMainContractPresent() != null) ? ("< " + InferenceOutput.getMainContractPresent() + ", " + InferenceOutput.getMainContractFuture() + ">") : ("null")));
        log.logDebug("###############################################################\n");
        log.logDebug("Solving constraint...");

        // 1.2. Solve the constraint and check for errors
        nanoTime = System.nanoTime();
        c.solve();
        ellapsedTime = (System.nanoTime() - nanoTime) / 1000000L;
        totalTimeInMs += ellapsedTime;

        if(!c.getErrors().isEmpty()) {
            log.logDebug("Generation of Contract failed: constraint not satisfiable");
            log.logDebug("###############################################################\n");
        } else {
            log.logDebug("Constraint solving completed");
            log.logDebug("Ellapsed time: " + ellapsedTime + "ms");
            log.logDebug("###############################################################\n");
        }

        ArrayList<GenerationError> errors = new ArrayList<GenerationError>(c.getErrors().size());
        for(SolvingError err : c.getErrors()) {
            if(err instanceof SolvingErrorLoop) { errors.add(new ErrorLoop((SolvingErrorLoop)err)); }
            else { errors.add(new ErrorUnif((SolvingErrorUnif)err)); }
        }

        for(GenerationError err : errors) { System.err.println(err.getHelpMessage()); }
        if(!errors.isEmpty()) { return; }


        // 1.3. apply it to the contracts
        nanoTime = System.nanoTime();
        Substitution s = c.getSubstitution();

        for(String k : methodMap.keySet()){
            MethodContract mc = (MethodContract)s.apply(methodMap.get(k));
            //mc.clean();
            if(methodMap.get(k) != null)   methodMap.put(k, mc);
        }
        ellapsedTime = (System.nanoTime() - nanoTime) / 1000000L;
        totalTimeInMs += ellapsedTime;

        if(verbose) {
            out.println("###############################################################\n");
            out.println("Substitution completed");
            out.println("Ellapsed time: " + ellapsedTime + "ms");


            out.println("###############################################################\n");
            out.println("Contract and Constraint computation finished...");
            out.println("  Constraint:\n  -----------");
            out.println(c.toString() + "\n");
            out.println("  Substitution:\n  -------------");
            out.println(s.toString() + "\n");
            out.println("  Contracts:\n  ---------");
            for(Map.Entry<String, MethodContract> entry : methodMap.entrySet()){
                out.println("    \"" + entry.getKey() + "\": " + entry.getValue());
            }
            out.println("###############################################################\n");
            out.println("Initiating contract analysis");
        }

    /* 2. Analyze the contract */

        if(verbose) out.println("Applying substitution to Main Contract...");

        MainMethodContract mmc = new MainMethodContract((Contract)s.apply(InferenceOutput.getMainContractPresent()), (Contract)s.apply(InferenceOutput.getMainContractFuture()));

        ellapsedTime = (System.nanoTime() - nanoTime)/1000000L;
        totalTimeInMs += ellapsedTime;
//
        if(verbose) {
            out.println("CCT creation completed");
            out.println("Ellapsed time: " + ellapsedTime + "ms");
            out.println("*****CONTRACTS*******");
            Term contract;
            for(String k : methodMap.keySet()){
                contract = methodMap.get(k);
                out.println("    \"" + k + "\": " + ((contract != null) ? (contract.toString()) : ("null")));
            }
            out.println("    \"MAIN.main\": " + mmc.toString());
            out.println("*****END CONTRACTS*******");
        }
//
        if(verbose){
            out.println("###############################################################\n");
            out.println("Computing Dependencies...");
        }

        nanoTime = System.nanoTime();

        DASolver solver = (fixPointVersion == FixPoint2_0)? new FixPointSolver2(df, methodMap, mmc):new FixPointSolver1(df, methodMap, mmc, nbIteration);


        solver.computeSolution();
        ellapsedTime = (System.nanoTime() - nanoTime) / 1000000L;
        totalTimeInMs += ellapsedTime;

        if(verbose) {
            out.println("Dependency analysis completed");
            out.println("Ellapsed time: " + ellapsedTime + "ms");
        }

        out.println("### LOCK INFORMATION RESULTED BY THE ANALYSIS ###\n");

        out.println("Possible Deadlock in Main:    " + solver.isDeadlockMain());
        out.println("Current Version:              " + solver.getName() );
        if(fixPointVersion == FixPoint1_0){
            out.println("Saturation:                   " + ((FixPointSolver1)solver).isSatured());
            out.println("Possible Livelock in Main:    " + ((FixPointSolver1)solver).isLivelockMain());
        }
        out.println("Analysis Duration:            " + totalTimeInMs + "ms");
    }

}


