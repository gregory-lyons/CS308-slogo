package Backend;

import Nodes.ConstantNode;
import Nodes.Node;

public class AST {

	private Node current;
	
	public AST(Node first){
		current = first;
		first.setParent(null);
	}
	
	public void checkIfHappy(){
		if(current.noMoreChildren()){
			current.update();
			current = current.getParent();
		}
	}
	
	
	public void newNode(Node newNode){
			newNode.setParent(current);
			current = newNode;
	}
	
	private boolean checkIfConstant(Node newNode){
		if(current instanceof ConstantNode){
			current = current.getParent();
			return true;
		}
		return false;
	}
	
	
	
}
