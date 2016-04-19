// Generated from /Users/vmastand/GitHub/DeadlockTool/src/gASP.g4 by ANTLR 4.5.1

import models.*;
import java.util.HashMap;
import java.util.LinkedList;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gASPParser}.
 */
public interface gASPListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gASPParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(gASPParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(gASPParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#classSignature}.
	 * @param ctx the parse tree
	 */
	void enterClassSignature(gASPParser.ClassSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#classSignature}.
	 * @param ctx the parse tree
	 */
	void exitClassSignature(gASPParser.ClassSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#classDec}.
	 * @param ctx the parse tree
	 */
	void enterClassDec(gASPParser.ClassDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#classDec}.
	 * @param ctx the parse tree
	 */
	void exitClassDec(gASPParser.ClassDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#methodSignature}.
	 * @param ctx the parse tree
	 */
	void enterMethodSignature(gASPParser.MethodSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#methodSignature}.
	 * @param ctx the parse tree
	 */
	void exitMethodSignature(gASPParser.MethodSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#methodDef}.
	 * @param ctx the parse tree
	 */
	void enterMethodDef(gASPParser.MethodDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#methodDef}.
	 * @param ctx the parse tree
	 */
	void exitMethodDef(gASPParser.MethodDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(gASPParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(gASPParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(gASPParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(gASPParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#varDec}.
	 * @param ctx the parse tree
	 */
	void enterVarDec(gASPParser.VarDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#varDec}.
	 * @param ctx the parse tree
	 */
	void exitVarDec(gASPParser.VarDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#objDec}.
	 * @param ctx the parse tree
	 */
	void enterObjDec(gASPParser.ObjDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#objDec}.
	 * @param ctx the parse tree
	 */
	void exitObjDec(gASPParser.ObjDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#intDec}.
	 * @param ctx the parse tree
	 */
	void enterIntDec(gASPParser.IntDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#intDec}.
	 * @param ctx the parse tree
	 */
	void exitIntDec(gASPParser.IntDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#parDef}.
	 * @param ctx the parse tree
	 */
	void enterParDef(gASPParser.ParDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#parDef}.
	 * @param ctx the parse tree
	 */
	void exitParDef(gASPParser.ParDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#typeVariable}.
	 * @param ctx the parse tree
	 */
	void enterTypeVariable(gASPParser.TypeVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#typeVariable}.
	 * @param ctx the parse tree
	 */
	void exitTypeVariable(gASPParser.TypeVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#secondPair}.
	 * @param ctx the parse tree
	 */
	void enterSecondPair(gASPParser.SecondPairContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#secondPair}.
	 * @param ctx the parse tree
	 */
	void exitSecondPair(gASPParser.SecondPairContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(gASPParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(gASPParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#intType}.
	 * @param ctx the parse tree
	 */
	void enterIntType(gASPParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#intType}.
	 * @param ctx the parse tree
	 */
	void exitIntType(gASPParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#objType}.
	 * @param ctx the parse tree
	 */
	void enterObjType(gASPParser.ObjTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#objType}.
	 * @param ctx the parse tree
	 */
	void exitObjType(gASPParser.ObjTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(gASPParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(gASPParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(gASPParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(gASPParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#skipStmt}.
	 * @param ctx the parse tree
	 */
	void enterSkipStmt(gASPParser.SkipStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#skipStmt}.
	 * @param ctx the parse tree
	 */
	void exitSkipStmt(gASPParser.SkipStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(gASPParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(gASPParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(gASPParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(gASPParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#elseStmt}.
	 * @param ctx the parse tree
	 */
	void enterElseStmt(gASPParser.ElseStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#elseStmt}.
	 * @param ctx the parse tree
	 */
	void exitElseStmt(gASPParser.ElseStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(gASPParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(gASPParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#stmtblock}.
	 * @param ctx the parse tree
	 */
	void enterStmtblock(gASPParser.StmtblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#stmtblock}.
	 * @param ctx the parse tree
	 */
	void exitStmtblock(gASPParser.StmtblockContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#expressionSideEffect}.
	 * @param ctx the parse tree
	 */
	void enterExpressionSideEffect(gASPParser.ExpressionSideEffectContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#expressionSideEffect}.
	 * @param ctx the parse tree
	 */
	void exitExpressionSideEffect(gASPParser.ExpressionSideEffectContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(gASPParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(gASPParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(gASPParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(gASPParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#newExp}.
	 * @param ctx the parse tree
	 */
	void enterNewExp(gASPParser.NewExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#newExp}.
	 * @param ctx the parse tree
	 */
	void exitNewExp(gASPParser.NewExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpression(gASPParser.ArithmeticExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpression(gASPParser.ArithmeticExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#valAritExp}.
	 * @param ctx the parse tree
	 */
	void enterValAritExp(gASPParser.ValAritExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#valAritExp}.
	 * @param ctx the parse tree
	 */
	void exitValAritExp(gASPParser.ValAritExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#variableExp}.
	 * @param ctx the parse tree
	 */
	void enterVariableExp(gASPParser.VariableExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#variableExp}.
	 * @param ctx the parse tree
	 */
	void exitVariableExp(gASPParser.VariableExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#parAritExp}.
	 * @param ctx the parse tree
	 */
	void enterParAritExp(gASPParser.ParAritExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#parAritExp}.
	 * @param ctx the parse tree
	 */
	void exitParAritExp(gASPParser.ParAritExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpression(gASPParser.BooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpression(gASPParser.BooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(gASPParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(gASPParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link gASPParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(gASPParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link gASPParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(gASPParser.ElementContext ctx);
}