package Nodes.turtlecommands;

import Nodes.Node;

public class IsPenDownNode extends CommandNode{

	@Override
	public Node update() {
		// TODO Auto-generated method stub
		if(myTurtle.penStatus()) printValue = 1;
		else printValue = 0;
		return super.update();
	}

}
