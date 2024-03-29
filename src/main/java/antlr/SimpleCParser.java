// Generated from java-escape by ANTLR 4.11.1
 package antlr; 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SimpleCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, IDENTIFIER=30, UNSIGNED_INTEGER=31, 
		INTEGER=32, BOOL=33, WS=34;
	public static final int
		RULE_translationUnit = 0, RULE_funDef = 1, RULE_funArg = 2, RULE_type = 3, 
		RULE_block = 4, RULE_expr = 5, RULE_ifExpr = 6, RULE_ifFollowUp = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"translationUnit", "funDef", "funArg", "type", "block", "expr", "ifExpr", 
			"ifFollowUp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'fn'", "'('", "','", "')'", "':'", "'void'", "'int'", "'uint'", 
			"'bool'", "'['", "';'", "']'", "'{'", "'}'", "'return'", "'for'", "'in'", 
			"'..'", "'while'", "'let '", "'='", "'-'", "'+'", "'*'", "'/'", "'<'", 
			"'>'", "'if'", "'else'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "IDENTIFIER", "UNSIGNED_INTEGER", 
			"INTEGER", "BOOL", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TranslationUnitContext extends ParserRuleContext {
		public List<FunDefContext> funDef() {
			return getRuleContexts(FunDefContext.class);
		}
		public FunDefContext funDef(int i) {
			return getRuleContext(FunDefContext.class,i);
		}
		public TranslationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_translationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterTranslationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitTranslationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitTranslationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TranslationUnitContext translationUnit() throws RecognitionException {
		TranslationUnitContext _localctx = new TranslationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_translationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(16);
				funDef();
				}
				}
				setState(19); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunDefContext extends ParserRuleContext {
		public Token name;
		public FunArgContext funArg;
		public List<FunArgContext> args = new ArrayList<FunArgContext>();
		public TypeContext returnType;
		public BlockContext body;
		public TerminalNode IDENTIFIER() { return getToken(SimpleCParser.IDENTIFIER, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<FunArgContext> funArg() {
			return getRuleContexts(FunArgContext.class);
		}
		public FunArgContext funArg(int i) {
			return getRuleContext(FunArgContext.class,i);
		}
		public FunDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterFunDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitFunDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitFunDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunDefContext funDef() throws RecognitionException {
		FunDefContext _localctx = new FunDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_funDef);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			match(T__0);
			setState(22);
			((FunDefContext)_localctx).name = match(IDENTIFIER);
			setState(23);
			match(T__1);
			setState(29);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(24);
					((FunDefContext)_localctx).funArg = funArg();
					((FunDefContext)_localctx).args.add(((FunDefContext)_localctx).funArg);
					setState(25);
					match(T__2);
					}
					} 
				}
				setState(31);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(32);
				((FunDefContext)_localctx).funArg = funArg();
				((FunDefContext)_localctx).args.add(((FunDefContext)_localctx).funArg);
				}
			}

			setState(35);
			match(T__3);
			setState(36);
			match(T__4);
			setState(37);
			((FunDefContext)_localctx).returnType = type();
			setState(38);
			((FunDefContext)_localctx).body = block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunArgContext extends ParserRuleContext {
		public Token name;
		public TypeContext argType;
		public TerminalNode IDENTIFIER() { return getToken(SimpleCParser.IDENTIFIER, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FunArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterFunArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitFunArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitFunArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunArgContext funArg() throws RecognitionException {
		FunArgContext _localctx = new FunArgContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funArg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			((FunArgContext)_localctx).name = match(IDENTIFIER);
			setState(41);
			match(T__4);
			setState(42);
			((FunArgContext)_localctx).argType = type();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VoidTypeContext extends TypeContext {
		public VoidTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterVoidType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitVoidType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitVoidType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayTypeContext extends TypeContext {
		public TypeContext elemType;
		public Token size;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode UNSIGNED_INTEGER() { return getToken(SimpleCParser.UNSIGNED_INTEGER, 0); }
		public ArrayTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolTypeContext extends TypeContext {
		public BoolTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterBoolType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitBoolType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitBoolType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UintTypeContext extends TypeContext {
		public UintTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterUintType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitUintType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitUintType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntTypeContext extends TypeContext {
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterIntType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitIntType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		try {
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				_localctx = new VoidTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				match(T__5);
				}
				break;
			case T__6:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				match(T__6);
				}
				break;
			case T__7:
				_localctx = new UintTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				match(T__7);
				}
				break;
			case T__8:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(47);
				match(T__8);
				}
				break;
			case T__9:
				_localctx = new ArrayTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(48);
				match(T__9);
				setState(49);
				((ArrayTypeContext)_localctx).elemType = type();
				setState(50);
				match(T__10);
				setState(51);
				((ArrayTypeContext)_localctx).size = match(UNSIGNED_INTEGER);
				setState(52);
				match(T__11);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public ExprContext expr;
		public List<ExprContext> statements = new ArrayList<ExprContext>();
		public ExprContext lastexpr;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(T__12);
			setState(62);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(57);
					((BlockContext)_localctx).expr = expr(0);
					((BlockContext)_localctx).statements.add(((BlockContext)_localctx).expr);
					setState(58);
					match(T__10);
					}
					} 
				}
				setState(64);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 16380428292L) != 0) {
				{
				setState(65);
				((BlockContext)_localctx).lastexpr = expr(0);
				}
			}

			setState(68);
			match(T__13);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfstatementExprContext extends ExprContext {
		public IfExprContext ifExpr() {
			return getRuleContext(IfExprContext.class,0);
		}
		public IfstatementExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterIfstatementExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitIfstatementExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitIfstatementExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileExprContext extends ExprContext {
		public ExprContext condition;
		public BlockContext body;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterWhileExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitWhileExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitWhileExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulExprContext extends ExprContext {
		public ExprContext lhs;
		public ExprContext rhs;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MulExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterMulExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitMulExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitMulExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolExprContext extends ExprContext {
		public TerminalNode BOOL() { return getToken(SimpleCParser.BOOL, 0); }
		public BoolExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitBoolExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitBoolExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UintExprContext extends ExprContext {
		public TerminalNode UNSIGNED_INTEGER() { return getToken(SimpleCParser.UNSIGNED_INTEGER, 0); }
		public UintExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterUintExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitUintExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitUintExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdExprContext extends ExprContext {
		public Token name;
		public TerminalNode IDENTIFIER() { return getToken(SimpleCParser.IDENTIFIER, 0); }
		public IdExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitIdExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitIdExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SubExprContext extends ExprContext {
		public ExprContext lhs;
		public ExprContext rhs;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SubExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterSubExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitSubExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitSubExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegExprContext extends ExprContext {
		public ExprContext body;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterNegExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitNegExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitNegExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddExprContext extends ExprContext {
		public ExprContext lhs;
		public ExprContext rhs;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitAddExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarDefExprContext extends ExprContext {
		public Token name;
		public TypeContext t;
		public ExprContext body;
		public TerminalNode IDENTIFIER() { return getToken(SimpleCParser.IDENTIFIER, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarDefExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterVarDefExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitVarDefExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitVarDefExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivExprContext extends ExprContext {
		public ExprContext lhs;
		public ExprContext rhs;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public DivExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterDivExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitDivExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitDivExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LthExprContext extends ExprContext {
		public ExprContext lhs;
		public ExprContext rhs;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LthExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterLthExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitLthExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitLthExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GthExprContext extends ExprContext {
		public ExprContext lhs;
		public ExprContext rhs;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public GthExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterGthExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitGthExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitGthExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunCallExprContext extends ExprContext {
		public Token name;
		public ExprContext expr;
		public List<ExprContext> args = new ArrayList<ExprContext>();
		public TerminalNode IDENTIFIER() { return getToken(SimpleCParser.IDENTIFIER, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FunCallExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterFunCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitFunCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitFunCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnExprContext extends ExprContext {
		public ExprContext body;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterReturnExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitReturnExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitReturnExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForExprContext extends ExprContext {
		public Token name;
		public ExprContext begin;
		public ExprContext end;
		public BlockContext body;
		public TerminalNode IDENTIFIER() { return getToken(SimpleCParser.IDENTIFIER, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ForExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterForExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitForExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitForExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntExprContext extends ExprContext {
		public TerminalNode INTEGER() { return getToken(SimpleCParser.INTEGER, 0); }
		public IntExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterIntExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitIntExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitIntExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends ExprContext {
		public ExprContext body;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarAssignExprContext extends ExprContext {
		public Token name;
		public ExprContext body;
		public TerminalNode IDENTIFIER() { return getToken(SimpleCParser.IDENTIFIER, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarAssignExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterVarAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitVarAssignExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitVarAssignExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				_localctx = new ReturnExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(71);
				match(T__14);
				setState(72);
				((ReturnExprContext)_localctx).body = expr(19);
				}
				break;
			case 2:
				{
				_localctx = new FunCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(73);
				((FunCallExprContext)_localctx).name = match(IDENTIFIER);
				setState(74);
				match(T__1);
				setState(80);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(75);
						((FunCallExprContext)_localctx).expr = expr(0);
						((FunCallExprContext)_localctx).args.add(((FunCallExprContext)_localctx).expr);
						setState(76);
						match(T__2);
						}
						} 
					}
					setState(82);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 16380428292L) != 0) {
					{
					setState(83);
					((FunCallExprContext)_localctx).expr = expr(0);
					((FunCallExprContext)_localctx).args.add(((FunCallExprContext)_localctx).expr);
					}
				}

				setState(86);
				match(T__3);
				}
				break;
			case 3:
				{
				_localctx = new IfstatementExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(87);
				ifExpr();
				}
				break;
			case 4:
				{
				_localctx = new ForExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88);
				match(T__15);
				setState(89);
				((ForExprContext)_localctx).name = match(IDENTIFIER);
				setState(90);
				match(T__16);
				setState(91);
				((ForExprContext)_localctx).begin = expr(0);
				setState(92);
				match(T__17);
				setState(93);
				((ForExprContext)_localctx).end = expr(0);
				setState(94);
				((ForExprContext)_localctx).body = block();
				}
				break;
			case 5:
				{
				_localctx = new WhileExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96);
				match(T__18);
				setState(97);
				match(T__1);
				setState(98);
				((WhileExprContext)_localctx).condition = expr(0);
				setState(99);
				match(T__3);
				setState(100);
				((WhileExprContext)_localctx).body = block();
				}
				break;
			case 6:
				{
				_localctx = new VarDefExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(102);
				match(T__19);
				setState(103);
				((VarDefExprContext)_localctx).name = match(IDENTIFIER);
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(104);
					match(T__4);
					setState(105);
					((VarDefExprContext)_localctx).t = type();
					}
				}

				setState(108);
				match(T__20);
				setState(109);
				((VarDefExprContext)_localctx).body = expr(14);
				}
				break;
			case 7:
				{
				_localctx = new VarAssignExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(110);
				((VarAssignExprContext)_localctx).name = match(IDENTIFIER);
				setState(111);
				match(T__20);
				setState(112);
				((VarAssignExprContext)_localctx).body = expr(13);
				}
				break;
			case 8:
				{
				_localctx = new IntExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(113);
				match(INTEGER);
				}
				break;
			case 9:
				{
				_localctx = new UintExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(114);
				match(UNSIGNED_INTEGER);
				}
				break;
			case 10:
				{
				_localctx = new BoolExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(115);
				match(BOOL);
				}
				break;
			case 11:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116);
				((IdExprContext)_localctx).name = match(IDENTIFIER);
				}
				break;
			case 12:
				{
				_localctx = new NegExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117);
				match(T__21);
				setState(118);
				((NegExprContext)_localctx).body = expr(8);
				}
				break;
			case 13:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(119);
				match(T__1);
				setState(120);
				((ParenExprContext)_localctx).body = expr(0);
				setState(121);
				match(T__3);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(145);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(143);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new AddExprContext(new ExprContext(_parentctx, _parentState));
						((AddExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(125);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(126);
						match(T__22);
						setState(127);
						((AddExprContext)_localctx).rhs = expr(8);
						}
						break;
					case 2:
						{
						_localctx = new SubExprContext(new ExprContext(_parentctx, _parentState));
						((SubExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(128);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(129);
						match(T__21);
						setState(130);
						((SubExprContext)_localctx).rhs = expr(7);
						}
						break;
					case 3:
						{
						_localctx = new MulExprContext(new ExprContext(_parentctx, _parentState));
						((MulExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(131);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(132);
						match(T__23);
						setState(133);
						((MulExprContext)_localctx).rhs = expr(6);
						}
						break;
					case 4:
						{
						_localctx = new DivExprContext(new ExprContext(_parentctx, _parentState));
						((DivExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(134);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(135);
						match(T__24);
						setState(136);
						((DivExprContext)_localctx).rhs = expr(5);
						}
						break;
					case 5:
						{
						_localctx = new LthExprContext(new ExprContext(_parentctx, _parentState));
						((LthExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(137);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(138);
						match(T__25);
						setState(139);
						((LthExprContext)_localctx).rhs = expr(4);
						}
						break;
					case 6:
						{
						_localctx = new GthExprContext(new ExprContext(_parentctx, _parentState));
						((GthExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(140);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(141);
						match(T__26);
						setState(142);
						((GthExprContext)_localctx).rhs = expr(3);
						}
						break;
					}
					} 
				}
				setState(147);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfExprContext extends ParserRuleContext {
		public ExprContext cond;
		public BlockContext ifBody;
		public IfFollowUpContext elseBody;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfFollowUpContext ifFollowUp() {
			return getRuleContext(IfFollowUpContext.class,0);
		}
		public IfExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterIfExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitIfExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitIfExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfExprContext ifExpr() throws RecognitionException {
		IfExprContext _localctx = new IfExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ifExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(T__27);
			setState(149);
			match(T__1);
			setState(150);
			((IfExprContext)_localctx).cond = expr(0);
			setState(151);
			match(T__3);
			setState(152);
			((IfExprContext)_localctx).ifBody = block();
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(153);
				match(T__28);
				{
				setState(154);
				((IfExprContext)_localctx).elseBody = ifFollowUp();
				}
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfFollowUpContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfExprContext ifExpr() {
			return getRuleContext(IfExprContext.class,0);
		}
		public IfFollowUpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifFollowUp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterIfFollowUp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitIfFollowUp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleCVisitor ) return ((SimpleCVisitor<? extends T>)visitor).visitIfFollowUp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfFollowUpContext ifFollowUp() throws RecognitionException {
		IfFollowUpContext _localctx = new IfFollowUpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ifFollowUp);
		try {
			setState(159);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				block();
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				ifExpr();
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
		case 5:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\"\u00a2\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0004\u0000\u0012\b\u0000\u000b\u0000\f\u0000\u0013\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"\u001c\b\u0001\n\u0001\f\u0001\u001f\t\u0001\u0001\u0001\u0003\u0001\""+
		"\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u00037\b\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0005\u0004=\b\u0004\n\u0004\f\u0004@\t\u0004\u0001"+
		"\u0004\u0003\u0004C\b\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0005\u0005O\b\u0005\n\u0005\f\u0005R\t\u0005\u0001\u0005\u0003"+
		"\u0005U\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005k\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005|\b\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u0090"+
		"\b\u0005\n\u0005\f\u0005\u0093\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u009c\b\u0006"+
		"\u0001\u0007\u0001\u0007\u0003\u0007\u00a0\b\u0007\u0001\u0007\u0000\u0001"+
		"\n\b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0000\u0000\u00b9\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0002\u0015\u0001\u0000\u0000\u0000\u0004(\u0001"+
		"\u0000\u0000\u0000\u00066\u0001\u0000\u0000\u0000\b8\u0001\u0000\u0000"+
		"\u0000\n{\u0001\u0000\u0000\u0000\f\u0094\u0001\u0000\u0000\u0000\u000e"+
		"\u009f\u0001\u0000\u0000\u0000\u0010\u0012\u0003\u0002\u0001\u0000\u0011"+
		"\u0010\u0001\u0000\u0000\u0000\u0012\u0013\u0001\u0000\u0000\u0000\u0013"+
		"\u0011\u0001\u0000\u0000\u0000\u0013\u0014\u0001\u0000\u0000\u0000\u0014"+
		"\u0001\u0001\u0000\u0000\u0000\u0015\u0016\u0005\u0001\u0000\u0000\u0016"+
		"\u0017\u0005\u001e\u0000\u0000\u0017\u001d\u0005\u0002\u0000\u0000\u0018"+
		"\u0019\u0003\u0004\u0002\u0000\u0019\u001a\u0005\u0003\u0000\u0000\u001a"+
		"\u001c\u0001\u0000\u0000\u0000\u001b\u0018\u0001\u0000\u0000\u0000\u001c"+
		"\u001f\u0001\u0000\u0000\u0000\u001d\u001b\u0001\u0000\u0000\u0000\u001d"+
		"\u001e\u0001\u0000\u0000\u0000\u001e!\u0001\u0000\u0000\u0000\u001f\u001d"+
		"\u0001\u0000\u0000\u0000 \"\u0003\u0004\u0002\u0000! \u0001\u0000\u0000"+
		"\u0000!\"\u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000#$\u0005\u0004"+
		"\u0000\u0000$%\u0005\u0005\u0000\u0000%&\u0003\u0006\u0003\u0000&\'\u0003"+
		"\b\u0004\u0000\'\u0003\u0001\u0000\u0000\u0000()\u0005\u001e\u0000\u0000"+
		")*\u0005\u0005\u0000\u0000*+\u0003\u0006\u0003\u0000+\u0005\u0001\u0000"+
		"\u0000\u0000,7\u0005\u0006\u0000\u0000-7\u0005\u0007\u0000\u0000.7\u0005"+
		"\b\u0000\u0000/7\u0005\t\u0000\u000001\u0005\n\u0000\u000012\u0003\u0006"+
		"\u0003\u000023\u0005\u000b\u0000\u000034\u0005\u001f\u0000\u000045\u0005"+
		"\f\u0000\u000057\u0001\u0000\u0000\u00006,\u0001\u0000\u0000\u00006-\u0001"+
		"\u0000\u0000\u00006.\u0001\u0000\u0000\u00006/\u0001\u0000\u0000\u0000"+
		"60\u0001\u0000\u0000\u00007\u0007\u0001\u0000\u0000\u00008>\u0005\r\u0000"+
		"\u00009:\u0003\n\u0005\u0000:;\u0005\u000b\u0000\u0000;=\u0001\u0000\u0000"+
		"\u0000<9\u0001\u0000\u0000\u0000=@\u0001\u0000\u0000\u0000><\u0001\u0000"+
		"\u0000\u0000>?\u0001\u0000\u0000\u0000?B\u0001\u0000\u0000\u0000@>\u0001"+
		"\u0000\u0000\u0000AC\u0003\n\u0005\u0000BA\u0001\u0000\u0000\u0000BC\u0001"+
		"\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DE\u0005\u000e\u0000\u0000"+
		"E\t\u0001\u0000\u0000\u0000FG\u0006\u0005\uffff\uffff\u0000GH\u0005\u000f"+
		"\u0000\u0000H|\u0003\n\u0005\u0013IJ\u0005\u001e\u0000\u0000JP\u0005\u0002"+
		"\u0000\u0000KL\u0003\n\u0005\u0000LM\u0005\u0003\u0000\u0000MO\u0001\u0000"+
		"\u0000\u0000NK\u0001\u0000\u0000\u0000OR\u0001\u0000\u0000\u0000PN\u0001"+
		"\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QT\u0001\u0000\u0000\u0000"+
		"RP\u0001\u0000\u0000\u0000SU\u0003\n\u0005\u0000TS\u0001\u0000\u0000\u0000"+
		"TU\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000V|\u0005\u0004\u0000"+
		"\u0000W|\u0003\f\u0006\u0000XY\u0005\u0010\u0000\u0000YZ\u0005\u001e\u0000"+
		"\u0000Z[\u0005\u0011\u0000\u0000[\\\u0003\n\u0005\u0000\\]\u0005\u0012"+
		"\u0000\u0000]^\u0003\n\u0005\u0000^_\u0003\b\u0004\u0000_|\u0001\u0000"+
		"\u0000\u0000`a\u0005\u0013\u0000\u0000ab\u0005\u0002\u0000\u0000bc\u0003"+
		"\n\u0005\u0000cd\u0005\u0004\u0000\u0000de\u0003\b\u0004\u0000e|\u0001"+
		"\u0000\u0000\u0000fg\u0005\u0014\u0000\u0000gj\u0005\u001e\u0000\u0000"+
		"hi\u0005\u0005\u0000\u0000ik\u0003\u0006\u0003\u0000jh\u0001\u0000\u0000"+
		"\u0000jk\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lm\u0005\u0015"+
		"\u0000\u0000m|\u0003\n\u0005\u000eno\u0005\u001e\u0000\u0000op\u0005\u0015"+
		"\u0000\u0000p|\u0003\n\u0005\rq|\u0005 \u0000\u0000r|\u0005\u001f\u0000"+
		"\u0000s|\u0005!\u0000\u0000t|\u0005\u001e\u0000\u0000uv\u0005\u0016\u0000"+
		"\u0000v|\u0003\n\u0005\bwx\u0005\u0002\u0000\u0000xy\u0003\n\u0005\u0000"+
		"yz\u0005\u0004\u0000\u0000z|\u0001\u0000\u0000\u0000{F\u0001\u0000\u0000"+
		"\u0000{I\u0001\u0000\u0000\u0000{W\u0001\u0000\u0000\u0000{X\u0001\u0000"+
		"\u0000\u0000{`\u0001\u0000\u0000\u0000{f\u0001\u0000\u0000\u0000{n\u0001"+
		"\u0000\u0000\u0000{q\u0001\u0000\u0000\u0000{r\u0001\u0000\u0000\u0000"+
		"{s\u0001\u0000\u0000\u0000{t\u0001\u0000\u0000\u0000{u\u0001\u0000\u0000"+
		"\u0000{w\u0001\u0000\u0000\u0000|\u0091\u0001\u0000\u0000\u0000}~\n\u0007"+
		"\u0000\u0000~\u007f\u0005\u0017\u0000\u0000\u007f\u0090\u0003\n\u0005"+
		"\b\u0080\u0081\n\u0006\u0000\u0000\u0081\u0082\u0005\u0016\u0000\u0000"+
		"\u0082\u0090\u0003\n\u0005\u0007\u0083\u0084\n\u0005\u0000\u0000\u0084"+
		"\u0085\u0005\u0018\u0000\u0000\u0085\u0090\u0003\n\u0005\u0006\u0086\u0087"+
		"\n\u0004\u0000\u0000\u0087\u0088\u0005\u0019\u0000\u0000\u0088\u0090\u0003"+
		"\n\u0005\u0005\u0089\u008a\n\u0003\u0000\u0000\u008a\u008b\u0005\u001a"+
		"\u0000\u0000\u008b\u0090\u0003\n\u0005\u0004\u008c\u008d\n\u0002\u0000"+
		"\u0000\u008d\u008e\u0005\u001b\u0000\u0000\u008e\u0090\u0003\n\u0005\u0003"+
		"\u008f}\u0001\u0000\u0000\u0000\u008f\u0080\u0001\u0000\u0000\u0000\u008f"+
		"\u0083\u0001\u0000\u0000\u0000\u008f\u0086\u0001\u0000\u0000\u0000\u008f"+
		"\u0089\u0001\u0000\u0000\u0000\u008f\u008c\u0001\u0000\u0000\u0000\u0090"+
		"\u0093\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091"+
		"\u0092\u0001\u0000\u0000\u0000\u0092\u000b\u0001\u0000\u0000\u0000\u0093"+
		"\u0091\u0001\u0000\u0000\u0000\u0094\u0095\u0005\u001c\u0000\u0000\u0095"+
		"\u0096\u0005\u0002\u0000\u0000\u0096\u0097\u0003\n\u0005\u0000\u0097\u0098"+
		"\u0005\u0004\u0000\u0000\u0098\u009b\u0003\b\u0004\u0000\u0099\u009a\u0005"+
		"\u001d\u0000\u0000\u009a\u009c\u0003\u000e\u0007\u0000\u009b\u0099\u0001"+
		"\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c\r\u0001\u0000"+
		"\u0000\u0000\u009d\u00a0\u0003\b\u0004\u0000\u009e\u00a0\u0003\f\u0006"+
		"\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u009f\u009e\u0001\u0000\u0000"+
		"\u0000\u00a0\u000f\u0001\u0000\u0000\u0000\u000e\u0013\u001d!6>BPTj{\u008f"+
		"\u0091\u009b\u009f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}