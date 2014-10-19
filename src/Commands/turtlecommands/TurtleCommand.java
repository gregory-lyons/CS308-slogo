package Commands.turtlecommands;

import java.util.List;

import Backend.Turtle;
import Commands.Command;

public class TurtleCommand extends Command {
	
	protected Turtle myTurtle;
	
	
	public TurtleCommand(Turtle turtle) {
		super();	
		myTurtle = turtle;
	}
	
	public Turtle getTurtle() {
		return myTurtle;
	}
	

}
