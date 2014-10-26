package Nodes.turtlecommands;

import Nodes.Node;


public class PenUpNode  extends ZeroChildrenNode {

	@Override
	public Node update() {
		myTurtle.setPenUp();
		printValue = 0;
		return super.update();
	}
}
