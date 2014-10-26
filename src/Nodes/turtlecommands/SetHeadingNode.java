package Nodes.turtlecommands;

import Nodes.ConstantNode;
import Nodes.Node;

public class SetHeadingNode extends OneChildNode{

	@Override
	public Node update() {
		double newAngle = ((ConstantNode)left).returnData();
		printValue = newAngle-myTurtle.getRotate();
		myTurtle.setAngle(newAngle);
		return super.update();
	}
}
