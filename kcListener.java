// Generated from knightCode.g4 by ANTLR 4.7.2

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.ArrayList;

/**
 * This class provides an empty implementation of {@link knightCodeListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class kcListener extends knightCodeBaseListener {

	
	private String fileName;
	private String nodeText;
	private ArrayList<String> processedCode;
	
	
	/**
	 * Default constructor, throws exception
	 */
	public kcListener() throws IllegalArgumentException{
		throw new IllegalArgumentException("You must specify an output file");
	}

	/**
	 * Constructor, allows for passing of filename
	 *
	 */
	public kcListener(String fName){
		fileName = fName;
		processedCode = new ArrayList<String>();
	}
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
			System.out.print("int");
		} else if (type.equals("STRING")) {
			System.out.print("String");
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
		System.out.println("public static void main(String[] args) {");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBody(knightCodeParser.BodyContext ctx) { 
		System.out.println("}");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStat(knightCodeParser.StatContext ctx) { 
		//System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStat(knightCodeParser.StatContext ctx) { 
		String text = ctx.getText();
		if(!text.contains("IF") && !text.contains("WHILE"))
			System.out.println(";");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSetvar(knightCodeParser.SetvarContext ctx) { 
		String text = ctx.getText();
		text = text.replaceFirst("SET", "");
		text = text.replaceAll(":", "");
		if(!text.contains("\""))
			System.out.print(text.substring(0, text.indexOf("=")+1));
		else
			System.out.print(text);

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
		String text = ctx.getText();
		boolean print = true;

		if(ctx.getParent().getText().startsWith("IF")) {
			System.out.print("if(");
		}

		if(text.contains("<")){
			//text = text.substring(0, text.indexOf("<"));
			print = false;
		}else if(text.contains(">")){
			//text = text.substring(0, text.indexOf(">"));
			print = false;
		}else if(text.contains("=") && !text.contains(":=")){
			//text = text.substring(0, text.indexOf("="));
			print = false;
		}else if(text.contains("*")){
			//text = text.substring(0, text.indexOf("*"));
			print = false;
		}else if(text.contains("/")){
			//text = text.substring(0, text.indexOf("/"));
			print = false;
		}else if(text.contains("+")){
			//text = text.substring(0, text.indexOf("+"));
			print = false;
		}else if(text.contains("-")){
			//text = text.substring(0, text.indexOf("-"));
			print = false;
		}
		
		if(print)
			System.out.print(text);

		//System.out.println("Parent of " + ctx.getText() + ": " + ctx.getParent().getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExpr(knightCodeParser.ExprContext ctx) { 
	/*	String text = ctx.getText();
		boolean print = true;
		if(text.contains("<") && !text.contains("<>")){
			text = text.substring(text.indexOf("<")+1);
			print = false;
		}else if(text.contains(">")){
			text = text.substring(text.indexOf(">")+1);
			print = false;
		}else if(text.contains("=") && !text.contains(":=")){
			text = text.substring(text.indexOf("=")+1);
			print = false;
		}else if(text.contains("*")){
                        text = text.substring(text.indexOf("*")+1);
			print = false;
                }else if(text.contains("/")){
                        text = text.substring(text.indexOf("/")+1);
			 print = false;
                }else if(text.contains("+")){
                        text = text.substring(text.indexOf("+")+1);
			 print = false;
                }else if(text.contains("-")){
                        text = text.substring(text.indexOf("-")+1);
			 print = false;
		}

		if (print)
			System.out.print(text);*/
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterComp(knightCodeParser.CompContext ctx) { 
		String text = ctx.getText();
		if(text.equals("<>"))
			text = "!=";
		if(text.equals("="))
			text = "==";
		System.out.print(text);
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
        @Override public void enterMuldiv(knightCodeParser.MuldivContext ctx) {
                String text = ctx.getText();
                System.out.print(text);
        }
        /**
         * {@inheritDoc}
         *
         * <p>The default implementation does nothing.</p>
         */
        @Override public void exitMuldiv(knightCodeParser.MuldivContext ctx) {
                //System.out.println(ctx.getText());
        }
        /**
         * {@inheritDoc}
         *
         * <p>The default implementation does nothing.</p>
         */
        @Override public void enterAddsub(knightCodeParser.AddsubContext ctx) {
                String text = ctx.getText();
                System.out.print(text);
        }
        /**
         * {@inheritDoc}
         *
         * <p>The default implementation does nothing.</p>
         */
        @Override public void exitAddsub(knightCodeParser.AddsubContext ctx) {
                //System.out.println(ctx.getText());
        }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterPrint(knightCodeParser.PrintContext ctx) { 
		String text = ctx.getText();
		text = text.replaceFirst("PRINT", "");
		System.out.print("System.out.println(" + text + ")");
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
		//System.out.print("if(");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDecision(knightCodeParser.DecisionContext ctx) { 
		
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
