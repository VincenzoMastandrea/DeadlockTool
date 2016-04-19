// Generated from /Users/vmastand/GitHub/DeadlockTool/src/gASP.g4 by ANTLR 4.5.1

import models.*;
import java.util.HashMap;
import java.util.LinkedList;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link gASPParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface gASPVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link gASPParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(gASPParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#classSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassSignature(gASPParser.ClassSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#classDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDec(gASPParser.ClassDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#methodSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodSignature(gASPParser.MethodSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#methodDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDef(gASPParser.MethodDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(gASPParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(gASPParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#varDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDec(gASPParser.VarDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#objDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjDec(gASPParser.ObjDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#intDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntDec(gASPParser.IntDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#parDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParDef(gASPParser.ParDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#typeVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeVariable(gASPParser.TypeVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#secondPair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSecondPair(gASPParser.SecondPairContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(gASPParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#intType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(gASPParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#objType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjType(gASPParser.ObjTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(gASPParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(gASPParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#skipStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkipStmt(gASPParser.SkipStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#assignStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(gASPParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(gASPParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#elseStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStmt(gASPParser.ElseStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(gASPParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#stmtblock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtblock(gASPParser.StmtblockContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#expressionSideEffect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionSideEffect(gASPParser.ExpressionSideEffectContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(gASPParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(gASPParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#newExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExp(gASPParser.NewExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticExpression(gASPParser.ArithmeticExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#valAritExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValAritExp(gASPParser.ValAritExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#variableExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExp(gASPParser.VariableExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#parAritExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParAritExp(gASPParser.ParAritExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#booleanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpression(gASPParser.BooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(gASPParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link gASPParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(gASPParser.ElementContext ctx);
}