package Nodes;


public abstract class Node {
	
	private Node parent;
	
	public abstract Node update();

	public abstract boolean noMoreChildren();
	
	private void setParent(Node newNode){
		parent = newNode;
	}

	public void addChildren(Node newNode){
		newNode.setParent(this);
	}
	
	public Node getParent(){
		return parent;
	}
	
}
