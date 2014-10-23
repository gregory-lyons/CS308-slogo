package Nodes.loops;

import Nodes.ConstantNode;
import Nodes.Node;

public class ForNode extends LoopNode {
	
	protected double myIndex = ((ConstantNode) left).returnData();
	
	@Override
	public Node update() {
		

		
	}

}
