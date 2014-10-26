package Nodes;

public class ConstantNode extends Node {

	public ConstantNode(double data) {
		printValue = data;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	public double returnData(){
		System.out.println(printValue);
		return printValue;
	}
}
