package Backend;

import java.util.ArrayList;
import java.util.List;

import FrontEndCommands.SuperCommand;

public class Interpreter {

	public Interpreter() {
		
	}
	
	/* This is just the shell method needs serious implementation still.
	 * Need to create another class that updates the statue of the turtle given 
	 */
	public List<String> getCommands(String input) {
		Parser parser = new Parser(input);
		List<String> commands = new ArrayList<String>();
		
		if (!parser.hasMore()) {return null;} 
		
		return commands;
	}
	
	

}
