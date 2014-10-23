package Nodes.turtlecommands;

import Backend.Turtle;
import Commands.Command;
import Nodes.Node;

public abstract class CommandNode extends Node{

	protected Turtle myTurtle;
	protected Node left;
	protected Node right;
	
	@Override
	public void addChildren(Node newNode) {
		super.addChildren(newNode);
		left = newNode;
	}
	
	public void addTurtle(Turtle newTurtle){
		myTurtle = newTurtle;
	}
	
}
