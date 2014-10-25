package Nodes.math;

import Nodes.ConstantNode;
import Nodes.Node;

public class AtanNode extends OneChildNode{
	
	public Node update(){
		printValue = Math.atan(((ConstantNode)left).returnData());
		return super.update();
	}

}
