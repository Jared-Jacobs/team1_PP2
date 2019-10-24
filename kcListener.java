// Generated from knightCode.g4 by ANTLR 4.7.2

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * This class provides an empty implementation of {@link knightCodeListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class kcListener extends knightCodeBaseListener {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFile(knightCodeParser.FileContext ctx) {
		String ctxText = ctx.getText();
		System.out.println("public class " + ctxText.substring(7, ctxText.indexOf("DECLARE")) + "{");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFile(knightCodeParser.FileContext ctx) { 
		System.out.println("}");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDeclare(knightCodeParser.DeclareContext ctx) {
		//System.out.println(ctx.getText());
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDeclare(knightCodeParser.DeclareContext ctx) { 
		//System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterVariable(knightCodeParser.VariableContext ctx) { 
		//System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitVariable(knightCodeParser.VariableContext ctx) { 
		String id = ctx.getText();
		if (id.contains("INTEGER")) {
			id = id.replaceAll("INTEGER", " ");
		} else if (id.contains("STRING")) {
			id = id.replaceAll("STRING", " ");
		}
		id += ";";
		System.out.println(id);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterType(knightCodeParser.TypeContext ctx) { 
		String type = ctx.getText();
		if (type.equals("INTEGER")) {
			System.out.print("\tint");
		} else if (type.equals("STRING")) {
			System.out.print("\tString");
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitType(knightCodeParser.TypeContext ctx) { 
		//System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBody(knightCodeParser.BodyContext ctx) { 
		System.out.println("\tpublic static void main(String[] args) {");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBody(knightCodeParser.BodyContext ctx) { 
		System.out.println("\t}");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStat(knightCodeParser.StatContext ctx) { 
		text = ctx.getText();
		if (text.contains("IF")) {
			System.out.print("if(");
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStat(knightCodeParser.StatContext ctx) { 
		System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSetvar(knightCodeParser.SetvarContext ctx) { 
		//System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitSetvar(knightCodeParser.SetvarContext ctx) { 
		//System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExpr(knightCodeParser.ExprContext ctx) {
		//System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExpr(knightCodeParser.ExprContext ctx) { 
		//System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterComp(knightCodeParser.CompContext ctx) { 
		//System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitComp(knightCodeParser.CompContext ctx) { 
		//System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterPrint(knightCodeParser.PrintContext ctx) { 
		//System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPrint(knightCodeParser.PrintContext ctx) { 
		//System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterRead(knightCodeParser.ReadContext ctx) { 
		//System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitRead(knightCodeParser.ReadContext ctx) { 
		//System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDecision(knightCodeParser.DecisionContext ctx) { 
		//System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDecision(knightCodeParser.DecisionContext ctx) { 
		//System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLoop(knightCodeParser.LoopContext ctx) { 
		//System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLoop(knightCodeParser.LoopContext ctx) { 
		//System.out.println(ctx.getText());
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(ParserRuleContext ctx) { 
		//System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEveryRule(ParserRuleContext ctx) { 
		//System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitTerminal(TerminalNode node) {

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitErrorNode(ErrorNode node) { 

	}
}
