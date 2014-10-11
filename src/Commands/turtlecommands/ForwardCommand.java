package Commands.turtlecommands;

import java.util.List;

import javafx.geometry.Point2D;
import Backend.Turtle;
import Commands.Command;

public class ForwardCommand extends TurtleCommand {
	
	private Turtle myTurtle;
	private double angle;
	private Point2D location;
	private Point2D newLocation;
	private double xPos;
	private double yPos;
	public final double returnValue;

	public ForwardCommand(Command parent, Turtle turtle, double distance) {
		super(parent, turtle);
		angle = myTurtle.getAngle();
		location = myTurtle.getLocation().get(myTurtle.getLocation().size());
		xPos = location.getX();
		yPos = location.getY();
		xPos += xPos*Math.sin(angle);
		yPos += yPos*Math.cos(angle);
		newLocation = new Point2D(xPos,yPos);
		myTurtle.setLocation(newLocation);
		returnValue = distance;
		// TODO Auto-generated constructor stub
	}

}
