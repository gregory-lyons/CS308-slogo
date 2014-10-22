package Nodes.booleans;

import Nodes.ConstantNode;
import Nodes.Node;

public class NotNode extends BooleanNode{

	@Override
	public boolean noMoreChildren() {
		// TODO Auto-generated method stub
		return (left instanceof ConstantNode);
	}
	
	public void addChildren(Node newNode) {
		super.addChildren(newNode);
			left = newNode;
	}
	
	@Override
	public Node update() {
		if(((ConstantNode) left).returnData() == 0) printValue = 1;
		else printValue = 0;
		return new ConstantNode(printValue);
	}

}
