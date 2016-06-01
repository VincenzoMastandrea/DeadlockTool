package translator;

import java.util.HashMap;
import java.util.LinkedList;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import models.*;
import parser.gASPBaseListener;
import parser.gASPParser;

public class gAspToAbs extends gASPBaseListener {
	
//	private static final String SP = " ";
//	private static HashMap<String, ClassDecl> classTable;
//
//
//	public gAspToAbs(HashMap<String, ClassDecl> classTable){
//		this.classTable = classTable;
//	}
//
//
//	public static LinkedList<String> buildInterface()
//	{
//		LinkedList<String> interfaces = new LinkedList<>();
//		for(String className : classTable.keySet())
//		{
//			ClassDecl c = classTable.get(className);
//			String interf = "interface" + SP + c.getClassName() + "{";
//			LinkedList<Method> methods = c.getMethodList();
//			for(Method method : methods)
//			{
//				interf += method.getReturnedType().getType() + SP +
//						  method.getMethodName() + SP + "(";
//				HashMap<Integer,Type> parameters = method.getParameters();
//				for(Integer key : parameters.keySet())
//				{
//					int count = 0;
//					count++;
//					if(count == parameters.size())
//						interf += parameters.get(key).toString();
//					else
//						interf += parameters.get(key).toString() + ", ";
//				}
//				interf += "); ";
//			}
//			interf += "}";
//			interfaces.add(interf);
//		}
//		return interfaces;
//	}
//
//	/**
//	 * {@inheritDoc}
//	 *
//	 * <p>The default implementation does nothing.</p>
//	 */
//	@Override public void enterProgram(@NotNull gASPParser.ProgramContext ctx) { String interf = "";
//																				for(String s : buildInterface())
//																				{
//																					interf = interf + s + "\n";
//																				}
//																				System.out.println(ctx.MOD().toString() + SP +
//																								   ctx.IDUC().toString() + ctx.SEMI().toString() +
//																								   "\n" + interf ); }
//
//
//	/*****************************
//	*							 *
//	*   	  CLASS DEF			 *
//	*							 *
//	*****************************/
//
//
//	/**
//	 * {@inheritDoc}
//	 *
//	 * <p>The default implementation does nothing.</p>
//	 */
//	@Override public void enterClassSignature(@NotNull gASPParser.ClassSignatureContext ctx) {System.out.print(ctx.CLASS().toString()    + SP +
//			 																						            ctx.className.getText() + SP +
//			 																						            ctx.LPAR().toString()
//			 																						         ); }
//	/**
//	 * {@inheritDoc}
//	 *
//	 * <p>The default implementation does nothing.</p>
//	 */
//	@Override public void exitClassSignature(@NotNull gASPParser.ClassSignatureContext ctx) {System.out.println(ctx.RPAR().toString() + SP +
//																											   "implements" + SP +
//																											    ctx.className.getText() + "{"); }
//
//	/**
//	 * {@inheritDoc}
//	 *
//	 * <p>The default implementation does nothing.</p>
//	 */
//	@Override public void exitClassDec(@NotNull gASPParser.ClassDecContext ctx) {System.out.println(ctx.RCBRACK().getText());}
//
//
//	/* ***************************
//	*   	  PARAMETERS		 *
//	*****************************/
//	/**
//	 * {@inheritDoc}
//	 *
//	 * <p>The default implementation does nothing.</p>
//	 */
//	@Override public void exitTypeVariable(@NotNull gASPParser.TypeVariableContext ctx) {System.out.print(ctx.t.getText() + SP + ctx.v.getText()); }
//	/**
//	 * {@inheritDoc}
//	 *
//	 * <p>The default implementation does nothing.</p>
//	 */
//	@Override public void enterSecondPair(@NotNull gASPParser.SecondPairContext ctx) { System.out.print(ctx.COMMA().getText() + SP); }
//
//
//
//	/*****************************
//	*							 *
//	*      METHOD SIGNATURE	     *
//	*							 *
//	*****************************/
//	/**
//	 * {@inheritDoc}
//	 *
//	 * <p>The default implementation does nothing.</p>
//	 */
//	@Override public void enterMethodSignature(@NotNull gASPParser.MethodSignatureContext ctx) {System.out.print( ctx.returnedType.getText() + SP +
//																							    				 ctx.methodName.getText()   +
//																							    				 ctx.LPAR().getText()
//																							    			   ); }
//	/**
//	 * {@inheritDoc}
//	 *
//	 * <p>The default implementation does nothing.</p>
//	 */
//	@Override public void exitMethodSignature(@NotNull gASPParser.MethodSignatureContext ctx)  { System.out.print(ctx.RPAR().getText()); }
//
//
//	/*****************************
//	*							 *
//	*      		BODY		     *
//	*							 *
//	*****************************/
//
//	/**
//	 * {@inheritDoc}
//	 *
//	 * <p>The default implementation does nothing.</p>
//	 */
//	@Override public void enterBody(@NotNull gASPParser.BodyContext ctx) { System.out.println(ctx.LCBRACK().getText());}
//	/**
//	 * {@inheritDoc}
//	 *
//	 * <p>The default implementation does nothing.</p>
//	 */
//	@Override public void exitBody(@NotNull gASPParser.BodyContext ctx) { System.out.println(ctx.RCBRACK().getText());}
//
//	/* ***************************
//	*    VARIABLE DECLARATION	 *
//	******************************/
//
//	/**
//	 * {@inheritDoc}
//	 *
//	 * <p>The default implementation does nothing.</p>
//	 */
//	@Override public void exitObjDec(@NotNull gASPParser.ObjDecContext ctx) {System.out.println(ctx.t.getText() + SP +
//																							 ctx.v.getText() +
//																							 ctx.SEMI().getText()); }
//	/**
//	 * {@inheritDoc}
//	 *
//	 * <p>The default implementation does nothing.</p>
//	 */
//	@Override public void exitIntDec(@NotNull gASPParser.IntDecContext ctx) {System.out.println(ctx.t.getText() + SP +
//			 																				 ctx.v.getText() + SP +
//			 																				 ctx.ASSIGN().getText() + SP +
//			 																				 ctx.NUMBER().getText() +
//			 																				 ctx.SEMI().getText()); }
//
//	/* ****************************
//	*   	  STATEMENT			 *
//	*****************************/
//
//	/**
//	 * {@inheritDoc}
//	 *
//	 * <p>The default implementation does nothing.</p>
//	 */
//	@Override public void enterSkipStmt(@NotNull gASPParser.SkipStmtContext ctx) { System.out.println(ctx.SKIP().toString() + ctx.SEMI().toString()); }
//	/**
//	 * {@inheritDoc}
//	 *
//	 * <p>The default implementation does nothing.</p>
//	 */
//	@Override public void enterAssignStmt(@NotNull gASPParser.AssignStmtContext ctx) { System.out.print(ctx.l.getText() + SP +
//																									   ctx.ASSIGN().toString() + SP); }
//	/**
//	 * {@inheritDoc}
//	 *
//	 * <p>The default implementation does nothing.</p>
//	 */
//	@Override public void enterMethodCall(@NotNull gASPParser.MethodCallContext ctx) {System.out.print(ctx.elem.getText()   +
//								 													 				  "!"  +
//								 													 				  ctx.methodName.getText() +
//								 													 				  ctx.LPAR().getText()
//								 													 				 );}
//	@Override public void exitMethodCall(@NotNull gASPParser.MethodCallContext ctx) {System.out.print( ctx.RPAR().getText());}
//	/**
//	 * {@inheritDoc}
//	 *
//	 * <p>The default implementation does nothing.</p>
//	 */
//	@Override public void exitExpression(@NotNull gASPParser.ExpressionContext ctx) {System.out.print(ctx.getText());}
//	/**
//	 * {@inheritDoc}
//	 *
//	 * <p>The default implementation does nothing.</p>
//	 */
//	@Override public void enterNewExp(@NotNull gASPParser.NewExpContext ctx) {System.out.print(ctx.NEW().getText() + SP +
//																							  ctx.className.getText() +
//																							  ctx.LPAR().getText());}
//	@Override public void exitNewExp(@NotNull gASPParser.NewExpContext ctx) {System.out.print(ctx.RPAR().getText());}
//	/**
//	 * {@inheritDoc}
//	 *
//	 * <p>The default implementation does nothing.</p>
//	 */
//	@Override public void enterStmtblock(@NotNull gASPParser.StmtblockContext ctx) { System.out.print(ctx.LCBRACK().getText());}
//	/**
//	 * {@inheritDoc}
//	 *
//	 * <p>The default implementation does nothing.</p>
//	 */
//	@Override public void exitStmtblock(@NotNull gASPParser.StmtblockContext ctx) { System.out.print(ctx.RCBRACK().getText());}
//	/**
//	 * {@inheritDoc}
//	 *
//	 * <p>The default implementation does nothing.</p>
//	 */
//	@Override public void enterReturnStmt(@NotNull gASPParser.ReturnStmtContext ctx) { System.out.print(ctx.RETURN().getText() + SP);}
//	/**
//	 * {@inheritDoc}
//	 *
//	 * <p>The default implementation does nothing.</p>
//	 */
//	@Override public void exitReturnStmt(@NotNull gASPParser.ReturnStmtContext ctx) { System.out.print(";");}
//
//
//	/**
//	 * {@inheritDoc}
//	 *
//	 * <p>The default implementation does nothing.</p>
//	 */
//	@Override public void enterIfStmt(@NotNull gASPParser.IfStmtContext ctx) { System.out.println(ctx.IF().getText() + SP +
//																							   ctx.LPAR().getText() +
//																							   ctx.guard.getText()  +
//																							   ctx.RPAR().getText()); }
//	/**
//	 * {@inheritDoc}
//	 *
//	 * <p>The default implementation does nothing.</p>
//	 */
//	@Override public void exitIfStmt(@NotNull gASPParser.IfStmtContext ctx) { }
//	/**
//	 * {@inheritDoc}
//	 *
//	 * <p>The default implementation does nothing.</p>
//	 */
//	@Override public void enterElseStmt(@NotNull gASPParser.ElseStmtContext ctx) {System.out.println(ctx.ELSE().getText() + SP ); }
//	/**
//	 * {@inheritDoc}
//	 *
//	 * <p>The default implementation does nothing.</p>
//	 */
//	@Override public void exitAssignStmt(@NotNull gASPParser.AssignStmtContext ctx) {System.out.println(";"); }
//
//
//
//
	
	
	
	
	

}
