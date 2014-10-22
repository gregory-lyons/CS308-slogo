package Nodes.booleancommands;

import Nodes.ConstantNode;
import Nodes.Node;

public class EqualsNode extends BooleanNode {
	
	@Override
	public Node update() {
		if (((ConstantNode) left).returnData() == ((ConstantNode) right)
				.returnData())
			printValue = 1;
		else
			printValue = 0;
		return new ConstantNode(printValue);
	}


}
