package Nodes.conditionals;

import Nodes.ConstantNode;
import Nodes.Node;

public abstract class ConditionalNode extends Node {
	
	protected Node left;
	protected Node right;
	
	public boolean noMoreChildren() {
		return (right instanceof ConstantNode);
	}
	
	public void addChildren(Node newNode) {
		super.addChildren(newNode);
		if (left == null)
			left = newNode;
		else
			right = newNode;
	}

}
