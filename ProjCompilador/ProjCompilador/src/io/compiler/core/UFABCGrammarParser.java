// Generated from UFABCGrammar.g4 by ANTLR 4.13.2
package io.compiler.core;

	import java.util.ArrayList;
	import java.util.Stack;
	import java.util.HashMap;
	import io.compiler.types.*;
	import io.compiler.core.exception.*;
	import io.compiler.core.ast.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class UFABCGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, OP=17, 
		OP_AT=18, OPREL=19, ID=20, NUM=21, VIRG=22, PV=23, AP=24, FP=25, DP=26, 
		TEXTO=27, WS=28;
	public static final int
		RULE_programa = 0, RULE_declaravar = 1, RULE_comando = 2, RULE_cmdWhile = 3, 
		RULE_cmdIF = 4, RULE_cmdAttrib = 5, RULE_cmdLeitura = 6, RULE_cmdEscrita = 7, 
		RULE_expr = 8, RULE_termo = 9, RULE_exprl = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declaravar", "comando", "cmdWhile", "cmdIF", "cmdAttrib", 
			"cmdLeitura", "cmdEscrita", "expr", "termo", "exprl"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'inicio'", "'fim'", "'fimprog'", "'declare'", "'number'", 
			"'text'", "'enquanto'", "'inicioEnquanto'", "'fimEnquanto'", "'se'", 
			"'entao'", "'senao'", "'fimse'", "'leia'", "'escreva'", null, "':='", 
			null, null, null, "','", "';'", "'('", "')'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "OP", "OP_AT", "OPREL", "ID", "NUM", "VIRG", 
			"PV", "AP", "FP", "DP", "TEXTO", "WS"
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
	public String getGrammarFileName() { return "UFABCGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private HashMap<String,Var> symbolTable = new HashMap<String, Var>();
	    private ArrayList<Var> currentDecl = new ArrayList<Var>();
	    private Types currentType;
	    private Types leftType=null, rightType=null;
	    private Program program = new Program();
	    private String strExpr = "";
	    private IfCommand currentIfCommand;
	    private WhileCommand currentWhileCommand;
	    private AttribCommand currentAttribCommand;
	    
	    private Stack<ArrayList<Command>> stack = new Stack<ArrayList<Command>>();
	    private Stack<WhileCommand> whileStack = new Stack<WhileCommand>();
	    private Stack<IfCommand> ifStack = new Stack<IfCommand>();
	    
	    
	    public void updateType(){
	    	for(Var v: currentDecl){
	    	   v.setType(currentType);
	    	   symbolTable.put(v.getId(), v);
	    	}
	    }
	    public void exibirVar(){
	        for (String id: symbolTable.keySet()){
	        	System.out.println(symbolTable.get(id));
	        }
	    }
	    
	    public Program getProgram(){
	    	return this.program;
	    	}
	    
	    public boolean isDeclared(String id){
	    	return symbolTable.get(id) != null;
	    }

	public UFABCGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(UFABCGrammarParser.ID, 0); }
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			match(T__0);
			setState(23);
			match(ID);
			 program.setName(_input.LT(-1).getText());
			                               stack.push(new ArrayList<Command>()); 
			                             
			setState(26); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(25);
				declaravar();
				}
				}
				setState(28); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(30);
			match(T__1);
			setState(32); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(31);
				comando();
				}
				}
				setState(34); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1149184L) != 0) );
			setState(36);
			match(T__2);
			setState(37);
			match(T__3);

			                  program.setSymbolTable(symbolTable);
			                  program.setCommandList(stack.pop());
			               
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
	public static class DeclaravarContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(UFABCGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(UFABCGrammarParser.ID, i);
		}
		public TerminalNode DP() { return getToken(UFABCGrammarParser.DP, 0); }
		public TerminalNode PV() { return getToken(UFABCGrammarParser.PV, 0); }
		public List<TerminalNode> VIRG() { return getTokens(UFABCGrammarParser.VIRG); }
		public TerminalNode VIRG(int i) {
			return getToken(UFABCGrammarParser.VIRG, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(T__4);
			 currentDecl.clear(); 
			setState(42);
			match(ID);
			 currentDecl.add(new Var(_input.LT(-1).getText()));
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRG) {
				{
				{
				setState(44);
				match(VIRG);
				setState(45);
				match(ID);
				 currentDecl.add(new Var(_input.LT(-1).getText()));
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
			match(DP);
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				setState(53);
				match(T__5);
				currentType = Types.NUMBER;
				}
				break;
			case T__6:
				{
				setState(55);
				match(T__6);
				currentType = Types.TEXT;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 updateType(); 
			setState(60);
			match(PV);
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
	public static class ComandoContext extends ParserRuleContext {
		public CmdAttribContext cmdAttrib() {
			return getRuleContext(CmdAttribContext.class,0);
		}
		public CmdLeituraContext cmdLeitura() {
			return getRuleContext(CmdLeituraContext.class,0);
		}
		public CmdEscritaContext cmdEscrita() {
			return getRuleContext(CmdEscritaContext.class,0);
		}
		public CmdIFContext cmdIF() {
			return getRuleContext(CmdIFContext.class,0);
		}
		public CmdWhileContext cmdWhile() {
			return getRuleContext(CmdWhileContext.class,0);
		}
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterComando(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitComando(this);
		}
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_comando);
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				cmdAttrib();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				cmdLeitura();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				cmdEscrita();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 4);
				{
				setState(65);
				cmdIF();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 5);
				{
				setState(66);
				cmdWhile();
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
	public static class CmdWhileContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(UFABCGrammarParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(UFABCGrammarParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(UFABCGrammarParser.FP, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public CmdWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterCmdWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitCmdWhile(this);
		}
	}

	public final CmdWhileContext cmdWhile() throws RecognitionException {
		CmdWhileContext _localctx = new CmdWhileContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cmdWhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(T__7);
			 stack.push(new ArrayList<Command>());
			                           whileStack.push(new WhileCommand());
			                           strExpr = "";
			                           currentWhileCommand = new WhileCommand();
			                          
			setState(71);
			match(AP);
			setState(72);
			expr();
			setState(73);
			match(OPREL);
			 strExpr += _input.LT(-1).getText(); 
			setState(75);
			expr();
			setState(76);
			match(FP);
			 whileStack.peek().setCriterioParada(strExpr);
			setState(78);
			match(T__8);
			setState(80); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(79);
				comando();
				}
				}
				setState(82); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1149184L) != 0) );
			 whileStack.peek().setCycle(stack.pop());
			setState(85);
			match(T__9);
			 stack.peek().add(whileStack.pop()); 
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
	public static class CmdIFContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(UFABCGrammarParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(UFABCGrammarParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(UFABCGrammarParser.FP, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public CmdIFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdIF; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterCmdIF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitCmdIF(this);
		}
	}

	public final CmdIFContext cmdIF() throws RecognitionException {
		CmdIFContext _localctx = new CmdIFContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cmdIF);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T__10);
			 stack.push(new ArrayList<Command>());
			                      strExpr = "";
			                      ifStack.push(new IfCommand());
			                      currentIfCommand = new IfCommand();
			                    
			setState(90);
			match(AP);
			setState(91);
			expr();
			setState(92);
			match(OPREL);
			 strExpr += _input.LT(-1).getText(); 
			setState(94);
			expr();
			setState(95);
			match(FP);
			 ifStack.peek().setExpression(strExpr); 
			setState(97);
			match(T__11);
			setState(99); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(98);
				comando();
				}
				}
				setState(101); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1149184L) != 0) );
			 
			                  ifStack.peek().setTrueList(stack.pop());                            
			               
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(104);
				match(T__12);
				 stack.push(new ArrayList<Command>()); 
				setState(107); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(106);
					comando();
					}
					}
					setState(109); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1149184L) != 0) );

				                   ifStack.peek().setFalseList(stack.pop());
				                 
				}
			}

			setState(115);
			match(T__13);

			               	   stack.peek().add(ifStack.pop());
			               
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
	public static class CmdAttribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(UFABCGrammarParser.ID, 0); }
		public TerminalNode OP_AT() { return getToken(UFABCGrammarParser.OP_AT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PV() { return getToken(UFABCGrammarParser.PV, 0); }
		public CmdAttribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAttrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterCmdAttrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitCmdAttrib(this);
		}
	}

	public final CmdAttribContext cmdAttrib() throws RecognitionException {
		CmdAttribContext _localctx = new CmdAttribContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdAttrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                       throw new UFABCSemanticException("Undeclared Variable: "+_input.LT(-1).getText());
			                   }
			                   symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                   leftType = symbolTable.get(_input.LT(-1).getText()).getType();
			                   strExpr = "";
			                   currentAttribCommand = new AttribCommand();
			                   strExpr += _input.LT(-1).getText();
			                   currentAttribCommand.setAtribuido(strExpr);
			                   strExpr = "";
			                 
			setState(120);
			match(OP_AT);
			 strExpr += _input.LT(-1).getText();
			setState(122);
			expr();
			setState(123);
			match(PV);
			 currentAttribCommand.setExpression(strExpr); 
			                     stack.peek().add(currentAttribCommand);

			                 System.out.println("Left  Side Expression Type = "+leftType);
			                 System.out.println("Right Side Expression Type = "+rightType);
			                 if (leftType.getValue() < rightType.getValue()){
			                    throw new UFABCSemanticException("Type Mismatchig on Assignment");
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
	public static class CmdLeituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(UFABCGrammarParser.AP, 0); }
		public TerminalNode ID() { return getToken(UFABCGrammarParser.ID, 0); }
		public TerminalNode FP() { return getToken(UFABCGrammarParser.FP, 0); }
		public TerminalNode PV() { return getToken(UFABCGrammarParser.PV, 0); }
		public CmdLeituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdLeitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterCmdLeitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitCmdLeitura(this);
		}
	}

	public final CmdLeituraContext cmdLeitura() throws RecognitionException {
		CmdLeituraContext _localctx = new CmdLeituraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(T__14);
			setState(128);
			match(AP);
			setState(129);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                       throw new UFABCSemanticException("Undeclared Variable: "+_input.LT(-1).getText());
			                    }
			                    symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                    Command cmdRead = new ReadCommand(symbolTable.get(_input.LT(-1).getText()));
			                    stack.peek().add(cmdRead);
			                  
			setState(131);
			match(FP);
			setState(132);
			match(PV);
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
	public static class CmdEscritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(UFABCGrammarParser.AP, 0); }
		public TerminalNode FP() { return getToken(UFABCGrammarParser.FP, 0); }
		public TerminalNode PV() { return getToken(UFABCGrammarParser.PV, 0); }
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public CmdEscritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEscrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterCmdEscrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitCmdEscrita(this);
		}
	}

	public final CmdEscritaContext cmdEscrita() throws RecognitionException {
		CmdEscritaContext _localctx = new CmdEscritaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdEscrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(T__15);
			setState(135);
			match(AP);
			{
			setState(136);
			termo();
			 Command cmdWrite = new WriteCommand(_input.LT(-1).getText());
			                         stack.peek().add(cmdWrite);
			                       
			}
			setState(139);
			match(FP);
			setState(140);
			match(PV);
			 rightType = null;
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
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public ExprlContext exprl() {
			return getRuleContext(ExprlContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			termo();
			 strExpr += _input.LT(-1).getText(); 
			setState(145);
			exprl();
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
	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(UFABCGrammarParser.ID, 0); }
		public TerminalNode NUM() { return getToken(UFABCGrammarParser.NUM, 0); }
		public TerminalNode TEXTO() { return getToken(UFABCGrammarParser.TEXTO, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_termo);
		try {
			setState(153);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				match(ID);
				 if (!isDeclared(_input.LT(-1).getText())) {
				                       throw new UFABCSemanticException("Undeclared Variable: "+_input.LT(-1).getText());
				                    }
				                    if (!symbolTable.get(_input.LT(-1).getText()).isInitialized()){
				                       throw new UFABCSemanticException("Variable "+_input.LT(-1).getText()+" has no value assigned");
				                    }
				                    if (rightType == null){
				                       rightType = symbolTable.get(_input.LT(-1).getText()).getType();
				                       //System.out.println("Encontrei pela 1a vez uma variavel = "+rightType);
				                    }   
				                    else{
				                       if (symbolTable.get(_input.LT(-1).getText()).getType().getValue() > rightType.getValue()){
				                          rightType = symbolTable.get(_input.LT(-1).getText()).getType();
				                          //System.out.println("Ja havia tipo declarado e mudou para = "+rightType);
				                          
				                       }
				                    }
				                  
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				match(NUM);
				  if (rightType == null) {
							 				rightType = Types.NUMBER;
							 				//System.out.println("Encontrei um numero pela 1a vez "+rightType);
							            }
							            else{
							                if (rightType.getValue() < Types.NUMBER.getValue()){			                    			                   
							                	rightType = Types.NUMBER;
							                	//System.out.println("Mudei o tipo para Number = "+rightType);
							                }
							            }
							         
				}
				break;
			case TEXTO:
				enterOuterAlt(_localctx, 3);
				{
				setState(151);
				match(TEXTO);
				  if (rightType == null) {
							 				rightType = Types.TEXT;
							 				//System.out.println("Encontrei pela 1a vez um texto ="+ rightType);
							            }
							            else{
							                if (rightType.getValue() < Types.TEXT.getValue()){			                    
							                	rightType = Types.TEXT;
							                	//System.out.println("Mudei o tipo para TEXT = "+rightType);
							                	
							                }
							            }
							         
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
	public static class ExprlContext extends ParserRuleContext {
		public List<TerminalNode> OP() { return getTokens(UFABCGrammarParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(UFABCGrammarParser.OP, i);
		}
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public ExprlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterExprl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitExprl(this);
		}
	}

	public final ExprlContext exprl() throws RecognitionException {
		ExprlContext _localctx = new ExprlContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_exprl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(155);
				match(OP);
				 strExpr += _input.LT(-1).getText(); 
				setState(157);
				termo();
				 strExpr += _input.LT(-1).getText(); 
				}
				}
				setState(164);
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

	public static final String _serializedATN =
		"\u0004\u0001\u001c\u00a6\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0004\u0000\u001b\b\u0000\u000b\u0000\f\u0000"+
		"\u001c\u0001\u0000\u0001\u0000\u0004\u0000!\b\u0000\u000b\u0000\f\u0000"+
		"\"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"0\b\u0001\n\u0001\f\u00013\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001:\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002D\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0004\u0003Q\b\u0003\u000b\u0003\f\u0003R\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0004\u0004d\b\u0004\u000b\u0004\f\u0004e\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004l\b\u0004\u000b\u0004"+
		"\f\u0004m\u0001\u0004\u0001\u0004\u0003\u0004r\b\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u009a\b\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0005\n\u00a1\b\n\n\n\f\n\u00a4\t\n\u0001\n"+
		"\u0000\u0000\u000b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0000\u0000\u00a9\u0000\u0016\u0001\u0000\u0000\u0000\u0002(\u0001\u0000"+
		"\u0000\u0000\u0004C\u0001\u0000\u0000\u0000\u0006E\u0001\u0000\u0000\u0000"+
		"\bX\u0001\u0000\u0000\u0000\nv\u0001\u0000\u0000\u0000\f\u007f\u0001\u0000"+
		"\u0000\u0000\u000e\u0086\u0001\u0000\u0000\u0000\u0010\u008f\u0001\u0000"+
		"\u0000\u0000\u0012\u0099\u0001\u0000\u0000\u0000\u0014\u00a2\u0001\u0000"+
		"\u0000\u0000\u0016\u0017\u0005\u0001\u0000\u0000\u0017\u0018\u0005\u0014"+
		"\u0000\u0000\u0018\u001a\u0006\u0000\uffff\uffff\u0000\u0019\u001b\u0003"+
		"\u0002\u0001\u0000\u001a\u0019\u0001\u0000\u0000\u0000\u001b\u001c\u0001"+
		"\u0000\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001c\u001d\u0001"+
		"\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e \u0005\u0002"+
		"\u0000\u0000\u001f!\u0003\u0004\u0002\u0000 \u001f\u0001\u0000\u0000\u0000"+
		"!\"\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000\"#\u0001\u0000"+
		"\u0000\u0000#$\u0001\u0000\u0000\u0000$%\u0005\u0003\u0000\u0000%&\u0005"+
		"\u0004\u0000\u0000&\'\u0006\u0000\uffff\uffff\u0000\'\u0001\u0001\u0000"+
		"\u0000\u0000()\u0005\u0005\u0000\u0000)*\u0006\u0001\uffff\uffff\u0000"+
		"*+\u0005\u0014\u0000\u0000+1\u0006\u0001\uffff\uffff\u0000,-\u0005\u0016"+
		"\u0000\u0000-.\u0005\u0014\u0000\u0000.0\u0006\u0001\uffff\uffff\u0000"+
		"/,\u0001\u0000\u0000\u000003\u0001\u0000\u0000\u00001/\u0001\u0000\u0000"+
		"\u000012\u0001\u0000\u0000\u000024\u0001\u0000\u0000\u000031\u0001\u0000"+
		"\u0000\u000049\u0005\u001a\u0000\u000056\u0005\u0006\u0000\u00006:\u0006"+
		"\u0001\uffff\uffff\u000078\u0005\u0007\u0000\u00008:\u0006\u0001\uffff"+
		"\uffff\u000095\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u0000:;\u0001"+
		"\u0000\u0000\u0000;<\u0006\u0001\uffff\uffff\u0000<=\u0005\u0017\u0000"+
		"\u0000=\u0003\u0001\u0000\u0000\u0000>D\u0003\n\u0005\u0000?D\u0003\f"+
		"\u0006\u0000@D\u0003\u000e\u0007\u0000AD\u0003\b\u0004\u0000BD\u0003\u0006"+
		"\u0003\u0000C>\u0001\u0000\u0000\u0000C?\u0001\u0000\u0000\u0000C@\u0001"+
		"\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000CB\u0001\u0000\u0000\u0000"+
		"D\u0005\u0001\u0000\u0000\u0000EF\u0005\b\u0000\u0000FG\u0006\u0003\uffff"+
		"\uffff\u0000GH\u0005\u0018\u0000\u0000HI\u0003\u0010\b\u0000IJ\u0005\u0013"+
		"\u0000\u0000JK\u0006\u0003\uffff\uffff\u0000KL\u0003\u0010\b\u0000LM\u0005"+
		"\u0019\u0000\u0000MN\u0006\u0003\uffff\uffff\u0000NP\u0005\t\u0000\u0000"+
		"OQ\u0003\u0004\u0002\u0000PO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000"+
		"\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000ST\u0001\u0000"+
		"\u0000\u0000TU\u0006\u0003\uffff\uffff\u0000UV\u0005\n\u0000\u0000VW\u0006"+
		"\u0003\uffff\uffff\u0000W\u0007\u0001\u0000\u0000\u0000XY\u0005\u000b"+
		"\u0000\u0000YZ\u0006\u0004\uffff\uffff\u0000Z[\u0005\u0018\u0000\u0000"+
		"[\\\u0003\u0010\b\u0000\\]\u0005\u0013\u0000\u0000]^\u0006\u0004\uffff"+
		"\uffff\u0000^_\u0003\u0010\b\u0000_`\u0005\u0019\u0000\u0000`a\u0006\u0004"+
		"\uffff\uffff\u0000ac\u0005\f\u0000\u0000bd\u0003\u0004\u0002\u0000cb\u0001"+
		"\u0000\u0000\u0000de\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000"+
		"ef\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gq\u0006\u0004\uffff"+
		"\uffff\u0000hi\u0005\r\u0000\u0000ik\u0006\u0004\uffff\uffff\u0000jl\u0003"+
		"\u0004\u0002\u0000kj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000"+
		"mk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000no\u0001\u0000\u0000"+
		"\u0000op\u0006\u0004\uffff\uffff\u0000pr\u0001\u0000\u0000\u0000qh\u0001"+
		"\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000"+
		"st\u0005\u000e\u0000\u0000tu\u0006\u0004\uffff\uffff\u0000u\t\u0001\u0000"+
		"\u0000\u0000vw\u0005\u0014\u0000\u0000wx\u0006\u0005\uffff\uffff\u0000"+
		"xy\u0005\u0012\u0000\u0000yz\u0006\u0005\uffff\uffff\u0000z{\u0003\u0010"+
		"\b\u0000{|\u0005\u0017\u0000\u0000|}\u0006\u0005\uffff\uffff\u0000}~\u0006"+
		"\u0005\uffff\uffff\u0000~\u000b\u0001\u0000\u0000\u0000\u007f\u0080\u0005"+
		"\u000f\u0000\u0000\u0080\u0081\u0005\u0018\u0000\u0000\u0081\u0082\u0005"+
		"\u0014\u0000\u0000\u0082\u0083\u0006\u0006\uffff\uffff\u0000\u0083\u0084"+
		"\u0005\u0019\u0000\u0000\u0084\u0085\u0005\u0017\u0000\u0000\u0085\r\u0001"+
		"\u0000\u0000\u0000\u0086\u0087\u0005\u0010\u0000\u0000\u0087\u0088\u0005"+
		"\u0018\u0000\u0000\u0088\u0089\u0003\u0012\t\u0000\u0089\u008a\u0006\u0007"+
		"\uffff\uffff\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008c\u0005"+
		"\u0019\u0000\u0000\u008c\u008d\u0005\u0017\u0000\u0000\u008d\u008e\u0006"+
		"\u0007\uffff\uffff\u0000\u008e\u000f\u0001\u0000\u0000\u0000\u008f\u0090"+
		"\u0003\u0012\t\u0000\u0090\u0091\u0006\b\uffff\uffff\u0000\u0091\u0092"+
		"\u0003\u0014\n\u0000\u0092\u0011\u0001\u0000\u0000\u0000\u0093\u0094\u0005"+
		"\u0014\u0000\u0000\u0094\u009a\u0006\t\uffff\uffff\u0000\u0095\u0096\u0005"+
		"\u0015\u0000\u0000\u0096\u009a\u0006\t\uffff\uffff\u0000\u0097\u0098\u0005"+
		"\u001b\u0000\u0000\u0098\u009a\u0006\t\uffff\uffff\u0000\u0099\u0093\u0001"+
		"\u0000\u0000\u0000\u0099\u0095\u0001\u0000\u0000\u0000\u0099\u0097\u0001"+
		"\u0000\u0000\u0000\u009a\u0013\u0001\u0000\u0000\u0000\u009b\u009c\u0005"+
		"\u0011\u0000\u0000\u009c\u009d\u0006\n\uffff\uffff\u0000\u009d\u009e\u0003"+
		"\u0012\t\u0000\u009e\u009f\u0006\n\uffff\uffff\u0000\u009f\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a0\u009b\u0001\u0000\u0000\u0000\u00a1\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a3\u0015\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001"+
		"\u0000\u0000\u0000\u000b\u001c\"19CRemq\u0099\u00a2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}