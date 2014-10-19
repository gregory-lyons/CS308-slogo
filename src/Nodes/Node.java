package Nodes;


public abstract class Node {
	
	private Node parent;
	
	public abstract void update();
	public abstract void addChildren(Node newNode);	
	public abstract boolean noMoreChildren();
	
	public void setParent(Node newNode){
		parent = newNode;
	}
	
	public Node getParent(){
		return parent;
	}
	
}
