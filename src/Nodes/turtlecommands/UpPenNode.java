package Nodes.turtlecommands;

import Nodes.Node;


public class UpPenNode  extends CommandNode {

	@Override
	public Node update() {
		myTurtle.setPenUp();
		printValue = 0;
		return super.update();
	}
}
