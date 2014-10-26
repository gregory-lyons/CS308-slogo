package Nodes.math;

import Nodes.ConstantNode;
import Nodes.Node;

public class TwoChildNode extends MathNode {

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return (left instanceof ConstantNode && right instanceof ConstantNode);
	}

	public void addChildren(Node newNode) {
		super.addChildren(newNode);
		if (left == null)
			left = newNode;
		else
			right = newNode;
	}

}
