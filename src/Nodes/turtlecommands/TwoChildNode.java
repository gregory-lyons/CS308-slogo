package Nodes.turtlecommands;

import Nodes.ConstantNode;
import Nodes.Node;

public abstract class TwoChildNode extends CommandNode {

	public void addChildren(Node newNode) {
		super.addChildren(newNode);
		if (left == null)
			left = newNode;
		else
			right = newNode;
	}

	@Override
	public boolean noMoreChildren() {
		// TODO Auto-generated method stub
		return (right instanceof ConstantNode);
	}
}
