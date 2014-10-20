package Nodes.turtlecommands;

import Backend.Turtle;
import Nodes.ConstantNode;
import Nodes.Node;

public class TurnLeftNode extends CommandNode {
	
	public TurnLeftNode (Turtle myTurtle) {
		super(myTurtle);
	}

	@Override
	public Node update() {
		printValue = ((ConstantNode) left).returnData();
		turtle.setLocation(turtle.nextLocation(printValue, 0));
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
