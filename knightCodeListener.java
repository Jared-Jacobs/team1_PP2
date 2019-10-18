// Generated from knightCode.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link knightCodeParser}.
 */
public interface knightCodeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link knightCodeParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(knightCodeParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link knightCodeParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(knightCodeParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link knightCodeParser#declare}.
	 * @param ctx the parse tree
	 */
	void enterDeclare(knightCodeParser.DeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link knightCodeParser#declare}.
	 * @param ctx the parse tree
	 */
	void exitDeclare(knightCodeParser.DeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link knightCodeParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(knightCodeParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link knightCodeParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(knightCodeParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link knightCodeParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(knightCodeParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link knightCodeParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(knightCodeParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link knightCodeParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(knightCodeParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link knightCodeParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(knightCodeParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link knightCodeParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(knightCodeParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link knightCodeParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(knightCodeParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link knightCodeParser#setvar}.
	 * @param ctx the parse tree
	 */
	void enterSetvar(knightCodeParser.SetvarContext ctx);
	/**
	 * Exit a parse tree produced by {@link knightCodeParser#setvar}.
	 * @param ctx the parse tree
	 */
	void exitSetvar(knightCodeParser.SetvarContext ctx);
	/**
	 * Enter a parse tree produced by {@link knightCodeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(knightCodeParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link knightCodeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(knightCodeParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link knightCodeParser#comp}.
	 * @param ctx the parse tree
	 */
	void enterComp(knightCodeParser.CompContext ctx);
	/**
	 * Exit a parse tree produced by {@link knightCodeParser#comp}.
	 * @param ctx the parse tree
	 */
	void exitComp(knightCodeParser.CompContext ctx);
	/**
	 * Enter a parse tree produced by {@link knightCodeParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(knightCodeParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link knightCodeParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(knightCodeParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link knightCodeParser#read}.
	 * @param ctx the parse tree
	 */
	void enterRead(knightCodeParser.ReadContext ctx);
	/**
	 * Exit a parse tree produced by {@link knightCodeParser#read}.
	 * @param ctx the parse tree
	 */
	void exitRead(knightCodeParser.ReadContext ctx);
	/**
	 * Enter a parse tree produced by {@link knightCodeParser#decision}.
	 * @param ctx the parse tree
	 */
	void enterDecision(knightCodeParser.DecisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link knightCodeParser#decision}.
	 * @param ctx the parse tree
	 */
	void exitDecision(knightCodeParser.DecisionContext ctx);
	/**
	 * Enter a parse tree produced by {@link knightCodeParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(knightCodeParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link knightCodeParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(knightCodeParser.LoopContext ctx);
}