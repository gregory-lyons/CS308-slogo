package Nodes.turtlecommands;

import Backend.Turtle;
import Commands.Command;
import Nodes.Node;

public abstract class CommandNode extends Node{

	protected Command command;
	protected Turtle turtle;
	protected Node left;
	protected Node right;
	
	public CommandNode(Turtle myTurtle) {
		turtle = myTurtle;
		// TODO Auto-generated constructor stub
	}
	
}
