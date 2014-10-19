package Nodes.turtlecommands;

import Backend.Turtle;
import Commands.Command;
import Commands.turtlecommands.ForwardCommand;
import Nodes.ConstantNode;
import Nodes.Node;

public class ForwardNode extends CommandNode{

	public ForwardNode(Turtle myTurtle) {
		super(myTurtle);
		right = null;
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public Node update() {
		ForwardCommand forwardCommand = new ForwardCommand(turtle, ((ConstantNode)left).returnData());
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
