package Nodes;

import java.util.ArrayList;


public abstract class Node {
	
	private Node parent;
	protected double printValue;
	protected ArrayList<Node> myChildren;
	
	public abstract Node update();

	public abstract boolean noMoreChildren();
	
	private void setParent(Node node){
		parent = node;
	}

	public void addChildren(Node node){
		node.setParent(this);
	}
	
	public Node getParent(){
		return parent;
	}
	
}
