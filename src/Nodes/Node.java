package Nodes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;


public abstract class Node {
	
	private Node parent;
	protected double printValue;
	protected ArrayList<Node> myChildren = new ArrayList<Node>();
	
	public abstract boolean isFinished();
	
	public void setParent(Node node){
		parent = node;
	}
	
	public Node update(){
		return new ConstantNode(printValue);
	}

	public void addChildren(Node node){
		node.setParent(this);
		myChildren.add(node);
	}
	
	public void clearChildren(){
		myChildren.clear();
	}
	
	public Node getParent(){
		return parent;
	}
	
	public double returnPrintValue(){
		return printValue;
	}
	
	public Queue<Node> commandsExtractor (Queue<Node> n) {
		Queue<Node> ret = new ArrayDeque<Node>();
		n.poll();
		while (!(n.peek() instanceof ListEndNode)) {
			ret.add(n.poll());
		}
		return ret;
	}
	
	public Queue<Node> expressionExtractor(Queue<Node> n) {
		Queue<Node> ret = new ArrayDeque<Node>();
		
		while (!(n.peek() instanceof ListStartNode)) {
			ret.add(n.poll());
		}
		
		return ret;
	}
	
}
