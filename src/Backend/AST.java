package Backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import Nodes.ConstantNode;
import Nodes.Node;

public class AST {

	private Node current = null;

	public List<Double> populateTree(Queue<Node> nodes) {
		List<Double> returnValues = new ArrayList<Double>();
		while (!nodes.isEmpty() || current != null) {
			if (current == null) {
				current = nodes.poll();
			} else if (current instanceof ConstantNode) {
				current = current.getParent();
			} else if (current.noMoreChildrenNeeded()) {
				Node replace = current.update();
				returnValues.add(current.returnPrintValue());
				if (current.getParent() != null) {
					current = current.getParent();
					current.addChildren(replace);
				} else
					current = null;
			} else {
				Node newNode = nodes.poll();
				current.addChildren(newNode);
				current = newNode;
			}
		}
		return returnValues;
	}

}
