package Nodes.math;

import Nodes.ConstantNode;
import Nodes.Node;

public class OneChildNode extends MathNode{

	public void addChildren(Node newNode) {
		super.addChildren(newNode);
		left = newNode;

	}

	@Override
	public boolean isFinished() {
		return(left instanceof ConstantNode);
	}
	
}
