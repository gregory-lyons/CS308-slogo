package Nodes.math;

import Nodes.ConstantNode;
import Nodes.Node;

public class NaturalLogNode extends OneChildNode{
	
	public Node update(){
		printValue = Math.log((((ConstantNode)left).returnData()));
		return super.update();
	}
}
