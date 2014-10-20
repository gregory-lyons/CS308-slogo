package Nodes.turtlecommands;

import Backend.Turtle;
import Nodes.*;


public class UpPenNode  extends CommandNode {

	public UpPenNode(Turtle turtle) {
		super(turtle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Node update() {
		myTurtle.setPenUp();
		return left;
	}
	
	@Override
	public void addChildren(Node newNode) {
		super.addChildren(newNode);
		left = newNode;
	}

	@Override
	public boolean noMoreChildren() {
		return (left instanceof ConstantNode);
	}

}
