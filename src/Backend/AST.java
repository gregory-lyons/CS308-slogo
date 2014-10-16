package Backend;

import Nodes.ConstantNode;
import Nodes.Node;

public class AST {

	private Node current;
	private Node parent;
	
	public AST(Node first){
		current = first;
		first.setParent(null);
	}
	
	public void newNode(Node newNode){
		if(current instanceof ConstantNode){
			
		}
		else{
			newNode.setParent(current);
			current = newNode;
		}
	}
	
	private boolean checkIfConstant(Node newNode){
		if(current instanceof ConstantNode){
			current = current.getParent();
			return true;
		}
		return false;
	}
	
	
	
}
