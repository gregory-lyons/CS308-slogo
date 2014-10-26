package Nodes;

public class ToNode extends Node {
	
	protected Node right;
	protected Node left;

	@Override
	public boolean noMoreChildrenNeeded() {
		return (right instanceof ConstantNode);
	}
	
	
	
	

}
