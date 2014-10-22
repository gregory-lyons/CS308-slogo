package Nodes.booleans;

import Nodes.ConstantNode;
import Nodes.Node;

public class OrNode extends BooleanNode {

	@Override
	public Node update() {
		if (((ConstantNode) left).returnData() != 0
				|| ((ConstantNode) right).returnData() != 0) {
			printValue = 1;
		} else
			printValue = 0;
		return new ConstantNode(printValue);
	}

}
