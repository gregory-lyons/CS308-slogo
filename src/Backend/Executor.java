package Backend;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import FrontEndCommands.SuperCommand;

public class Executor {
	
	private Interpreter myInterpreter;
	private String myInput;
	LinkedList<Turtle> nextStates = new LinkedList<Turtle>();
	
	public Executor(String input) {
		myInput = input;
	}
	
	
	/* 
	 * Obviously still needs implementation.  This is how we will construct a list
	 * of successive states for the turtle to give to the front end.  I chose a linked list
	 * because it is doubly linked so we can go back to prior states if that's something we're 
	 * asked to do.  The only way I can think to do this method at the moment is to 
	 * iterate through the list of commands and then construct new turtles based on the commands.  
	 * I also want to discuss with the group what should be done about commands that don't actually 
	 * affect the state of the turtle.
	 */
	public List<Turtle> execute (List<String> commands) {
		
		
		for (String command: commands) {
			//code for how to construct each turtle to put into nextStates
		}
		
		return nextStates;
	}
	
	

}
