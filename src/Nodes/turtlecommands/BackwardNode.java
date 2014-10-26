package Nodes.turtlecommands;

import Nodes.ConstantNode;
import Nodes.Node;

public class BackwardNode extends OneChildNode {

	@Override
	public Node update() {
		printValue = ((ConstantNode) left).returnData();
		myTurtle.addLocation(myTurtle.nextLocation(printValue, 180));
		return super.update();
	}
}
