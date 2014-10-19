package Nodes.turtlecommands;

import Backend.Turtle;
import Commands.Command;
import Nodes.ConstantNode;
import Nodes.Node;

public class ForwardNode extends CommandNode{

	public ForwardNode(Turtle myTurtle) {
		super(myTurtle);
		right = null;
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void update() {
		
	}

	@Override
	public void addChildren(Node newNode) {
		left = newNode;
	}

	@Override
	public boolean noMoreChildren() {
		return(left instanceof ConstantNode);
	}

	

}
