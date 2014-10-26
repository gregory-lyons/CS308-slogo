package Nodes;

public class ToNode extends Node {
	
	protected Node right;
	protected Node left;

	@Override
	public boolean isFinished() {
		return (right instanceof ConstantNode);
	}
	
	
	
	

}
