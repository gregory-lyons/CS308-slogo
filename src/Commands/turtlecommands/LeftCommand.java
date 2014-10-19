package Commands.turtlecommands;

import java.util.List;

import Backend.Turtle;
import Commands.Command;

public class LeftCommand extends TurtleCommand {	
	
	public final double returnValue;
	
	public LeftCommand(Turtle turtle, double degrees) {
		super(turtle);
		myTurtle.setAngle(myTurtle.getAngle() - degrees);
		returnValue = degrees;
	}
	
	

}
