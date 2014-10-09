package Commands;

import Backend.Turtle;

public class PenUpCommand extends TurtleCommand {
	
	public static final int returnValue = 0;

	public PenUpCommand(Command parent, Turtle turtle) {
		super(parent, turtle);
		myTurtle.setPenUp();
	}

}
