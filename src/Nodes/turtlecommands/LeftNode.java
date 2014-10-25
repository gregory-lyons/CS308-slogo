package Nodes.turtlecommands;

import Nodes.ConstantNode;
import Nodes.Node;

public class LeftNode extends OneChildNode {

	@Override
	public Node update() {
		printValue = ((ConstantNode) left).returnData();
		myTurtle.setRotate(myTurtle.getRotate() - printValue);
		return super.update();
	}
}
