package Nodes.turtlecommands;

import Nodes.Node;

public class IsShowingNode extends ZeroChildrenNode{
	
	public Node update(){
		printValue = myTurtle.getOpacity();
		return super.update();
	}

}
