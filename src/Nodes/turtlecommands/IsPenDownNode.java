package Nodes.turtlecommands;

import Nodes.Node;

public class IsPenDownNode extends ZeroChildrenNode {

	@Override
	public Node update() {
		// TODO Auto-generated method stub
		printValue = (myTurtle.penStatus()) ? 1:0;
		return super.update();
	}

}
