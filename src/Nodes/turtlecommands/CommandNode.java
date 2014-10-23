package Nodes.turtlecommands;

import Backend.Turtle;
import Nodes.Node;

public abstract class CommandNode extends Node {

	protected Turtle myTurtle;
	protected Node left;
	protected Node right;

	public void addTurtle(Turtle newTurtle) {
		myTurtle = newTurtle;
	}

}
