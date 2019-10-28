/**
* Serves as the main class for the project
* @author Jared Jacobs
* @author Josh Coffey
* @author Stephen Love
* @version 1.0
* Programming Project Two
* CS322 - Compiler Construction
* Fall 2019
**/

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.io.*;

public class kcCompiler {
    public static void main(String[] args) throws Exception {
		
		String mode = null;
		String inputFile = null;
		String outputFile = null;
		ArrayList<String> javaCode;
		
		if (args.length > 0)
			mode = args[0];
		if (args.length > 1) 
			inputFile = args[1];
		if (args.length > 2)
			outputFile = args[2];
			
		InputStream is = System.in;
			
		if ( inputFile!=null ) 
			is = new FileInputStream(inputFile);
			
		ANTLRInputStream input = new ANTLRInputStream(is); 
		knightCodeLexer lexer = new knightCodeLexer(input); 
		CommonTokenStream tokens = new CommonTokenStream(lexer); 
		knightCodeParser parser = new knightCodeParser(tokens); 
			
		parser.removeErrorListeners();

		parser.addErrorListener(new ErrorListener());

		ParseTree tree = parser.file(); // start at the file label

		ParseTreeWalker walker = new ParseTreeWalker();
			
		kcListener listener = new kcListener(outputFile);
		walker.walk(listener, tree);
		
		javaCode = listener.getOutputCode();
		
		try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "utf-8"))) {
			for(int i = 0; i < javaCode.size(); i++) {
				writer.write(javaCode.get(i));
				writer.write("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//end main
}//end class
