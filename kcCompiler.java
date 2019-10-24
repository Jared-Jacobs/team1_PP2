import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
import java.io.InputStream;

public class kcCompiler {
    public static void main(String[] args) throws Exception {
        
	String inputFile = null; 
	String mode = null;
	if (args.length > 0)
		mode = args[0];
        if ( args.length > 1 ) 
		inputFile = args[1];
        
	InputStream is = System.in;
        
	if ( inputFile!=null ) 
		is = new FileInputStream(inputFile);
        
	ANTLRInputStream input = new ANTLRInputStream(is); 
        knightCodeLexer lexer = new knightCodeLexer(input); 
        CommonTokenStream tokens = new CommonTokenStream(lexer); 
        knightCodeParser parser = new knightCodeParser(tokens); 
        
	parser.removeErrorListeners();

	parser.addErrorListener(new ErrorListener());

	ParseTree tree = parser.file(); // start at the program label

	ParseTreeWalker walker = new ParseTreeWalker();
		
	kcListener l = new kcListener();
	walker.walk(l, tree);
	}//end main
}//end class
