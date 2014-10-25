package Nodes;

public class ToNode extends Node {
	
	protected Node right;
	protected Node left;

	@Override
	public boolean noMoreChildren() {
		return (right instanceof ConstantNode);
	}
	
	
	
	

}
