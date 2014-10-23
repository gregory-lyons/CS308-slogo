package Nodes.turtlecommands;

import Nodes.Node;

public class ShowTurtleNode extends ZeroChildrenNode{

	
	public Node update(){
		myTurtle.show();
		printValue = 1;
		return super.update();
	}
}
