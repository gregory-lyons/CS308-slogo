package Nodes.conditionals;

import Nodes.ConstantNode;
import Nodes.Node;
import Nodes.booleans.BooleanNode;

public abstract class ConditionalNode extends Node {
	
	public Node left;
	public Node right;
	
	public boolean isFinished() {
		return (right instanceof ConstantNode);
	}
	
	public void addChildren(Node newNode) {
		super.addChildren(newNode);
		if (newNode instanceof BooleanNode)
			left = newNode;
		else
			right = newNode;
	}
	
	
	

	
	public void clear() {
		left = null;
		right = null;
	}

}
