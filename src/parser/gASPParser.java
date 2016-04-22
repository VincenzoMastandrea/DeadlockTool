package parser;// Generated from /Users/vmastand/GitHub/DeadlockTool/src/gASP.g4 by ANTLR 4.5.1

import models.*;
import java.util.HashMap;
import java.util.LinkedList;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gASPParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AND=1, ASSIGN=2, CLASS=3, COLON=4, COMMA=5, DISTINCT=6, DIV=7, DOT=8, 
		ELSE=9, EQUALS=10, GEG=11, GT=12, IF=13, INT=14, LCBRACK=15, LEG=16, LPAR=17, 
		LSBRACK=18, LT=19, MINUS=20, MOD=21, MULT=22, NEW=23, NULL=24, OR=25, 
		PLUS=26, RCBRACK=27, RETURN=28, RPAR=29, RSBRACK=30, SEMI=31, SKIP=32, 
		THIS=33, IDUC=34, IDLC=35, NUMBER=36, WS=37, LINECOMENTS=38, BLOCKCOMENTS=39;
	public static final int
		RULE_program = 0, RULE_classSignature = 1, RULE_classDec = 2, RULE_methodSignature = 3, 
		RULE_methodDef = 4, RULE_body = 5, RULE_varDeclaration = 6, RULE_varDec = 7, 
		RULE_objDec = 8, RULE_intDec = 9, RULE_parDef = 10, RULE_typeVariable = 11, 
		RULE_secondPair = 12, RULE_type = 13, RULE_intType = 14, RULE_objType = 15, 
		RULE_variable = 16, RULE_stmt = 17, RULE_skipStmt = 18, RULE_assignStmt = 19, 
		RULE_ifStmt = 20, RULE_elseStmt = 21, RULE_returnStmt = 22, RULE_stmtblock = 23, 
		RULE_expressionSideEffect = 24, RULE_methodCall = 25, RULE_expression = 26, 
		RULE_newExp = 27, RULE_arithmeticExpression = 28, RULE_valAritExp = 29, 
		RULE_variableExp = 30, RULE_parAritExp = 31, RULE_booleanExpression = 32, 
		RULE_value = 33, RULE_element = 34;
	public static final String[] ruleNames = {
		"program", "classSignature", "classDec", "methodSignature", "methodDef", 
		"body", "varDeclaration", "varDec", "objDec", "intDec", "parDef", "typeVariable", 
		"secondPair", "type", "intType", "objType", "variable", "stmt", "skipStmt", 
		"assignStmt", "ifStmt", "elseStmt", "returnStmt", "stmtblock", "expressionSideEffect", 
		"methodCall", "expression", "newExp", "arithmeticExpression", "valAritExp", 
		"variableExp", "parAritExp", "booleanExpression", "value", "element"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'&&'", "'='", "'class'", "':'", "','", "'!='", "'/'", "'.'", "'else'", 
		"'=='", "'>='", "'>'", "'if'", "'Int'", "'{'", "'<='", "'('", "'['", "'<'", 
		"'-'", "'module'", "'*'", "'new'", "'null'", "'||'", "'+'", "'}'", "'return'", 
		"')'", "']'", "';'", "'skip'", "'this'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "AND", "ASSIGN", "CLASS", "COLON", "COMMA", "DISTINCT", "DIV", "DOT", 
		"ELSE", "EQUALS", "GEG", "GT", "IF", "INT", "LCBRACK", "LEG", "LPAR", 
		"LSBRACK", "LT", "MINUS", "MOD", "MULT", "NEW", "NULL", "OR", "PLUS", 
		"RCBRACK", "RETURN", "RPAR", "RSBRACK", "SEMI", "SKIP", "THIS", "IDUC", 
		"IDLC", "NUMBER", "WS", "LINECOMENTS", "BLOCKCOMENTS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "gASP.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		public HashMap<String, ClassDecl> classTable;
		public ClassDecl currentClass;
		public Method currentMethod;
		public Environment environment;

	public gASPParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public Program prog;
		public ClassDecContext classDec;
		public BodyContext main;
		public TerminalNode MOD() { return getToken(gASPParser.MOD, 0); }
		public TerminalNode IDUC() { return getToken(gASPParser.IDUC, 0); }
		public TerminalNode SEMI() { return getToken(gASPParser.SEMI, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public List<ClassDecContext> classDec() {
			return getRuleContexts(ClassDecContext.class);
		}
		public ClassDecContext classDec(int i) {
			return getRuleContext(ClassDecContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		HashMap<String, ClassDecl> classMap = new HashMap<>();
							  classTable = classMap;
						
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(MOD);
			setState(71);
			match(IDUC);
			setState(72);
			match(SEMI);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS) {
				{
				{
				setState(73);
				((ProgramContext)_localctx).classDec = classDec();
				classMap.put(((ProgramContext)_localctx).classDec.classObj.getClassName(),((ProgramContext)_localctx).classDec.classObj);
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(81);
			((ProgramContext)_localctx).main = body();
			((ProgramContext)_localctx).prog =  new Program(classMap, ((ProgramContext)_localctx).main.stb);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassSignatureContext extends ParserRuleContext {
		public ClassDecl classObj;
		public Token className;
		public ParDefContext parameters;
		public TerminalNode CLASS() { return getToken(gASPParser.CLASS, 0); }
		public TerminalNode LPAR() { return getToken(gASPParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(gASPParser.RPAR, 0); }
		public TerminalNode IDUC() { return getToken(gASPParser.IDUC, 0); }
		public ParDefContext parDef() {
			return getRuleContext(ParDefContext.class,0);
		}
		public ClassSignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classSignature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterClassSignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitClassSignature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitClassSignature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassSignatureContext classSignature() throws RecognitionException {
		ClassSignatureContext _localctx = new ClassSignatureContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classSignature);
		HashMap<String, LinkedList<Method>> methods = new HashMap<>();
							  ((ClassSignatureContext)_localctx).classObj =  new ClassDecl();
							  currentClass = _localctx.classObj;
							  
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(CLASS);
			setState(85);
			((ClassSignatureContext)_localctx).className = match(IDUC);
			_localctx.classObj.setClassName((((ClassSignatureContext)_localctx).className!=null?((ClassSignatureContext)_localctx).className.getText():null));
			setState(87);
			match(LPAR);
			{
			setState(88);
			((ClassSignatureContext)_localctx).parameters = parDef();
			}
			_localctx.classObj.setParameters(((ClassSignatureContext)_localctx).parameters.pars);
			setState(90);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDecContext extends ParserRuleContext {
		public ClassDecl classObj;
		public ClassSignatureContext cs;
		public VarDeclarationContext fields;
		public MethodDefContext m;
		public TerminalNode LCBRACK() { return getToken(gASPParser.LCBRACK, 0); }
		public TerminalNode RCBRACK() { return getToken(gASPParser.RCBRACK, 0); }
		public ClassSignatureContext classSignature() {
			return getRuleContext(ClassSignatureContext.class,0);
		}
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public List<MethodDefContext> methodDef() {
			return getRuleContexts(MethodDefContext.class);
		}
		public MethodDefContext methodDef(int i) {
			return getRuleContext(MethodDefContext.class,i);
		}
		public ClassDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterClassDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitClassDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitClassDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDecContext classDec() throws RecognitionException {
		ClassDecContext _localctx = new ClassDecContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDec);
		HashMap<String, LinkedList<Method>> methods = new HashMap<>();
							  LinkedList<Method> methodList = null;
							  ((ClassDecContext)_localctx).classObj =  new ClassDecl();
							  currentClass = _localctx.classObj;
							  
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			((ClassDecContext)_localctx).cs = classSignature();
			((ClassDecContext)_localctx).classObj =  ((ClassDecContext)_localctx).cs.classObj;
			setState(94);
			match(LCBRACK);
			setState(95);
			((ClassDecContext)_localctx).fields = varDeclaration();
			_localctx.classObj.setFields(((ClassDecContext)_localctx).fields.vars);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INT || _la==IDUC) {
				{
				{
				setState(97);
				((ClassDecContext)_localctx).m = methodDef();
				if (methods.containsKey(((ClassDecContext)_localctx).m.method.getMethodName()))
								    	                	   { LinkedList<Method> list = methods.get(((ClassDecContext)_localctx).m.method.getMethodName());
								    	                         if (((ClassDecContext)_localctx).m.method.isIn(list))
								    	                         { System.out.println("The method "+ ((ClassDecContext)_localctx).m.method.getMethodName() +
								    	                                              " has been defined more than once! Rename it");
								    	                           System.exit(0); }
								    	                         else
								    	                         { ((ClassDecContext)_localctx).m.method.setID(methods.get(((ClassDecContext)_localctx).m.method.getMethodName()).size());
																   methods.get(((ClassDecContext)_localctx).m.method.getMethodName()).add(((ClassDecContext)_localctx).m.method);
															     }
				 					    					   }
									    					   else
									    					   {  methodList = new LinkedList<>();
									    						  ((ClassDecContext)_localctx).m.method.setID(0);
									    						  methodList.add(((ClassDecContext)_localctx).m.method);
									    	                      methods.put(((ClassDecContext)_localctx).m.method.getMethodName(),methodList);
									    	                   }
								    	    
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(105);
			match(RCBRACK);
			 _localctx.classObj.setMethods(methods);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodSignatureContext extends ParserRuleContext {
		public Method methodSign;
		public TypeContext returnedType;
		public Token methodName;
		public ParDefContext p;
		public TerminalNode LPAR() { return getToken(gASPParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(gASPParser.RPAR, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDLC() { return getToken(gASPParser.IDLC, 0); }
		public ParDefContext parDef() {
			return getRuleContext(ParDefContext.class,0);
		}
		public MethodSignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodSignature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterMethodSignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitMethodSignature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitMethodSignature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodSignatureContext methodSignature() throws RecognitionException {
		MethodSignatureContext _localctx = new MethodSignatureContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_methodSignature);
		environment = new Environment();
						  	    environment.putAllInt(currentClass.getParameters());
						  	    for(int i=0; i<currentClass.getParameters().size();i++)
						  	        environment.put(currentClass.getParameters().get(i).)
						  	    environment.putAll(currentClass.getFields());
						  		((MethodSignatureContext)_localctx).methodSign =  new Method();
						  	    currentMethod = _localctx.methodSign;
						  	    LinkedList<Variable> parameters = new LinkedList<>();
							    HashMap<String,Type> varDec = new HashMap<>();
								LinkedList<Statement> stmts = new LinkedList<>(); 
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			((MethodSignatureContext)_localctx).returnedType = type();
			_localctx.methodSign.setReturnedType(((MethodSignatureContext)_localctx).returnedType.varType);
			setState(110);
			((MethodSignatureContext)_localctx).methodName = match(IDLC);
			_localctx.methodSign.setMethodName((((MethodSignatureContext)_localctx).methodName!=null?((MethodSignatureContext)_localctx).methodName.getText():null));
			setState(112);
			match(LPAR);
			{
			setState(113);
			((MethodSignatureContext)_localctx).p = parDef();
			}
			_localctx.methodSign.setParameters(((MethodSignatureContext)_localctx).p.pars); environment.putAllInt(((MethodSignatureContext)_localctx).p.pars);
			setState(115);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDefContext extends ParserRuleContext {
		public Method method;
		public MethodSignatureContext ms;
		public BodyContext b;
		public MethodSignatureContext methodSignature() {
			return getRuleContext(MethodSignatureContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public MethodDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterMethodDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitMethodDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitMethodDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDefContext methodDef() throws RecognitionException {
		MethodDefContext _localctx = new MethodDefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_methodDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			((MethodDefContext)_localctx).ms = methodSignature();
			((MethodDefContext)_localctx).method =  ((MethodDefContext)_localctx).ms.methodSign;
			setState(119);
			((MethodDefContext)_localctx).b = body();
			_localctx.method.setBody(((MethodDefContext)_localctx).b.stb); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyContext extends ParserRuleContext {
		public StmtBlock stb;
		public VarDeclarationContext v;
		public StmtContext st;
		public TerminalNode LCBRACK() { return getToken(gASPParser.LCBRACK, 0); }
		public TerminalNode RCBRACK() { return getToken(gASPParser.RCBRACK, 0); }
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_body);
		LinkedList<Statement> stmts = new LinkedList<>();
						  	HashMap<String,Type> vars = null;
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(LCBRACK);
			{
			setState(123);
			((BodyContext)_localctx).v = varDeclaration();
			vars=((BodyContext)_localctx).v.vars; environment.putAll(vars);
			}
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << RETURN) | (1L << SKIP) | (1L << IDLC))) != 0)) {
				{
				{
				setState(126);
				((BodyContext)_localctx).st = stmt();
				stmts.add(((BodyContext)_localctx).st.s);
				}
				}
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(134);
			match(RCBRACK);
			((BodyContext)_localctx).stb =  new StmtBlock(vars,stmts);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclarationContext extends ParserRuleContext {
		public HashMap<String,Type> vars;
		public VarDecContext v;
		public List<VarDecContext> varDec() {
			return getRuleContexts(VarDecContext.class);
		}
		public VarDecContext varDec(int i) {
			return getRuleContext(VarDecContext.class,i);
		}
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitVarDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitVarDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_varDeclaration);
		 ((VarDeclarationContext)_localctx).vars =  new HashMap<>();
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(137);
					((VarDeclarationContext)_localctx).v = varDec();
					_localctx.vars.put(((VarDeclarationContext)_localctx).v.dec.getVar().getName(),((VarDeclarationContext)_localctx).v.dec);
					}
					} 
				}
				setState(144);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDecContext extends ParserRuleContext {
		public Variable dec;
		public ObjDecContext od;
		public IntDecContext id;
		public ObjDecContext objDec() {
			return getRuleContext(ObjDecContext.class,0);
		}
		public IntDecContext intDec() {
			return getRuleContext(IntDecContext.class,0);
		}
		public VarDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterVarDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitVarDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitVarDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDecContext varDec() throws RecognitionException {
		VarDecContext _localctx = new VarDecContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_varDec);
		try {
			setState(151);
			switch (_input.LA(1)) {
			case IDUC:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				((VarDecContext)_localctx).od = objDec();
				((VarDecContext)_localctx).dec =  ((VarDecContext)_localctx).od.dec;
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				((VarDecContext)_localctx).id = intDec();
				((VarDecContext)_localctx).dec =  ((VarDecContext)_localctx).id.dec;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjDecContext extends ParserRuleContext {
		public Variable dec;
		public ObjTypeContext t;
		public VariableContext v;
		public TerminalNode SEMI() { return getToken(gASPParser.SEMI, 0); }
		public ObjTypeContext objType() {
			return getRuleContext(ObjTypeContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ObjDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterObjDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitObjDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitObjDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjDecContext objDec() throws RecognitionException {
		ObjDecContext _localctx = new ObjDecContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_objDec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(153);
			((ObjDecContext)_localctx).t = objType();
			setState(154);
			((ObjDecContext)_localctx).v = variable();
			setState(155);
			match(SEMI);
			 ((ObjDecContext)_localctx).dec =  ((ObjDecContext)_localctx).v.var.setType(((ObjDecContext)_localctx).t.varType); 
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntDecContext extends ParserRuleContext {
		public Variable dec;
		public IntTypeContext t;
		public VariableContext v;
		public TerminalNode ASSIGN() { return getToken(gASPParser.ASSIGN, 0); }
		public TerminalNode NUMBER() { return getToken(gASPParser.NUMBER, 0); }
		public TerminalNode SEMI() { return getToken(gASPParser.SEMI, 0); }
		public IntTypeContext intType() {
			return getRuleContext(IntTypeContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public IntDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterIntDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitIntDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitIntDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntDecContext intDec() throws RecognitionException {
		IntDecContext _localctx = new IntDecContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_intDec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(158);
			((IntDecContext)_localctx).t = intType();
			setState(159);
			((IntDecContext)_localctx).v = variable();
			setState(160);
			match(ASSIGN);
			setState(161);
			match(NUMBER);
			setState(162);
			match(SEMI);
			 ((IntDecContext)_localctx).dec =  ((IntDecContext)_localctx).v.var.setType(((IntDecContext)_localctx).t.varType);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParDefContext extends ParserRuleContext {
		public LinkedList<Variable> pars;
		public TypeVariableContext tv;
		public SecondPairContext tv1;
		public TypeVariableContext typeVariable() {
			return getRuleContext(TypeVariableContext.class,0);
		}
		public List<SecondPairContext> secondPair() {
			return getRuleContexts(SecondPairContext.class);
		}
		public SecondPairContext secondPair(int i) {
			return getRuleContext(SecondPairContext.class,i);
		}
		public ParDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterParDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitParDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitParDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParDefContext parDef() throws RecognitionException {
		ParDefContext _localctx = new ParDefContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parDef);
		((ParDefContext)_localctx).pars =  new LinkedList<>();
							  Type type = null;
					   		  Variable var = null;
					   		  int parIndex = 0;
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			_la = _input.LA(1);
			if (_la==INT || _la==IDUC) {
				{
				setState(165);
				((ParDefContext)_localctx).tv = typeVariable();
				 _localctx.pars.add((Integer) parIndex,((ParDefContext)_localctx).tv.par); 
				}
			}

			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(170);
				((ParDefContext)_localctx).tv1 = secondPair();
				 _localctx.pars.add((Integer) (parIndex +1),((ParDefContext)_localctx).tv1.par);
				}
				}
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeVariableContext extends ParserRuleContext {
		public Variable par;
		public TypeContext t;
		public VariableContext v;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TypeVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterTypeVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitTypeVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitTypeVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeVariableContext typeVariable() throws RecognitionException {
		TypeVariableContext _localctx = new TypeVariableContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_typeVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(178);
			((TypeVariableContext)_localctx).t = type();
			setState(179);
			((TypeVariableContext)_localctx).v = variable();
			 ((TypeVariableContext)_localctx).par =  ((TypeVariableContext)_localctx).v.var.setType(((TypeVariableContext)_localctx).t.varType); 
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SecondPairContext extends ParserRuleContext {
		public Variable par;
		public TypeVariableContext tv;
		public TerminalNode COMMA() { return getToken(gASPParser.COMMA, 0); }
		public TypeVariableContext typeVariable() {
			return getRuleContext(TypeVariableContext.class,0);
		}
		public SecondPairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_secondPair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterSecondPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitSecondPair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitSecondPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SecondPairContext secondPair() throws RecognitionException {
		SecondPairContext _localctx = new SecondPairContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_secondPair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(COMMA);
			setState(183);
			((SecondPairContext)_localctx).tv = typeVariable();
			((SecondPairContext)_localctx).par = ((SecondPairContext)_localctx).tv.par;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type varType;
		public IntTypeContext it;
		public ObjTypeContext ot;
		public IntTypeContext intType() {
			return getRuleContext(IntTypeContext.class,0);
		}
		public ObjTypeContext objType() {
			return getRuleContext(ObjTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_type);
		try {
			setState(192);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				((TypeContext)_localctx).it = intType();
				((TypeContext)_localctx).varType =  ((TypeContext)_localctx).it.varType;
				}
				break;
			case IDUC:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				((TypeContext)_localctx).ot = objType();
				((TypeContext)_localctx).varType =  ((TypeContext)_localctx).ot.varType;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntTypeContext extends ParserRuleContext {
		public Type varType;
		public TerminalNode INT() { return getToken(gASPParser.INT, 0); }
		public IntTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterIntType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitIntType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntTypeContext intType() throws RecognitionException {
		IntTypeContext _localctx = new IntTypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_intType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(INT);
			((IntTypeContext)_localctx).varType =  new TypeInt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjTypeContext extends ParserRuleContext {
		public Type varType;
		public Token IDUC;
		public TerminalNode IDUC() { return getToken(gASPParser.IDUC, 0); }
		public ObjTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterObjType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitObjType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitObjType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjTypeContext objType() throws RecognitionException {
		ObjTypeContext _localctx = new ObjTypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_objType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			((ObjTypeContext)_localctx).IDUC = match(IDUC);
			((ObjTypeContext)_localctx).varType =  new TypeObject((((ObjTypeContext)_localctx).IDUC!=null?((ObjTypeContext)_localctx).IDUC.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public Variable var;
		public Token v;
		public TerminalNode IDLC() { return getToken(gASPParser.IDLC, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			((VariableContext)_localctx).v = match(IDLC);
			((VariableContext)_localctx).var =  new Variable((((VariableContext)_localctx).v!=null?((VariableContext)_localctx).v.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public Statement s;
		public SkipStmtContext sk;
		public AssignStmtContext as;
		public IfStmtContext ite;
		public ReturnStmtContext rt;
		public SkipStmtContext skipStmt() {
			return getRuleContext(SkipStmtContext.class,0);
		}
		public AssignStmtContext assignStmt() {
			return getRuleContext(AssignStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_stmt);
		try {
			setState(215);
			switch (_input.LA(1)) {
			case SKIP:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				((StmtContext)_localctx).sk = skipStmt();
				((StmtContext)_localctx).s =  ((StmtContext)_localctx).sk.s ;
				}
				break;
			case IDLC:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				((StmtContext)_localctx).as = assignStmt();
				((StmtContext)_localctx).s =  ((StmtContext)_localctx).as.s ;
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(209);
				((StmtContext)_localctx).ite = ifStmt();
				((StmtContext)_localctx).s =  ((StmtContext)_localctx).ite.s;
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 4);
				{
				setState(212);
				((StmtContext)_localctx).rt = returnStmt();
				((StmtContext)_localctx).s =  ((StmtContext)_localctx).rt.s ;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SkipStmtContext extends ParserRuleContext {
		public Statement s;
		public TerminalNode SKIP() { return getToken(gASPParser.SKIP, 0); }
		public TerminalNode SEMI() { return getToken(gASPParser.SEMI, 0); }
		public SkipStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skipStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterSkipStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitSkipStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitSkipStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkipStmtContext skipStmt() throws RecognitionException {
		SkipStmtContext _localctx = new SkipStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_skipStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(SKIP);
			setState(218);
			match(SEMI);
			((SkipStmtContext)_localctx).s =  new Skip();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignStmtContext extends ParserRuleContext {
		public Statement s;
		public Token l;
		public ExpressionSideEffectContext r;
		public TerminalNode ASSIGN() { return getToken(gASPParser.ASSIGN, 0); }
		public TerminalNode SEMI() { return getToken(gASPParser.SEMI, 0); }
		public TerminalNode IDLC() { return getToken(gASPParser.IDLC, 0); }
		public ExpressionSideEffectContext expressionSideEffect() {
			return getRuleContext(ExpressionSideEffectContext.class,0);
		}
		public AssignStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterAssignStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitAssignStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitAssignStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignStmtContext assignStmt() throws RecognitionException {
		AssignStmtContext _localctx = new AssignStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_assignStmt);
		  Variable var = null;
							       ExpressionSideEffects exprse = null; 
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			((AssignStmtContext)_localctx).l = match(IDLC);
			var = environment.getVar((((AssignStmtContext)_localctx).l!=null?((AssignStmtContext)_localctx).l.getText():null));
			setState(223);
			match(ASSIGN);
			setState(224);
			((AssignStmtContext)_localctx).r = expressionSideEffect();
			exprse = ((AssignStmtContext)_localctx).r.exprse;
			setState(226);
			match(SEMI);
			((AssignStmtContext)_localctx).s =  new Assignment(var,exprse);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStmtContext extends ParserRuleContext {
		public Statement s;
		public BooleanExpressionContext guard;
		public StmtContext trueSideS;
		public StmtblockContext trueSideSB;
		public ElseStmtContext els;
		public TerminalNode IF() { return getToken(gASPParser.IF, 0); }
		public TerminalNode LPAR() { return getToken(gASPParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(gASPParser.RPAR, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public StmtblockContext stmtblock() {
			return getRuleContext(StmtblockContext.class,0);
		}
		public ElseStmtContext elseStmt() {
			return getRuleContext(ElseStmtContext.class,0);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_ifStmt);
		  Expression cond = null;
							Statement stTrue = null;
							Statement stFalse = null; 
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(IF);
			setState(230);
			match(LPAR);
			{
			setState(231);
			((IfStmtContext)_localctx).guard = booleanExpression(0);
			cond = ((IfStmtContext)_localctx).guard.exprBool;
			}
			setState(234);
			match(RPAR);
			setState(241);
			switch (_input.LA(1)) {
			case IF:
			case RETURN:
			case SKIP:
			case IDLC:
				{
				setState(235);
				((IfStmtContext)_localctx).trueSideS = stmt();
				stTrue = ((IfStmtContext)_localctx).trueSideS.s;
				}
				break;
			case LCBRACK:
				{
				setState(238);
				((IfStmtContext)_localctx).trueSideSB = stmtblock();
				stTrue = ((IfStmtContext)_localctx).trueSideSB.stb;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(246);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(243);
				((IfStmtContext)_localctx).els = elseStmt();
				stFalse = ((IfStmtContext)_localctx).els.s;
				}
				break;
			}
			((IfStmtContext)_localctx).s =  new IfThenElse(cond,stTrue,stFalse);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseStmtContext extends ParserRuleContext {
		public Statement s;
		public StmtContext falseSideS;
		public StmtblockContext falseSideSB;
		public TerminalNode ELSE() { return getToken(gASPParser.ELSE, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public StmtblockContext stmtblock() {
			return getRuleContext(StmtblockContext.class,0);
		}
		public ElseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterElseStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitElseStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitElseStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStmtContext elseStmt() throws RecognitionException {
		ElseStmtContext _localctx = new ElseStmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_elseStmt);
		  Expression cond = null;
							Statement stTrue = null;
							Statement stFalse = null; 
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(250);
			match(ELSE);
			setState(257);
			switch (_input.LA(1)) {
			case IF:
			case RETURN:
			case SKIP:
			case IDLC:
				{
				setState(251);
				((ElseStmtContext)_localctx).falseSideS = stmt();
				((ElseStmtContext)_localctx).s =  ((ElseStmtContext)_localctx).falseSideS.s;
				}
				break;
			case LCBRACK:
				{
				setState(254);
				((ElseStmtContext)_localctx).falseSideSB = stmtblock();
				((ElseStmtContext)_localctx).s =  ((ElseStmtContext)_localctx).falseSideSB.stb;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStmtContext extends ParserRuleContext {
		public Statement s;
		public ExpressionContext e;
		public TerminalNode RETURN() { return getToken(gASPParser.RETURN, 0); }
		public TerminalNode SEMI() { return getToken(gASPParser.SEMI, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(RETURN);
			setState(260);
			((ReturnStmtContext)_localctx).e = expression();
			setState(261);
			match(SEMI);
			((ReturnStmtContext)_localctx).s =  new Return(((ReturnStmtContext)_localctx).e.expr);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtblockContext extends ParserRuleContext {
		public StmtBlock stb;
		public StmtContext st;
		public TerminalNode LCBRACK() { return getToken(gASPParser.LCBRACK, 0); }
		public TerminalNode RCBRACK() { return getToken(gASPParser.RCBRACK, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public StmtblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtblock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterStmtblock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitStmtblock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitStmtblock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtblockContext stmtblock() throws RecognitionException {
		StmtblockContext _localctx = new StmtblockContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_stmtblock);
		((StmtblockContext)_localctx).stb =  new StmtBlock();
						  		LinkedList<Statement> stmts = new LinkedList<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(LCBRACK);
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << RETURN) | (1L << SKIP) | (1L << IDLC))) != 0)) {
				{
				{
				setState(265);
				((StmtblockContext)_localctx).st = stmt();
				stmts.add(((StmtblockContext)_localctx).st.s);
				}
				}
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(273);
			match(RCBRACK);
			_localctx.stb.setStmts(stmts);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionSideEffectContext extends ParserRuleContext {
		public ExpressionSideEffects exprse;
		public ExpressionContext exp;
		public MethodCallContext mc;
		public NewExpContext newObj;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public NewExpContext newExp() {
			return getRuleContext(NewExpContext.class,0);
		}
		public ExpressionSideEffectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionSideEffect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterExpressionSideEffect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitExpressionSideEffect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitExpressionSideEffect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionSideEffectContext expressionSideEffect() throws RecognitionException {
		ExpressionSideEffectContext _localctx = new ExpressionSideEffectContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expressionSideEffect);
		LinkedList<Expression> param = new LinkedList<>();
									 	   Variable obj = null;
		try {
			setState(285);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(276);
				((ExpressionSideEffectContext)_localctx).exp = expression();
				((ExpressionSideEffectContext)_localctx).exprse =  ((ExpressionSideEffectContext)_localctx).exp.expr    ;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(279);
				((ExpressionSideEffectContext)_localctx).mc = methodCall();
				((ExpressionSideEffectContext)_localctx).exprse =  ((ExpressionSideEffectContext)_localctx).mc.expr     ;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(282);
				((ExpressionSideEffectContext)_localctx).newObj = newExp();
				((ExpressionSideEffectContext)_localctx).exprse =  ((ExpressionSideEffectContext)_localctx).newObj.expr ;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodCallContext extends ParserRuleContext {
		public ExpressionSideEffects expr;
		public ElementContext elem;
		public Token methodName;
		public ExpressionContext par;
		public TerminalNode DOT() { return getToken(gASPParser.DOT, 0); }
		public TerminalNode LPAR() { return getToken(gASPParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(gASPParser.RPAR, 0); }
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public TerminalNode IDLC() { return getToken(gASPParser.IDLC, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitMethodCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitMethodCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_methodCall);
		LinkedList<Expression> param = new LinkedList<>();
							 	 Variable obj = null;
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			((MethodCallContext)_localctx).elem = element();
			obj = environment.getVar((((MethodCallContext)_localctx).elem!=null?_input.getText(((MethodCallContext)_localctx).elem.start,((MethodCallContext)_localctx).elem.stop):null));
			setState(289);
			match(DOT);
			setState(290);
			((MethodCallContext)_localctx).methodName = match(IDLC);
			setState(291);
			match(LPAR);
			setState(297);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAR) | (1L << NULL) | (1L << THIS) | (1L << IDLC) | (1L << NUMBER))) != 0)) {
				{
				{
				setState(292);
				((MethodCallContext)_localctx).par = expression();
				param.add(((MethodCallContext)_localctx).par.expr);
				}
				}
				setState(299);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(300);
			match(RPAR);
			((MethodCallContext)_localctx).expr =  new MethodCall(obj,(((MethodCallContext)_localctx).methodName!=null?((MethodCallContext)_localctx).methodName.getText():null),param);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Expression expr;
		public ValueContext v;
		public ElementContext el;
		public ArithmeticExpressionContext expra;
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expression);
		try {
			setState(312);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(303);
				((ExpressionContext)_localctx).v = value();
				((ExpressionContext)_localctx).expr =  ((ExpressionContext)_localctx).v.val;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(306);
				((ExpressionContext)_localctx).el = element();
				((ExpressionContext)_localctx).expr =  ((ExpressionContext)_localctx).el.elem;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(309);
				((ExpressionContext)_localctx).expra = arithmeticExpression(0);
				((ExpressionContext)_localctx).expr =  ((ExpressionContext)_localctx).expra.exprArit;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewExpContext extends ParserRuleContext {
		public ExpressionSideEffects expr;
		public Token className;
		public ExpressionContext par;
		public TerminalNode NEW() { return getToken(gASPParser.NEW, 0); }
		public TerminalNode LPAR() { return getToken(gASPParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(gASPParser.RPAR, 0); }
		public TerminalNode IDUC() { return getToken(gASPParser.IDUC, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public NewExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterNewExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitNewExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitNewExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewExpContext newExp() throws RecognitionException {
		NewExpContext _localctx = new NewExpContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_newExp);
		LinkedList<Expression> param = new LinkedList<>();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(NEW);
			setState(315);
			((NewExpContext)_localctx).className = match(IDUC);
			setState(316);
			match(LPAR);
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAR) | (1L << NULL) | (1L << THIS) | (1L << IDLC) | (1L << NUMBER))) != 0)) {
				{
				{
				setState(317);
				((NewExpContext)_localctx).par = expression();
				param.add(((NewExpContext)_localctx).par.expr);
				}
				}
				setState(324);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(325);
			match(RPAR);
			((NewExpContext)_localctx).expr =  new New((((NewExpContext)_localctx).className!=null?((NewExpContext)_localctx).className.getText():null),param);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithmeticExpressionContext extends ParserRuleContext {
		public Expression exprArit;
		public ArithmeticExpressionContext l;
		public ValAritExpContext n;
		public VariableExpContext v;
		public Token o;
		public ArithmeticExpressionContext r;
		public ValAritExpContext valAritExp() {
			return getRuleContext(ValAritExpContext.class,0);
		}
		public VariableExpContext variableExp() {
			return getRuleContext(VariableExpContext.class,0);
		}
		public ParAritExpContext parAritExp() {
			return getRuleContext(ParAritExpContext.class,0);
		}
		public List<ArithmeticExpressionContext> arithmeticExpression() {
			return getRuleContexts(ArithmeticExpressionContext.class);
		}
		public ArithmeticExpressionContext arithmeticExpression(int i) {
			return getRuleContext(ArithmeticExpressionContext.class,i);
		}
		public ArithmeticExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterArithmeticExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitArithmeticExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitArithmeticExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticExpressionContext arithmeticExpression() throws RecognitionException {
		return arithmeticExpression(0);
	}

	private ArithmeticExpressionContext arithmeticExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArithmeticExpressionContext _localctx = new ArithmeticExpressionContext(_ctx, _parentState);
		ArithmeticExpressionContext _prevctx = _localctx;
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_arithmeticExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(329);
				((ArithmeticExpressionContext)_localctx).n = valAritExp();
				((ArithmeticExpressionContext)_localctx).exprArit =  ((ArithmeticExpressionContext)_localctx).n.exprArit  ;
				}
				break;
			case IDLC:
				{
				setState(332);
				((ArithmeticExpressionContext)_localctx).v = variableExp();
				((ArithmeticExpressionContext)_localctx).exprArit =  ((ArithmeticExpressionContext)_localctx).v.exprArit  ;
				}
				break;
			case LPAR:
				{
				setState(335);
				parAritExp();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(345);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArithmeticExpressionContext(_parentctx, _parentState);
					_localctx.l = _prevctx;
					_localctx.l = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_arithmeticExpression);
					setState(338);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(339);
					((ArithmeticExpressionContext)_localctx).o = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIV) | (1L << MINUS) | (1L << MULT) | (1L << PLUS))) != 0)) ) {
						((ArithmeticExpressionContext)_localctx).o = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(340);
					((ArithmeticExpressionContext)_localctx).r = arithmeticExpression(5);
					((ArithmeticExpressionContext)_localctx).exprArit =  new ExpressionBinaryOperation(((ArithmeticExpressionContext)_localctx).l.exprArit,(((ArithmeticExpressionContext)_localctx).o!=null?((ArithmeticExpressionContext)_localctx).o.getText():null),((ArithmeticExpressionContext)_localctx).r.exprArit);
					}
					} 
				}
				setState(347);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ValAritExpContext extends ParserRuleContext {
		public Expression exprArit;
		public Token n;
		public TerminalNode NUMBER() { return getToken(gASPParser.NUMBER, 0); }
		public ValAritExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valAritExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterValAritExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitValAritExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitValAritExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValAritExpContext valAritExp() throws RecognitionException {
		ValAritExpContext _localctx = new ValAritExpContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_valAritExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			((ValAritExpContext)_localctx).n = match(NUMBER);
			((ValAritExpContext)_localctx).exprArit =  new ExpressionIntValue(Integer.parseInt((((ValAritExpContext)_localctx).n!=null?((ValAritExpContext)_localctx).n.getText():null)));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableExpContext extends ParserRuleContext {
		public Expression exprArit;
		public Token v;
		public TerminalNode IDLC() { return getToken(gASPParser.IDLC, 0); }
		public VariableExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterVariableExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitVariableExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitVariableExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableExpContext variableExp() throws RecognitionException {
		VariableExpContext _localctx = new VariableExpContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_variableExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			((VariableExpContext)_localctx).v = match(IDLC);
			((VariableExpContext)_localctx).exprArit =  environment.getVar((((VariableExpContext)_localctx).v!=null?((VariableExpContext)_localctx).v.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParAritExpContext extends ParserRuleContext {
		public Expression exprArit;
		public TerminalNode LPAR() { return getToken(gASPParser.LPAR, 0); }
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(gASPParser.RPAR, 0); }
		public ParAritExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parAritExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterParAritExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitParAritExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitParAritExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParAritExpContext parAritExp() throws RecognitionException {
		ParAritExpContext _localctx = new ParAritExpContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_parAritExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(LPAR);
			setState(355);
			arithmeticExpression(0);
			setState(356);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanExpressionContext extends ParserRuleContext {
		public Expression exprBool;
		public BooleanExpressionContext l;
		public ArithmeticExpressionContext a;
		public ElementContext e;
		public Token o;
		public BooleanExpressionContext r;
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public List<BooleanExpressionContext> booleanExpression() {
			return getRuleContexts(BooleanExpressionContext.class);
		}
		public BooleanExpressionContext booleanExpression(int i) {
			return getRuleContext(BooleanExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(gASPParser.OR, 0); }
		public TerminalNode AND() { return getToken(gASPParser.AND, 0); }
		public TerminalNode EQUALS() { return getToken(gASPParser.EQUALS, 0); }
		public TerminalNode DISTINCT() { return getToken(gASPParser.DISTINCT, 0); }
		public TerminalNode GT() { return getToken(gASPParser.GT, 0); }
		public TerminalNode LT() { return getToken(gASPParser.LT, 0); }
		public TerminalNode GEG() { return getToken(gASPParser.GEG, 0); }
		public TerminalNode LEG() { return getToken(gASPParser.LEG, 0); }
		public BooleanExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterBooleanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitBooleanExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitBooleanExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanExpressionContext booleanExpression() throws RecognitionException {
		return booleanExpression(0);
	}

	private BooleanExpressionContext booleanExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BooleanExpressionContext _localctx = new BooleanExpressionContext(_ctx, _parentState);
		BooleanExpressionContext _prevctx = _localctx;
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_booleanExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(359);
				((BooleanExpressionContext)_localctx).a = arithmeticExpression(0);
				((BooleanExpressionContext)_localctx).exprBool = ((BooleanExpressionContext)_localctx).a.exprArit;
				}
				break;
			case 2:
				{
				setState(362);
				((BooleanExpressionContext)_localctx).e = element();
				((BooleanExpressionContext)_localctx).exprBool = ((BooleanExpressionContext)_localctx).e.elem;
				}
				break;
			case 3:
				{
				setState(365);
				match(LPAR);
				setState(366);
				booleanExpression(0);
				setState(367);
				match(RPAR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(378);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BooleanExpressionContext(_parentctx, _parentState);
					_localctx.l = _prevctx;
					_localctx.l = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_booleanExpression);
					setState(371);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(372);
					((BooleanExpressionContext)_localctx).o = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << DISTINCT) | (1L << EQUALS) | (1L << GEG) | (1L << GT) | (1L << LEG) | (1L << LT) | (1L << OR))) != 0)) ) {
						((BooleanExpressionContext)_localctx).o = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(373);
					((BooleanExpressionContext)_localctx).r = booleanExpression(5);
					((BooleanExpressionContext)_localctx).exprBool =  new ExpressionBinaryOperation(((BooleanExpressionContext)_localctx).l.exprBool,(((BooleanExpressionContext)_localctx).o!=null?((BooleanExpressionContext)_localctx).o.getText():null),((BooleanExpressionContext)_localctx).r.exprBool);
					}
					} 
				}
				setState(380);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public ExpressionValue val;
		public Token n;
		public TerminalNode NULL() { return getToken(gASPParser.NULL, 0); }
		public TerminalNode NUMBER() { return getToken(gASPParser.NUMBER, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_value);
		try {
			setState(385);
			switch (_input.LA(1)) {
			case NULL:
				enterOuterAlt(_localctx, 1);
				{
				setState(381);
				match(NULL);
				((ValueContext)_localctx).val =  new ExpressionNullValue();
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(383);
				((ValueContext)_localctx).n = match(NUMBER);
				((ValueContext)_localctx).val =  new ExpressionIntValue(Integer.parseInt((((ValueContext)_localctx).n!=null?((ValueContext)_localctx).n.getText():null)));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementContext extends ParserRuleContext {
		public Element elem;
		public Token IDLC;
		public Token t;
		public TerminalNode IDLC() { return getToken(gASPParser.IDLC, 0); }
		public TerminalNode THIS() { return getToken(gASPParser.THIS, 0); }
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gASPListener ) ((gASPListener)listener).exitElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gASPVisitor ) return ((gASPVisitor<? extends T>)visitor).visitElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_element);
		try {
			setState(391);
			switch (_input.LA(1)) {
			case IDLC:
				enterOuterAlt(_localctx, 1);
				{
				setState(387);
				((ElementContext)_localctx).IDLC = match(IDLC);
				((ElementContext)_localctx).elem =  environment.getVar((((ElementContext)_localctx).IDLC!=null?((ElementContext)_localctx).IDLC.getText():null));
				}
				break;
			case THIS:
				enterOuterAlt(_localctx, 2);
				{
				setState(389);
				((ElementContext)_localctx).t = match(THIS);
				((ElementContext)_localctx).elem =  new ExpressionValue((((ElementContext)_localctx).t!=null?((ElementContext)_localctx).t.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 28:
			return arithmeticExpression_sempred((ArithmeticExpressionContext)_localctx, predIndex);
		case 32:
			return booleanExpression_sempred((BooleanExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean arithmeticExpression_sempred(ArithmeticExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean booleanExpression_sempred(BooleanExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3)\u018c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\2\3\2\3\2\7\2O\n\2\f\2\16\2R\13"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\7\4g\n\4\f\4\16\4j\13\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u0084\n"+
		"\7\f\7\16\7\u0087\13\7\3\7\3\7\3\7\3\b\3\b\3\b\7\b\u008f\n\b\f\b\16\b"+
		"\u0092\13\b\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u009a\n\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\5\f\u00ab\n\f\3\f\3\f"+
		"\3\f\7\f\u00b0\n\f\f\f\16\f\u00b3\13\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00c3\n\17\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\5\23\u00da\n\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\5\26\u00f4\n\26\3\26\3\26\3\26\5\26\u00f9\n\26\3\26\3\26\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0104\n\27\3\30\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\7\31\u010f\n\31\f\31\16\31\u0112\13\31\3\31"+
		"\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0120\n\32"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u012a\n\33\f\33\16\33\u012d"+
		"\13\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34"+
		"\u013b\n\34\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u0143\n\35\f\35\16\35\u0146"+
		"\13\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0153"+
		"\n\36\3\36\3\36\3\36\3\36\3\36\7\36\u015a\n\36\f\36\16\36\u015d\13\36"+
		"\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\5\"\u0174\n\"\3\"\3\"\3\"\3\"\3\"\7\"\u017b\n\"\f\"\16\"\u017e"+
		"\13\"\3#\3#\3#\3#\5#\u0184\n#\3$\3$\3$\3$\5$\u018a\n$\3$\2\4:B%\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDF\2\4\6\2"+
		"\t\t\26\26\30\30\34\34\b\2\3\3\b\b\f\16\22\22\25\25\33\33\u0185\2H\3\2"+
		"\2\2\4V\3\2\2\2\6^\3\2\2\2\bn\3\2\2\2\nw\3\2\2\2\f|\3\2\2\2\16\u0090\3"+
		"\2\2\2\20\u0099\3\2\2\2\22\u009b\3\2\2\2\24\u00a0\3\2\2\2\26\u00aa\3\2"+
		"\2\2\30\u00b4\3\2\2\2\32\u00b8\3\2\2\2\34\u00c2\3\2\2\2\36\u00c4\3\2\2"+
		"\2 \u00c7\3\2\2\2\"\u00ca\3\2\2\2$\u00d9\3\2\2\2&\u00db\3\2\2\2(\u00df"+
		"\3\2\2\2*\u00e7\3\2\2\2,\u00fc\3\2\2\2.\u0105\3\2\2\2\60\u010a\3\2\2\2"+
		"\62\u011f\3\2\2\2\64\u0121\3\2\2\2\66\u013a\3\2\2\28\u013c\3\2\2\2:\u0152"+
		"\3\2\2\2<\u015e\3\2\2\2>\u0161\3\2\2\2@\u0164\3\2\2\2B\u0173\3\2\2\2D"+
		"\u0183\3\2\2\2F\u0189\3\2\2\2HI\7\27\2\2IJ\7$\2\2JP\7!\2\2KL\5\6\4\2L"+
		"M\b\2\1\2MO\3\2\2\2NK\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QS\3\2\2\2"+
		"RP\3\2\2\2ST\5\f\7\2TU\b\2\1\2U\3\3\2\2\2VW\7\5\2\2WX\7$\2\2XY\b\3\1\2"+
		"YZ\7\23\2\2Z[\5\26\f\2[\\\b\3\1\2\\]\7\37\2\2]\5\3\2\2\2^_\5\4\3\2_`\b"+
		"\4\1\2`a\7\21\2\2ab\5\16\b\2bh\b\4\1\2cd\5\n\6\2de\b\4\1\2eg\3\2\2\2f"+
		"c\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2ik\3\2\2\2jh\3\2\2\2kl\7\35\2\2"+
		"lm\b\4\1\2m\7\3\2\2\2no\5\34\17\2op\b\5\1\2pq\7%\2\2qr\b\5\1\2rs\7\23"+
		"\2\2st\5\26\f\2tu\b\5\1\2uv\7\37\2\2v\t\3\2\2\2wx\5\b\5\2xy\b\6\1\2yz"+
		"\5\f\7\2z{\b\6\1\2{\13\3\2\2\2|}\7\21\2\2}~\5\16\b\2~\177\b\7\1\2\177"+
		"\u0085\3\2\2\2\u0080\u0081\5$\23\2\u0081\u0082\b\7\1\2\u0082\u0084\3\2"+
		"\2\2\u0083\u0080\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0088\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u0089\7\35"+
		"\2\2\u0089\u008a\b\7\1\2\u008a\r\3\2\2\2\u008b\u008c\5\20\t\2\u008c\u008d"+
		"\b\b\1\2\u008d\u008f\3\2\2\2\u008e\u008b\3\2\2\2\u008f\u0092\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\17\3\2\2\2\u0092\u0090\3\2\2"+
		"\2\u0093\u0094\5\22\n\2\u0094\u0095\b\t\1\2\u0095\u009a\3\2\2\2\u0096"+
		"\u0097\5\24\13\2\u0097\u0098\b\t\1\2\u0098\u009a\3\2\2\2\u0099\u0093\3"+
		"\2\2\2\u0099\u0096\3\2\2\2\u009a\21\3\2\2\2\u009b\u009c\5 \21\2\u009c"+
		"\u009d\5\"\22\2\u009d\u009e\7!\2\2\u009e\u009f\b\n\1\2\u009f\23\3\2\2"+
		"\2\u00a0\u00a1\5\36\20\2\u00a1\u00a2\5\"\22\2\u00a2\u00a3\7\4\2\2\u00a3"+
		"\u00a4\7&\2\2\u00a4\u00a5\7!\2\2\u00a5\u00a6\b\13\1\2\u00a6\25\3\2\2\2"+
		"\u00a7\u00a8\5\30\r\2\u00a8\u00a9\b\f\1\2\u00a9\u00ab\3\2\2\2\u00aa\u00a7"+
		"\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00b1\3\2\2\2\u00ac\u00ad\5\32\16\2"+
		"\u00ad\u00ae\b\f\1\2\u00ae\u00b0\3\2\2\2\u00af\u00ac\3\2\2\2\u00b0\u00b3"+
		"\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\27\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b4\u00b5\5\34\17\2\u00b5\u00b6\5\"\22\2\u00b6\u00b7"+
		"\b\r\1\2\u00b7\31\3\2\2\2\u00b8\u00b9\7\7\2\2\u00b9\u00ba\5\30\r\2\u00ba"+
		"\u00bb\b\16\1\2\u00bb\33\3\2\2\2\u00bc\u00bd\5\36\20\2\u00bd\u00be\b\17"+
		"\1\2\u00be\u00c3\3\2\2\2\u00bf\u00c0\5 \21\2\u00c0\u00c1\b\17\1\2\u00c1"+
		"\u00c3\3\2\2\2\u00c2\u00bc\3\2\2\2\u00c2\u00bf\3\2\2\2\u00c3\35\3\2\2"+
		"\2\u00c4\u00c5\7\20\2\2\u00c5\u00c6\b\20\1\2\u00c6\37\3\2\2\2\u00c7\u00c8"+
		"\7$\2\2\u00c8\u00c9\b\21\1\2\u00c9!\3\2\2\2\u00ca\u00cb\7%\2\2\u00cb\u00cc"+
		"\b\22\1\2\u00cc#\3\2\2\2\u00cd\u00ce\5&\24\2\u00ce\u00cf\b\23\1\2\u00cf"+
		"\u00da\3\2\2\2\u00d0\u00d1\5(\25\2\u00d1\u00d2\b\23\1\2\u00d2\u00da\3"+
		"\2\2\2\u00d3\u00d4\5*\26\2\u00d4\u00d5\b\23\1\2\u00d5\u00da\3\2\2\2\u00d6"+
		"\u00d7\5.\30\2\u00d7\u00d8\b\23\1\2\u00d8\u00da\3\2\2\2\u00d9\u00cd\3"+
		"\2\2\2\u00d9\u00d0\3\2\2\2\u00d9\u00d3\3\2\2\2\u00d9\u00d6\3\2\2\2\u00da"+
		"%\3\2\2\2\u00db\u00dc\7\"\2\2\u00dc\u00dd\7!\2\2\u00dd\u00de\b\24\1\2"+
		"\u00de\'\3\2\2\2\u00df\u00e0\7%\2\2\u00e0\u00e1\b\25\1\2\u00e1\u00e2\7"+
		"\4\2\2\u00e2\u00e3\5\62\32\2\u00e3\u00e4\b\25\1\2\u00e4\u00e5\7!\2\2\u00e5"+
		"\u00e6\b\25\1\2\u00e6)\3\2\2\2\u00e7\u00e8\7\17\2\2\u00e8\u00e9\7\23\2"+
		"\2\u00e9\u00ea\5B\"\2\u00ea\u00eb\b\26\1\2\u00eb\u00ec\3\2\2\2\u00ec\u00f3"+
		"\7\37\2\2\u00ed\u00ee\5$\23\2\u00ee\u00ef\b\26\1\2\u00ef\u00f4\3\2\2\2"+
		"\u00f0\u00f1\5\60\31\2\u00f1\u00f2\b\26\1\2\u00f2\u00f4\3\2\2\2\u00f3"+
		"\u00ed\3\2\2\2\u00f3\u00f0\3\2\2\2\u00f4\u00f8\3\2\2\2\u00f5\u00f6\5,"+
		"\27\2\u00f6\u00f7\b\26\1\2\u00f7\u00f9\3\2\2\2\u00f8\u00f5\3\2\2\2\u00f8"+
		"\u00f9\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\b\26\1\2\u00fb+\3\2\2\2"+
		"\u00fc\u0103\7\13\2\2\u00fd\u00fe\5$\23\2\u00fe\u00ff\b\27\1\2\u00ff\u0104"+
		"\3\2\2\2\u0100\u0101\5\60\31\2\u0101\u0102\b\27\1\2\u0102\u0104\3\2\2"+
		"\2\u0103\u00fd\3\2\2\2\u0103\u0100\3\2\2\2\u0104-\3\2\2\2\u0105\u0106"+
		"\7\36\2\2\u0106\u0107\5\66\34\2\u0107\u0108\7!\2\2\u0108\u0109\b\30\1"+
		"\2\u0109/\3\2\2\2\u010a\u0110\7\21\2\2\u010b\u010c\5$\23\2\u010c\u010d"+
		"\b\31\1\2\u010d\u010f\3\2\2\2\u010e\u010b\3\2\2\2\u010f\u0112\3\2\2\2"+
		"\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0113\3\2\2\2\u0112\u0110"+
		"\3\2\2\2\u0113\u0114\7\35\2\2\u0114\u0115\b\31\1\2\u0115\61\3\2\2\2\u0116"+
		"\u0117\5\66\34\2\u0117\u0118\b\32\1\2\u0118\u0120\3\2\2\2\u0119\u011a"+
		"\5\64\33\2\u011a\u011b\b\32\1\2\u011b\u0120\3\2\2\2\u011c\u011d\58\35"+
		"\2\u011d\u011e\b\32\1\2\u011e\u0120\3\2\2\2\u011f\u0116\3\2\2\2\u011f"+
		"\u0119\3\2\2\2\u011f\u011c\3\2\2\2\u0120\63\3\2\2\2\u0121\u0122\5F$\2"+
		"\u0122\u0123\b\33\1\2\u0123\u0124\7\n\2\2\u0124\u0125\7%\2\2\u0125\u012b"+
		"\7\23\2\2\u0126\u0127\5\66\34\2\u0127\u0128\b\33\1\2\u0128\u012a\3\2\2"+
		"\2\u0129\u0126\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c"+
		"\3\2\2\2\u012c\u012e\3\2\2\2\u012d\u012b\3\2\2\2\u012e\u012f\7\37\2\2"+
		"\u012f\u0130\b\33\1\2\u0130\65\3\2\2\2\u0131\u0132\5D#\2\u0132\u0133\b"+
		"\34\1\2\u0133\u013b\3\2\2\2\u0134\u0135\5F$\2\u0135\u0136\b\34\1\2\u0136"+
		"\u013b\3\2\2\2\u0137\u0138\5:\36\2\u0138\u0139\b\34\1\2\u0139\u013b\3"+
		"\2\2\2\u013a\u0131\3\2\2\2\u013a\u0134\3\2\2\2\u013a\u0137\3\2\2\2\u013b"+
		"\67\3\2\2\2\u013c\u013d\7\31\2\2\u013d\u013e\7$\2\2\u013e\u0144\7\23\2"+
		"\2\u013f\u0140\5\66\34\2\u0140\u0141\b\35\1\2\u0141\u0143\3\2\2\2\u0142"+
		"\u013f\3\2\2\2\u0143\u0146\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2"+
		"\2\2\u0145\u0147\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u0148\7\37\2\2\u0148"+
		"\u0149\b\35\1\2\u01499\3\2\2\2\u014a\u014b\b\36\1\2\u014b\u014c\5<\37"+
		"\2\u014c\u014d\b\36\1\2\u014d\u0153\3\2\2\2\u014e\u014f\5> \2\u014f\u0150"+
		"\b\36\1\2\u0150\u0153\3\2\2\2\u0151\u0153\5@!\2\u0152\u014a\3\2\2\2\u0152"+
		"\u014e\3\2\2\2\u0152\u0151\3\2\2\2\u0153\u015b\3\2\2\2\u0154\u0155\f\6"+
		"\2\2\u0155\u0156\t\2\2\2\u0156\u0157\5:\36\7\u0157\u0158\b\36\1\2\u0158"+
		"\u015a\3\2\2\2\u0159\u0154\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2"+
		"\2\2\u015b\u015c\3\2\2\2\u015c;\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u015f"+
		"\7&\2\2\u015f\u0160\b\37\1\2\u0160=\3\2\2\2\u0161\u0162\7%\2\2\u0162\u0163"+
		"\b \1\2\u0163?\3\2\2\2\u0164\u0165\7\23\2\2\u0165\u0166\5:\36\2\u0166"+
		"\u0167\7\37\2\2\u0167A\3\2\2\2\u0168\u0169\b\"\1\2\u0169\u016a\5:\36\2"+
		"\u016a\u016b\b\"\1\2\u016b\u0174\3\2\2\2\u016c\u016d\5F$\2\u016d\u016e"+
		"\b\"\1\2\u016e\u0174\3\2\2\2\u016f\u0170\7\23\2\2\u0170\u0171\5B\"\2\u0171"+
		"\u0172\7\37\2\2\u0172\u0174\3\2\2\2\u0173\u0168\3\2\2\2\u0173\u016c\3"+
		"\2\2\2\u0173\u016f\3\2\2\2\u0174\u017c\3\2\2\2\u0175\u0176\f\6\2\2\u0176"+
		"\u0177\t\3\2\2\u0177\u0178\5B\"\7\u0178\u0179\b\"\1\2\u0179\u017b\3\2"+
		"\2\2\u017a\u0175\3\2\2\2\u017b\u017e\3\2\2\2\u017c\u017a\3\2\2\2\u017c"+
		"\u017d\3\2\2\2\u017dC\3\2\2\2\u017e\u017c\3\2\2\2\u017f\u0180\7\32\2\2"+
		"\u0180\u0184\b#\1\2\u0181\u0182\7&\2\2\u0182\u0184\b#\1\2\u0183\u017f"+
		"\3\2\2\2\u0183\u0181\3\2\2\2\u0184E\3\2\2\2\u0185\u0186\7%\2\2\u0186\u018a"+
		"\b$\1\2\u0187\u0188\7#\2\2\u0188\u018a\b$\1\2\u0189\u0185\3\2\2\2\u0189"+
		"\u0187\3\2\2\2\u018aG\3\2\2\2\31Ph\u0085\u0090\u0099\u00aa\u00b1\u00c2"+
		"\u00d9\u00f3\u00f8\u0103\u0110\u011f\u012b\u013a\u0144\u0152\u015b\u0173"+
		"\u017c\u0183\u0189";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}