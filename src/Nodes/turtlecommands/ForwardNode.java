package Nodes.turtlecommands;

import Nodes.ConstantNode;
import Nodes.Node;

public class ForwardNode extends CommandNode {

	@Override
	public Node update() {
		printValue = ((ConstantNode)left).returnData();
		myTurtle.addLocation(myTurtle.nextLocation(printValue, 0));
		return super.update();
	}

	@Override
	public boolean noMoreChildren() {
		return (left instanceof ConstantNode);
	}

}
