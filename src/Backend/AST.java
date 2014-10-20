package Backend;

import java.util.Queue;

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

}
