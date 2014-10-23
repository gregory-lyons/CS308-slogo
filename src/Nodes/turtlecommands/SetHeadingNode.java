package Nodes.turtlecommands;

import Nodes.ConstantNode;
import Nodes.Node;

public class SetHeadingNode extends CommandNode{

	@Override
	public Node update() {
		double newAngle = ((ConstantNode)left).returnData();
		printValue = newAngle-myTurtle.getRotate();
		myTurtle.setRotate(newAngle);
		return super.update();
	}

	@Override
	public boolean noMoreChildren() {
		return(left instanceof ConstantNode);
	}

}
