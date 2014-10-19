package Nodes;

public class ConstantNode extends Node {

	private double info;

	public ConstantNode(double data) {
		info = data;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Node update() {
		return null;
	}

	public void addChildren(Node newNode) {
		super.addChildren(newNode);
	}

	@Override
	public boolean noMoreChildren() {
		// TODO Auto-generated method stub
		return true;
	}

	public double returnData(){
		return info;
	}
}
