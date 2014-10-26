package Nodes.math;

import Nodes.ConstantNode;
import Nodes.Node;

public class SumNode extends TwoChildNode{

	public Node update(){
		printValue = ((ConstantNode) left).returnData() + ((ConstantNode) right).returnData();
		System.out.println(((ConstantNode) left).returnData());
		System.out.println(((ConstantNode) right).returnData());
		System.out.println(printValue);
		return super.update();
	}
	
}
