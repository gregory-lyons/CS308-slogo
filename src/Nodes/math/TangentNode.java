package Nodes.math;

import Nodes.ConstantNode;
import Nodes.Node;

public class TangentNode extends OneChildNode{
	
	public Node update(){
		printValue = Math.tan(Math.toRadians(((ConstantNode)left).returnData()));
		return super.update();
	}

}
