package Nodes.turtlecommands;

import Nodes.ConstantNode;
import Nodes.Node;

public class ForwardNode extends OneChildNode {

	@Override
	public Node update() {
		printValue = ((ConstantNode)left).returnData();
		myTurtle.addLocation(myTurtle.nextLocation(printValue, 0));
		return super.update();
	}
}
