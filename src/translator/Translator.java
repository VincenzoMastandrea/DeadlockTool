package translator;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedList;

import org.antlr.v4.parse.ANTLRParser.parserRule_return;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import models.ClassDecl;
import models.Program;
import parser.gASPLexer;
import parser.gASPParser;


public class Translator {
	
//	public static void translate(gASPParser parser, ParseTree tree)
//	{
//		// Create a generic parse tree walker that can trigger callbacks
//		ParseTreeWalker walker = new ParseTreeWalker();
//		// Walk the tree created during the parse, trigger callbacks
//		walker.walk(new gAspToAbs(parser.classTable), tree);
//		System.out.println();
//	}
//
	
}