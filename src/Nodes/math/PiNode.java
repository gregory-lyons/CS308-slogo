package Nodes.math;

import Nodes.Node;

public class PiNode extends MathNode{

	@Override
	public boolean noMoreChildren() {
		return true;
	}
	
	public Node update(){
		printValue = Math.PI;
		return super.update();
	}

}
