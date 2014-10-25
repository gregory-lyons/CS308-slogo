package Nodes.math;

import Nodes.ConstantNode;
import Nodes.Node;

public class TanNode extends OneChildNode{
	
	public Node update(){
		printValue = Math.tan(((ConstantNode)left).returnData());
		return super.update();
	}

}
