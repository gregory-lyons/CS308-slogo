package Nodes.booleans;

import Nodes.ConstantNode;
import Nodes.Node;

public abstract class BooleanNode extends Node{

	protected Node left;
	protected Node right;	
	
	public boolean isFinished() {
		return (right instanceof ConstantNode);
	}
	
	public void addChildren(Node newNode) {
		super.addChildren(newNode);
		if (left == null)
			left = newNode;
		else
			right = newNode;
	}
	
	public void clear() {
		left = null;
		right = null;
	}

}
