package Nodes.math;

import Nodes.ConstantNode;
import Nodes.Node;

public class ArcTangentNode extends OneChildNode{
	
	public Node update(){
		printValue = Math.atan(Math.toRadians(((ConstantNode)left).returnData()));
		return super.update();
	}

}
