package Nodes.conditionals;

import java.util.ArrayDeque;
import java.util.Queue;

import Nodes.ListEndNode;
import Nodes.ListStartNode;
import Nodes.Node;

public class IfNode extends ConditionalNode {
	
	@Override 
	public Node update() {
		this.printValue = 0;
		try {
			if (left.returnPrintValue() == 1) {
				this.printValue = 1;
				right.update();
			}
			return super.update();
		}
		catch (Exception e) {
			return super.update();
		}
		
	}
	

}
