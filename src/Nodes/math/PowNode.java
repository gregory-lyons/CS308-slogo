package Nodes.math;

import Nodes.ConstantNode;
import Nodes.Node;

public class PowNode extends TwoChildNode{

	public Node update(){
		printValue = Math.pow(((ConstantNode) left).returnData(), ((ConstantNode) right).returnData());
		return super.update();
	}
	
}
