package Nodes.turtlecommands;

import Backend.Turtle;
import Nodes.*;


public class UpPenNode  extends CommandNode {

	@Override
	public Node update() {
		myTurtle.setPenUp();
		return new ConstantNode(0);
	}

	@Override
	public boolean noMoreChildren() {
		return true;
	}

}
