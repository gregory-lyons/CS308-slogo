package Commands.turtlecommands;

import java.util.List;

import Backend.Turtle;

public class PenDownCommand extends TurtleCommand {
	
	public static final int returnValue = 1;

	public PenDownCommand(Turtle turtle) {
		super(turtle);
		myTurtle.setPenDown();
	}

}
