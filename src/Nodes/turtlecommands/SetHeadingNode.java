package Nodes.turtlecommands;

import Backend.Turtle;
import Nodes.ConstantNode;
import Nodes.Node;

public class SetHeadingNode extends CommandNode{

	@Override
	public Node update() {
		double newAngle = ((ConstantNode)left).returnData();
		printValue = newAngle-myTurtle.getRotate();
		myTurtle.setRotate(newAngle);
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
