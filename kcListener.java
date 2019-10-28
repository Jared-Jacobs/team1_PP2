import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.ArrayList;
import java.util.regex.*;
import java.util.HashMap;

/**
* Methods are called as the parse tree is walked,
* translates the knightCode into java code
* and puts it into the outputCode ArrayList,
* which can then be accessed with the getOutPutCode() method
* @author Josh Coffey
* @author Jared Jacobs
* @author Stephen Love
* @version 1.0
* Programming Project Two
* CS322 - Compiler Construction
* Fall 2019
**/
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
	 * @param fName The file name
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
	
	// Below this point everything is pretty self explanitory:
	// everything that starts with enter is called when entering
	// a node of the parse tree of the rule in the name of the method, and
	// everything that starts with exit is called when
	// exiting a node of the rule in the name of the method,
	// everything takes an argument called ctx, which is the ParserRuleContext
	// for that node
	

	@Override public void enterEveryRule(ParserRuleContext ctx) { 
		nodeText = ctx.getText();
	}
	
	
	@Override public void exitEveryRule(ParserRuleContext ctx) { 
		nodeText = ctx.getText();
	}
	

	@Override public void enterFile(knightCodeParser.FileContext ctx) {
		outputCode.add("import java.util.Scanner;");
		
		String tmp = fileName.replace(".java", "");
		outputCode.add("public class " + tmp);
		outputCode.add("{");
		outputCode.add("public static void main(String[] args)");
		outputCode.add("{");
		outputCode.add("Scanner scan = new Scanner(System.in);");
	 }


	@Override public void exitFile(knightCodeParser.FileContext ctx) { 
		outputCode.add("}");
		outputCode.add("}");
	}
	

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


	@Override public void exitStat(knightCodeParser.StatContext ctx) { 
		if(!nodeText.contains("IF") && !nodeText.contains("WHILE"))
			outputCode.add(";");
	}


	@Override public void enterSetvar(knightCodeParser.SetvarContext ctx) { 
		String tmp = nodeText;
		tmp = tmp.replaceFirst("SET", "");
		tmp = tmp.replaceFirst(":", "");
		outputCode.add(tmp);
	}
    

	@Override public void enterPrint(knightCodeParser.PrintContext ctx) { 
		String tmp = nodeText;
		tmp = tmp.replaceFirst("PRINT", "");
		outputCode.add("System.out.println(" + tmp + ")");
	}


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
	

	@Override public void exitDecision(knightCodeParser.DecisionContext ctx) { 
		outputCode.add("}");
	}
	
	@Override public void enterIndecision(knightCodeParser.IndecisionContext ctx) {
		outputCode.add("}");
		outputCode.add("else");
		outputCode.add("{");
	}
	


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
	

	@Override public void exitLoop(knightCodeParser.LoopContext ctx) { 
		outputCode.add("}");
	}

}
