package Nodes.turtlecommands;

import Backend.Turtle;
import Nodes.ConstantNode;
import Nodes.Node;

public class BackNode extends CommandNode{
	
	@Override
	public Node update() {
		printValue = ((ConstantNode)left).returnData();
		myTurtle.addLocation(myTurtle.nextLocation(printValue, 180));
		return left;
	}

	@Override
	public void addChildren(Node newNode) {
		super.addChildren(newNode);
		left = newNode;
	}

	@Override
	public boolean noMoreChildren() {
		return(left instanceof ConstantNode);
	}

}
