package Nodes.math;

import Nodes.Node;

public class PiNode extends MathNode{

	@Override
	public boolean noMoreChildrenNeeded() {
		return true;
	}
	
	public Node update(){
		printValue = Math.PI;
		return super.update();
	}

}
