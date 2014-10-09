package Commands.turtlecommands;

import Backend.Turtle;
import Commands.Command;

public class PenUpCommand extends TurtleCommand {
	
	public static final int returnValue = 0;

	public PenUpCommand(Command parent, Turtle turtle) {
		super(parent, turtle);
		myTurtle.setPenUp();
	}

}
