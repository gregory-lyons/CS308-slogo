package Nodes;

import java.util.ArrayList;


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
	
	public Node getParent(){
		return parent;
	}
	
	public double returnPrintValue(){
		return printValue;
	}
	
}
