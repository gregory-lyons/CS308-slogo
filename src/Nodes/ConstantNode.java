package Nodes;

public class ConstantNode extends Node{

	private double info;
	
	public ConstantNode(Node first, Node second, double data) {
		super(first, second);
		info = data;
		// TODO Auto-generated constructor stub
	}

}
