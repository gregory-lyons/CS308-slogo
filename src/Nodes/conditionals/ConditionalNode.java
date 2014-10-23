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
	
	@Override 
	public Node update() {
		
		if (myChildren != null) {
			for (Node n: myChildren) {
				if (n.returnPrintValue() == 0) {
					this.printValue = 0;
					return super.update();
				}
				else {
					this.printValue = 1;
				}
			}
		}
		return super.update();
	}

}
