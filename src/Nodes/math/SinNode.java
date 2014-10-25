package Nodes.math;

import Nodes.ConstantNode;
import Nodes.Node;

public class SinNode extends OneChildNode{
	
	public Node update(){
		printValue = Math.sin(((ConstantNode)left).returnData());
		return super.update();
	}

}
