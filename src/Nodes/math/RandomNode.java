package Nodes.math;

import java.util.Random;

import Nodes.ConstantNode;
import Nodes.Node;

public class RandomNode extends OneChildNode{
	
	public Node update(){
		double random = new Random().nextDouble();
		printValue = random*((ConstantNode) left).returnData();
		return super.update();
	}

}
