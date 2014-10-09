package Commands.turtlecommands;

import java.util.List;

import Backend.Turtle;

public class PenDownCommand extends TurtleCommand {
	
	public static final int returnValue = 1;

	public PenDownCommand(TurtleCommand parent, Turtle turtle) {
		super(parent, turtle);
		myTurtle.setPenDown();
	}

}
