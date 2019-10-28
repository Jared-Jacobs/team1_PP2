// Generated from knightCode.g4 by ANTLR 4.7.2

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.ArrayList;
import java.util.regex.*;
import java.util.HashMap;

/**
 * This class provides an empty implementation of {@link knightCodeListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class kcListener extends knightCodeBaseListener {

	
	private String fileName;
	private String nodeText;
	private ArrayList<String> outputCode;
	private HashMap<String, String> symbolTable;
	
	
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
		outputCode = new ArrayList<String>();
		symbolTable = new HashMap<String, String>();
	}
	
	/**
	 * Getter for our ArrayList of completed code
	 */
	public ArrayList<String> getOutputCode() {
		return outputCode;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(ParserRuleContext ctx) { 
		nodeText = ctx.getText();
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFile(knightCodeParser.FileContext ctx) {
		outputCode.add("import java.util.Scanner;");
		
		String tmp = fileName.replace(".java", "");
		outputCode.add("public class " + tmp);
		outputCode.add("{");
		outputCode.add("public static void main(String[] args)");
		outputCode.add("{");
		outputCode.add("Scanner scan = new Scanner(System.in);");
	 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFile(knightCodeParser.FileContext ctx) { 
		outputCode.add("}");
		outputCode.add("}");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDeclare(knightCodeParser.DeclareContext ctx) {
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
		String tmp = nodeText;

		String type = tmp.substring(0, 3); //since the variable declaration will always start with INTEGER or STRING,
										   //this will always give either INT or STR
		String id;
		if (tmp.startsWith("INTEGER"))
			id = tmp.substring(7); // number of letters in "INTEGER"
		else
			id = tmp.substring(6); // number of letters in "STRING"
		
		symbolTable.put(id, type);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitVariable(knightCodeParser.VariableContext ctx) { 
		String tmp = ctx.getText(); // for some reason exitEveryRule wasn't setting the nodeText correctly here

		if (tmp.contains("INTEGER")) {
			tmp = tmp.replaceAll("INTEGER", "");
		} else if (tmp.contains("STRING")) {
			tmp = tmp.replaceAll("STRING", "");
		}
		tmp += ";";
		outputCode.add(tmp);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterType(knightCodeParser.TypeContext ctx) { 
		String tmp = nodeText;
		if(tmp.equals("INTEGER")) {
			tmp = "int";
		}
		if(tmp.equals("STRING")) {
			tmp = "String";
		}
		outputCode.add(tmp);
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
		//outputCode.add("public static void main(String[] args)");
		//outputCode.add("{");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBody(knightCodeParser.BodyContext ctx) { 
		//outputCode.add("}");
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
		if(!nodeText.contains("IF") && !nodeText.contains("WHILE"))
			outputCode.add(";");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSetvar(knightCodeParser.SetvarContext ctx) { 
		String tmp = nodeText;
		tmp = tmp.replaceFirst("SET", "");
		tmp = tmp.replaceFirst(":", "");
		outputCode.add(tmp);
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
		/*String text = ctx.getText();
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

		//System.out.println("Parent of " + ctx.getText() + ": " + ctx.getParent().getText());*/
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
		/*String text = ctx.getText();
		if(text.equals("<>"))
			text = "!=";
		if(text.equals("="))
			text = "==";
		System.out.print(text);*/
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
		String tmp = nodeText;
		tmp = tmp.replaceFirst("PRINT", "");
		outputCode.add("System.out.println(" + tmp + ")");
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
		String tmp = nodeText;
		tmp = tmp.replace("READ", "");
		String tmpType = symbolTable.get(tmp);
		if(tmpType.equals("STR")) {
			outputCode.add(tmp + " = scan.nextLine()");
		} else if (tmpType.equals("INT")){
			outputCode.add(tmp + "= scan.nextInt()");
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitRead(knightCodeParser.ReadContext ctx) { 

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDecision(knightCodeParser.DecisionContext ctx) { 
		String tmp = nodeText;
		tmp = tmp.replaceAll("(?<=THEN).*$","");
		tmp = tmp.replace("IF", "if(");
		tmp = tmp.replace("THEN", ")");
		tmp = tmp.replace("=", "==");
		tmp = tmp.replace("<>", "!=");
		
		outputCode.add(tmp);
		outputCode.add("{");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDecision(knightCodeParser.DecisionContext ctx) { 
		outputCode.add("}");
	}
	
	@Override public void enterIndecision(knightCodeParser.IndecisionContext ctx) {
		outputCode.add("}");
		outputCode.add("else");
		outputCode.add("{");
	}
	
	@Override public void exitIndecision(knightCodeParser.IndecisionContext ctx) {
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLoop(knightCodeParser.LoopContext ctx) { 
		String tmp = nodeText;
		
		tmp = tmp.replaceAll("(?<=DO).*$","");
		tmp = tmp.replace("WHILE", "while(");
		tmp = tmp.replace("DO", ")");
		tmp = tmp.replace("=", "==");
		tmp = tmp.replace("<>", "!=");
		
		outputCode.add(tmp);
		outputCode.add("{");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLoop(knightCodeParser.LoopContext ctx) { 
		outputCode.add("}");
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEveryRule(ParserRuleContext ctx) { 
		nodeText = ctx.getText();
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
