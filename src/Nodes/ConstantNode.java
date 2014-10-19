package Nodes;

public class ConstantNode extends Node{

	private double info;
	
	public ConstantNode(double data) {
		info = data;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addChildren(Node newNode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean noMoreChildren() {
		// TODO Auto-generated method stub
		return true;
	}

}
