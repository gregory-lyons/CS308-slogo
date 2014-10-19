package Nodes.booleancommands;

import Nodes.ConstantNode;
import Nodes.Node;

public class LessNode extends BooleanNode {

	@Override
	public Node update() {
		if (((ConstantNode) left).returnData() < ((ConstantNode) right)
				.returnData())
			printValue = 1;
		else
			printValue = 0;
		return new ConstantNode(printValue);
	}

	@Override
	public boolean noMoreChildren() {
		// TODO Auto-generated method stub
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
