package Nodes.turtlecommands;

import Backend.Turtle;
import Nodes.ConstantNode;
import Nodes.Node;

public class YCorNode extends CommandNode{

	public YCorNode(Turtle turtle) {
		super(turtle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Node update() {
		printValue = myTurtle.getLocation().getY();
		return new ConstantNode(printValue);
	}

	@Override
	public boolean noMoreChildren() {
		// TODO Auto-generated method stub
		return true;
	}

}
