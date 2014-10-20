package Nodes.turtlecommands;

import Backend.Turtle;
import Nodes.ConstantNode;
import Nodes.Node;

public class BackwardNode extends CommandNode {
	
	public BackwardNode(Turtle turtle) {
		super(turtle);
	}
	
	@Override
	public Node update() {
		printValue = ((ConstantNode) left).returnData();
		myTurtle.setLocation(myTurtle.nextLocation(printValue, 0));
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
