package Nodes.math;

import Nodes.ConstantNode;
import Nodes.Node;

public class CosNode extends OneChildNode{
	
	public Node update(){
		printValue = Math.cos(((ConstantNode)left).returnData());
		return super.update();
	}

}
