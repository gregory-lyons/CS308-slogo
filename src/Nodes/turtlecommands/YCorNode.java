package Nodes.turtlecommands;

import Nodes.Node;

public class YCorNode extends ZeroChildrenNode {
	@Override
	public Node update() {
		printValue = myTurtle.getYCord();
		return super.update();
	}
}
