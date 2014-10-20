package Nodes.turtlecommands;

import Backend.Turtle;
import Nodes.ConstantNode;
import Nodes.Node;

public class SetHeadingNode extends CommandNode{

	public SetHeadingNode(Turtle myTurtle) {
		super(myTurtle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Node update() {
		double newAngle = ((ConstantNode)left).returnData();
		printValue = Math.abs(newAngle-myTurtle.getAngle());
		myTurtle.setAngle(newAngle);
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
