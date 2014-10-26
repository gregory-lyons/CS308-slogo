package Nodes.booleans;

import Nodes.ConstantNode;
import Nodes.Node;

public class LessNode extends BooleanNode {

	@Override
	public Node update() {
		if (((ConstantNode) left).returnData() < ((ConstantNode) right)
				.returnData()){
		System.out.println(((ConstantNode) left).returnData());
			System.out.println(((ConstantNode) right).returnData());
			printValue = 1;
		}else
			printValue = 0;
		return super.update();
	}

}
