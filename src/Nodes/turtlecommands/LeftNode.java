package Nodes.turtlecommands;

import Backend.Turtle;
import Nodes.ConstantNode;
import Nodes.Node;

public class LeftNode extends CommandNode{

	public LeftNode(Turtle myTurtle) {
		super(myTurtle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Node update() {
		printValue = ((ConstantNode)left).returnData();
		myTurtle.setRotate(myTurtle.getRotate() - printValue);
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
