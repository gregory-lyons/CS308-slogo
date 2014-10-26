package Nodes.conditionals;

import Nodes.ConstantNode;
import Nodes.Node;
import Nodes.booleans.BooleanNode;

public abstract class ConditionalNode extends Node {
	
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
	
	@Override 
	public Node update() {
		try {
			if (left.returnPrintValue() == 1) {
				this.printValue = 1;
			}
			else {
				this.printValue = 0;
			}
			return super.update();
		}
		catch (Exception e) {
			return super.update();
		}
		
	}

}
