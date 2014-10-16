package Nodes.turtlecommands;

import Backend.Turtle;
import Commands.Command;
import Nodes.Node;

public abstract class CommandNode extends Node{

	protected Command command;
	protected Turtle turtle;
	
	public CommandNode(Node first, Node second, Turtle myTurtle) {
		super(first, second);
		turtle = myTurtle;
		// TODO Auto-generated constructor stub
	}
	
}
