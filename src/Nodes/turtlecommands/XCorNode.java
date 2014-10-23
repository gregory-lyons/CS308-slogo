package Nodes.turtlecommands;

import Nodes.Node;

public class XCorNode extends ZeroChildrenNode {

	@Override
	public Node update() {
		printValue = myTurtle.getXCord();
		return super.update();
	}
}
