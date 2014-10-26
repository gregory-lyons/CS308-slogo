package Nodes.turtlecommands;

import Nodes.Node;

public class YCoordinateNode extends ZeroChildrenNode {
	@Override
	public Node update() {
		printValue = myTurtle.getYCord();
		return super.update();
	}
}
