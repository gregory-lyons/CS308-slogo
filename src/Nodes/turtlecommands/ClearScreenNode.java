package Nodes.turtlecommands;

import Nodes.Node;

public class ClearScreenNode extends HomeNode{

	@Override
	public Node update(){
		myTurtle.setClear();
		return super.update();
	}

}
