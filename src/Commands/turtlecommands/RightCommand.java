package Commands.turtlecommands;

import Backend.Turtle;

public class RightCommand extends TurtleCommand {
	
	public final double returnValue;
	
	public RightCommand(Turtle turtle, double degrees) {
		super(turtle);
		myTurtle.setAngle(myTurtle.getAngle() + degrees);
		returnValue = degrees;
	}
	
	
	
}
