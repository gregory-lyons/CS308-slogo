package Nodes.turtlecommands;

import Nodes.Node;

public class HideTurtleNode extends ZeroChildrenNode{

	
	public Node update(){
		myTurtle.hide();
		printValue = 0;
		return super.update();
	}
}
