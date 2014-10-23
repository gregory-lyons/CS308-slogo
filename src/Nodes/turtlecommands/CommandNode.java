package Nodes.turtlecommands;

import Backend.Turtle;
import Nodes.Node;

public abstract class CommandNode extends Node {

	protected Turtle myTurtle;
	protected Node left;
	protected Node right;

	@Override
	public void addChildren(Node newNode) {
		if (left == null) {
			super.addChildren(newNode);
			left = newNode;
		}
	}

	@Override
	public boolean noMoreChildren() {
		return true;
	}

	public void addTurtle(Turtle newTurtle) {
		myTurtle = newTurtle;
	}

}
