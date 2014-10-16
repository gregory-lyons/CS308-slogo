package Backend;

import java.util.Queue;

import Nodes.ConstantNode;
import Nodes.Node;

public class AST {

	private Node current;
	private Queue<Node> nodes;

	public AST(Queue<Node> listOfNodes) {
		nodes = listOfNodes;
	}

	public void populateTree() {
		while (!nodes.isEmpty()) {
			if (current == null) {
				current = nodes.poll();
			}
			if (current.noMoreChildren()) {
				current.update();
				current = current.getParent();
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
