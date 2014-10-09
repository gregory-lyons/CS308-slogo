package Commands.turtlecommands;

import java.util.List;

import Backend.Turtle;

public class LeftCommand extends TurtleCommand {	
	
	public final double returnValue;
	
	public LeftCommand(Command parent, Turtle turtle, double degrees) {
		super(parent, turtle);
		myTurtle.setAngle(myTurtle.getAngle() - degrees);
		returnValue = degrees;
	}
	
	

}
