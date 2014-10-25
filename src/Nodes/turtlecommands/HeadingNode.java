package Nodes.turtlecommands;

import Nodes.Node;

public class HeadingNode extends ZeroChildrenNode {

	@Override
	public Node update() {
		printValue = myTurtle.getRotate();
		return super.update();
	}
}
