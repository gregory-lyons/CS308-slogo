package Nodes.math;

import Nodes.ConstantNode;
import Nodes.Node;

public abstract class MathNode extends Node{

	protected Node left;
	protected Node right;
	
	public boolean noMoreChildren() {
		return (right instanceof ConstantNode);
	}
	
	
}
