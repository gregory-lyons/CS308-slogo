package Nodes.turtlecommands;

import Backend.Turtle;
import Nodes.ConstantNode;
import Nodes.Node;

public class DownPenNode extends CommandNode {
	
	public DownPenNode(Turtle turtle) {
		super(turtle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Node update() {
		myTurtle.setPenDown();
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
