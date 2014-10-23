package Nodes.turtlecommands;

import Nodes.Node;

public class HeadingNode extends CommandNode {

	@Override
	public Node update() {
		printValue = myTurtle.getRotate();
		return super.update();
	}
}
