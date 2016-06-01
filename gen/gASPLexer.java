// Generated from /Users/vmastand/GitHub/DeadlockTool/src/gASP.g4 by ANTLR 4.5.1

import models.*;
import java.util.HashMap;
import java.util.LinkedList;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gASPLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"AND", "ASSIGN", "CLASS", "COLON", "COMMA", "DISTINCT", "DIV", "DOT", 
		"ELSE", "EQUALS", "GEG", "GT", "IF", "INT", "LCBRACK", "LEG", "LPAR", 
		"LSBRACK", "LT", "MINUS", "MOD", "MULT", "NEW", "NULL", "OR", "PLUS", 
		"RCBRACK", "RETURN", "RPAR", "RSBRACK", "SEMI", "SKIP", "THIS", "CHAR", 
		"CHARU", "CHARUC", "CHARLC", "IDUC", "IDLC", "DIGIT", "NUMBER", "WS", 
		"LINECOMENTS", "BLOCKCOMENTS"
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


		public HashMap<String, ClassDecl> classTable;
		public ClassDecl currentClass;
		public Method currentMethod;
		public Environment environment;


	public gASPLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "gASP.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2)\u0103\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36"+
		"\3\36\3\37\3\37\3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3$\3$\3"+
		"%\3%\3&\3&\3\'\3\'\3\'\7\'\u00ce\n\'\f\'\16\'\u00d1\13\'\3(\3(\3(\7(\u00d6"+
		"\n(\f(\16(\u00d9\13(\3)\3)\3*\6*\u00de\n*\r*\16*\u00df\3+\3+\3+\3+\3,"+
		"\3,\3,\3,\7,\u00ea\n,\f,\16,\u00ed\13,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\3"+
		"-\7-\u00fa\n-\f-\16-\u00fd\13-\3-\3-\3-\3-\3-\2\2.\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E\2G\2I\2"+
		"K\2M$O%Q\2S&U\'W(Y)\3\2\t\4\2C\\c|\5\2C\\aac|\5\2\13\f\17\17\"\"\4\2\f"+
		"\f\17\17\4\2,,\61\61\3\2,,\3\2\61\61\u0107\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W"+
		"\3\2\2\2\2Y\3\2\2\2\3[\3\2\2\2\5^\3\2\2\2\7`\3\2\2\2\tf\3\2\2\2\13h\3"+
		"\2\2\2\rj\3\2\2\2\17m\3\2\2\2\21o\3\2\2\2\23q\3\2\2\2\25v\3\2\2\2\27y"+
		"\3\2\2\2\31|\3\2\2\2\33~\3\2\2\2\35\u0081\3\2\2\2\37\u0085\3\2\2\2!\u0087"+
		"\3\2\2\2#\u008a\3\2\2\2%\u008c\3\2\2\2\'\u008e\3\2\2\2)\u0090\3\2\2\2"+
		"+\u0092\3\2\2\2-\u0099\3\2\2\2/\u009b\3\2\2\2\61\u009f\3\2\2\2\63\u00a4"+
		"\3\2\2\2\65\u00a7\3\2\2\2\67\u00a9\3\2\2\29\u00ab\3\2\2\2;\u00b2\3\2\2"+
		"\2=\u00b4\3\2\2\2?\u00b6\3\2\2\2A\u00b8\3\2\2\2C\u00bd\3\2\2\2E\u00c2"+
		"\3\2\2\2G\u00c4\3\2\2\2I\u00c6\3\2\2\2K\u00c8\3\2\2\2M\u00ca\3\2\2\2O"+
		"\u00d2\3\2\2\2Q\u00da\3\2\2\2S\u00dd\3\2\2\2U\u00e1\3\2\2\2W\u00e5\3\2"+
		"\2\2Y\u00f0\3\2\2\2[\\\7(\2\2\\]\7(\2\2]\4\3\2\2\2^_\7?\2\2_\6\3\2\2\2"+
		"`a\7e\2\2ab\7n\2\2bc\7c\2\2cd\7u\2\2de\7u\2\2e\b\3\2\2\2fg\7<\2\2g\n\3"+
		"\2\2\2hi\7.\2\2i\f\3\2\2\2jk\7#\2\2kl\7?\2\2l\16\3\2\2\2mn\7\61\2\2n\20"+
		"\3\2\2\2op\7\60\2\2p\22\3\2\2\2qr\7g\2\2rs\7n\2\2st\7u\2\2tu\7g\2\2u\24"+
		"\3\2\2\2vw\7?\2\2wx\7?\2\2x\26\3\2\2\2yz\7@\2\2z{\7?\2\2{\30\3\2\2\2|"+
		"}\7@\2\2}\32\3\2\2\2~\177\7k\2\2\177\u0080\7h\2\2\u0080\34\3\2\2\2\u0081"+
		"\u0082\7K\2\2\u0082\u0083\7p\2\2\u0083\u0084\7v\2\2\u0084\36\3\2\2\2\u0085"+
		"\u0086\7}\2\2\u0086 \3\2\2\2\u0087\u0088\7>\2\2\u0088\u0089\7?\2\2\u0089"+
		"\"\3\2\2\2\u008a\u008b\7*\2\2\u008b$\3\2\2\2\u008c\u008d\7]\2\2\u008d"+
		"&\3\2\2\2\u008e\u008f\7>\2\2\u008f(\3\2\2\2\u0090\u0091\7/\2\2\u0091*"+
		"\3\2\2\2\u0092\u0093\7o\2\2\u0093\u0094\7q\2\2\u0094\u0095\7f\2\2\u0095"+
		"\u0096\7w\2\2\u0096\u0097\7n\2\2\u0097\u0098\7g\2\2\u0098,\3\2\2\2\u0099"+
		"\u009a\7,\2\2\u009a.\3\2\2\2\u009b\u009c\7p\2\2\u009c\u009d\7g\2\2\u009d"+
		"\u009e\7y\2\2\u009e\60\3\2\2\2\u009f\u00a0\7p\2\2\u00a0\u00a1\7w\2\2\u00a1"+
		"\u00a2\7n\2\2\u00a2\u00a3\7n\2\2\u00a3\62\3\2\2\2\u00a4\u00a5\7~\2\2\u00a5"+
		"\u00a6\7~\2\2\u00a6\64\3\2\2\2\u00a7\u00a8\7-\2\2\u00a8\66\3\2\2\2\u00a9"+
		"\u00aa\7\177\2\2\u00aa8\3\2\2\2\u00ab\u00ac\7t\2\2\u00ac\u00ad\7g\2\2"+
		"\u00ad\u00ae\7v\2\2\u00ae\u00af\7w\2\2\u00af\u00b0\7t\2\2\u00b0\u00b1"+
		"\7p\2\2\u00b1:\3\2\2\2\u00b2\u00b3\7+\2\2\u00b3<\3\2\2\2\u00b4\u00b5\7"+
		"_\2\2\u00b5>\3\2\2\2\u00b6\u00b7\7=\2\2\u00b7@\3\2\2\2\u00b8\u00b9\7u"+
		"\2\2\u00b9\u00ba\7m\2\2\u00ba\u00bb\7k\2\2\u00bb\u00bc\7r\2\2\u00bcB\3"+
		"\2\2\2\u00bd\u00be\7v\2\2\u00be\u00bf\7j\2\2\u00bf\u00c0\7k\2\2\u00c0"+
		"\u00c1\7u\2\2\u00c1D\3\2\2\2\u00c2\u00c3\t\2\2\2\u00c3F\3\2\2\2\u00c4"+
		"\u00c5\t\3\2\2\u00c5H\3\2\2\2\u00c6\u00c7\4C\\\2\u00c7J\3\2\2\2\u00c8"+
		"\u00c9\4c|\2\u00c9L\3\2\2\2\u00ca\u00cf\5I%\2\u00cb\u00ce\5G$\2\u00cc"+
		"\u00ce\5Q)\2\u00cd\u00cb\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce\u00d1\3\2\2"+
		"\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0N\3\2\2\2\u00d1\u00cf"+
		"\3\2\2\2\u00d2\u00d7\5K&\2\u00d3\u00d6\5G$\2\u00d4\u00d6\5Q)\2\u00d5\u00d3"+
		"\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8P\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00db\4\62;\2"+
		"\u00dbR\3\2\2\2\u00dc\u00de\5Q)\2\u00dd\u00dc\3\2\2\2\u00de\u00df\3\2"+
		"\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0T\3\2\2\2\u00e1\u00e2"+
		"\t\4\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\b+\2\2\u00e4V\3\2\2\2\u00e5\u00e6"+
		"\7\61\2\2\u00e6\u00e7\7\61\2\2\u00e7\u00eb\3\2\2\2\u00e8\u00ea\n\5\2\2"+
		"\u00e9\u00e8\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec"+
		"\3\2\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00ef\b,\2\2\u00ef"+
		"X\3\2\2\2\u00f0\u00f1\7\61\2\2\u00f1\u00f2\7,\2\2\u00f2\u00fb\3\2\2\2"+
		"\u00f3\u00fa\n\6\2\2\u00f4\u00f5\7\61\2\2\u00f5\u00fa\n\7\2\2\u00f6\u00f7"+
		"\7,\2\2\u00f7\u00fa\n\b\2\2\u00f8\u00fa\5Y-\2\u00f9\u00f3\3\2\2\2\u00f9"+
		"\u00f4\3\2\2\2\u00f9\u00f6\3\2\2\2\u00f9\u00f8\3\2\2\2\u00fa\u00fd\3\2"+
		"\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fe\3\2\2\2\u00fd"+
		"\u00fb\3\2\2\2\u00fe\u00ff\7,\2\2\u00ff\u0100\7\61\2\2\u0100\u0101\3\2"+
		"\2\2\u0101\u0102\b-\2\2\u0102Z\3\2\2\2\13\2\u00cd\u00cf\u00d5\u00d7\u00df"+
		"\u00eb\u00f9\u00fb\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}