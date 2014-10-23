package Nodes.turtlecommands;

import Nodes.ConstantNode;
import Nodes.Node;

public class BackNode extends OneChildNode {

	@Override
	public Node update() {
		printValue = ((ConstantNode) left).returnData();
		myTurtle.addLocation(myTurtle.nextLocation(printValue, 180));
		return super.update();
	}
}
