package Backend;

import Commands.Command;

/**
 * 
 * @author Ashwin 
 * Probably going to be deleted and replaced with the interpreter
 * in the long run, used to decide which command to use
 */

public class Decider {

	private Command command;
	private String commandType;
	private double data;
	private Turtle turtle;
	public Decider(String input, double number, Turtle myTurtle) {
		commandType = input;
		data = number;
		turtle = myTurtle;
	}

	public Command returnType() {
		if (commandType == "FORWARD" || commandType == "FD") {
			return ForwardCommand(command, turtle, data);
		}
	}

}
