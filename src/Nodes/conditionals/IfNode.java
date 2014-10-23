package Nodes.conditionals;

import Nodes.ConstantNode;
import Nodes.Node;
import Nodes.booleans.BooleanNode;

public class IfNode extends ConditionalNode {
	
	@Override 
	public Node update() {
		if (left instanceof BooleanNode) {
			if (left.returnPrintValue() == 1) {
				this.printValue = 1;
			}
			else {
				this.printValue = 0;
			}
		}
		return super.update();
	}
	

}
