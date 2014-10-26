package Nodes.loops;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

import Nodes.*;

public class RepeatNode extends Node {
	
	public double counter;
	
	public void addChildren(Node newNode) {
		if (myChildren.isEmpty()) {
			counter = ((ConstantNode) newNode).returnData();
		}
		super.addChildren(newNode);
	}
	
	@Override
	public boolean isFinished() {
		return false;
	}
	
	public Queue<Node> iterator(Queue<Node> copy) {
		Queue<Node> ret = new ArrayDeque<Node>();
		copy.poll();
		while (!(copy.peek() instanceof ListEndNode)) {
			ret.add(copy.poll());
		}
		return ret;
	}

}
