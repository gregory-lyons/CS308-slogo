package Commands.turtlecommands;

import java.util.List;

import Backend.Turtle;

public class TurtleCommand extends Command {
	
	protected Turtle myTurtle;
	
	
	public TurtleCommand(Command parent, Turtle turtle) {
		super(parent);	
		myTurtle = turtle;
	}
	
	public Turtle getTurtle() {
		return myTurtle;
	}
	

}
