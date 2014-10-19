package Backend;

import java.util.Queue;

import Nodes.ConstantNode;
import Nodes.Node;

public class AST {

	private Node current;
	
	public void populateTree(Queue<Node> nodes) {
		while (!nodes.isEmpty() || current != null) {
			if (current == null) {
				current = nodes.poll();
			}
			if (current.noMoreChildren()) {
				Node replace = current.update();
				current = current.getParent();
				current.addChildren(replace);
			} else {
				Node newNode = nodes.poll();
				current.addChildren(newNode);
				current = newNode;
			}
		}
	}

//	public void checkIfHappy() {
//		if (current.noMoreChildren()) {
//			current.update();
//			current = current.getParent();
//		}
//	}
//
//	public void newNode(Node newNode) {
//		newNode.setParent(current);
//		current = newNode;
//	}
//
//	private boolean checkIfConstant(Node newNode) {
//		if (current instanceof ConstantNode) {
//			current = current.getParent();
//			return true;
//		}
//		return false;
//	}

}
