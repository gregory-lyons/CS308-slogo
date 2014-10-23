package Nodes.turtlecommands;

import Backend.Turtle;
import Nodes.ConstantNode;
import Nodes.Node;

public class DownPenNode extends CommandNode {

	@Override
	public Node update() {
		myTurtle.setPenDown();
		return new ConstantNode(1);
	}

	@Override
	public boolean noMoreChildren() {
		return true;
	}

}
