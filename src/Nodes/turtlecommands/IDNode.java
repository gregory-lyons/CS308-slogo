package Nodes.turtlecommands;

import Nodes.Node;

public class IDNode extends ZeroChildrenNode{
	
	public Node update(){
		printValue = myTurtle.getID();
		return super.update();
	}
	
}
