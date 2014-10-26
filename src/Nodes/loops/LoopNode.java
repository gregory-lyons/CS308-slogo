package Nodes.loops;

import Nodes.ConstantNode;
import Nodes.Node;

public class LoopNode extends Node {
	
	protected Node left;
	protected Node right;
	
	public boolean noMoreChildrenNeeded() {
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
