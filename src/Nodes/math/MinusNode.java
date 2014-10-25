package Nodes.math;

import Nodes.ConstantNode;
import Nodes.Node;

public class MinusNode extends OneChildNode{

	public Node update(){
		printValue = -((ConstantNode) left).returnData();
		return super.update();
	}
	
}
