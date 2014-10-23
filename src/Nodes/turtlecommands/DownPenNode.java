package Nodes.turtlecommands;

import Nodes.Node;

public class DownPenNode extends ZeroChildrenNode {

	@Override
	public Node update() {
		myTurtle.setPenDown();
		printValue = 1;
		return super.update();
	}

}
