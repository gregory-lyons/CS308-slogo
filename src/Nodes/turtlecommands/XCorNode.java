package Nodes.turtlecommands;

import Nodes.Node;

public class XCorNode extends CommandNode {

	@Override
	public Node update() {
		printValue = myTurtle.getXCord();
		return super.update();
	}
}
