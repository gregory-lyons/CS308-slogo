package Nodes.turtlecommands;

import Nodes.ConstantNode;
import Nodes.Node;

public abstract class OneChildNode extends CommandNode {

	public void addChildren(Node newNode) {
		super.addChildren(newNode);
		left = newNode;

	}

	@Override
	public boolean noMoreChildren() {
		return(left instanceof ConstantNode);
	}

}
