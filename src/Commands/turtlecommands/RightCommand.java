package Commands.turtlecommands;

import Backend.Turtle;

public class RightCommand extends TurtleCommand {
	
	public final double returnValue;
	
	public RightCommand(TurtleCommand parent, Turtle turtle, double degrees) {
		super(parent, turtle);
		myTurtle.setAngle(myTurtle.getAngle() + degrees);
		returnValue = degrees;
	}
	
	
	
}
