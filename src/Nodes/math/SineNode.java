package Nodes.math;

import Nodes.ConstantNode;
import Nodes.Node;

public class SineNode extends OneChildNode{
	
	public Node update(){
		printValue = Math.sin(Math.toRadians(((ConstantNode)left).returnData()));
		return super.update();
	}

}
