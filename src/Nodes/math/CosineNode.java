package Nodes.math;

import Nodes.ConstantNode;
import Nodes.Node;

public class CosineNode extends OneChildNode{
	
	public Node update(){
		printValue = Math.cos(Math.toRadians(((ConstantNode)left).returnData()));
		return super.update();
	}

}
