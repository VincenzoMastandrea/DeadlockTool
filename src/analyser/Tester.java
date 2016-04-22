package analyser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.gASPLexer;
import parser.gASPParser;
import models.*;
import translator.Translator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;

/**
 * Created by vmastand on 20/04/16.
 */
public class Tester {

    public static final String tradPath = "src/trad.abs";
    public static final String logPath = "src/log.txt";
    public static final boolean verbose = true;

    public static void main(String[] args) throws Exception {
        try {
            new Tester().compile(args);
        } catch (Exception e) {
            System.err.println("An error occurred during compilation: " + e.getMessage());
            e.printStackTrace();

            if (Arrays.asList(args).contains("-debug")) {
                e.printStackTrace();
            }

            System.exit(1);
        }
    }


    private void compile(String[] args) {
        // TODO Auto-generated method stub
        try {
            final Model model = this.parse(args);
//        if (model.hasParserErrors() || model.hasErrors() || model.hasTypeErrors())
//        {
//            System.out.println("Error!");   //****
//            return;
//        }

        System.out.println("Starting deadlock analysis...");   //****

        if (verbose) {
            System.out.println("Starting deadlock analysis...");
        }
        /*Instantiate the analyzer and perform deadlock analysis*/
        Analyser a = new Analyser();
        a.deadlockAnalysis(model, verbose, System.out);
        //a.deadlockAnalysis(model, verbose, numberOfIterations, fixpointVersion, System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Model parse(String[] args) throws Exception {
        InputStream is = System.in;
        is = new FileInputStream(args[0]);

        ANTLRInputStream input = new ANTLRInputStream(is);
        gASPLexer lexer = new gASPLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        gASPParser parser = new gASPParser(tokens);

        //PARSING
        gASPParser.ProgramContext tree = parser.program();
        tree.prog.print();
        Model model = tree.prog;

        return(model);
    }

//
//    @Override
//    protected void printUsage() {
//        super.printUsage();
//        System.out.println("Deadlock analyzer:\n"
//                + "  -it=<var>     max number of iterations before saturating\n"
//                + "  -fixPointVersion=<var>     Default value 1 for original version, value 2 for the newest version\n");
//    }

}
