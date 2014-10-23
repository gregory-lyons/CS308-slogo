package Nodes.turtlecommands;

import Backend.Turtle;
import Nodes.ConstantNode;
import Nodes.Node;

public class IsPenDownNode extends CommandNode{

	@Override
	public Node update() {
		// TODO Auto-generated method stub
		if(myTurtle.penStatus()) printValue = 1;
		else printValue = 0;
		return new ConstantNode(printValue);
	}

	@Override
	public boolean noMoreChildren() {
		// TODO Auto-generated method stub
		return true;
	}

}
