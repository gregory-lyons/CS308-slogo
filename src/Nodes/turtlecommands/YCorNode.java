package Nodes.turtlecommands;

import Nodes.Node;

public class YCorNode extends CommandNode {
	@Override
	public Node update() {
		printValue = myTurtle.getYCord();
		return super.update();
	}
}
