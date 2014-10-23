package Nodes.turtlecommands;

import Nodes.ConstantNode;
import Nodes.Node;

public class LeftNode extends CommandNode{

	@Override
	public Node update() {
		printValue = ((ConstantNode)left).returnData();
		myTurtle.setRotate(myTurtle.getRotate() - printValue);
		return super.update();
	}

	@Override
	public boolean noMoreChildren() {
		return(left instanceof ConstantNode);
	}

}
