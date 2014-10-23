package Backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import Nodes.Node;

public class AST {

	private Node current;
	
	public List<Double> populateTree(Queue<Node> nodes) {
		List<Double> returnValues = new ArrayList<Double>();
		while (!nodes.isEmpty() || current != null) {
			if (current == null) {
				current = nodes.poll();
			}
			if (current.noMoreChildren()) {
				Node replace = current.update(); //set current node to ConstantNode so it can be used
				returnValues.add(current.returnPrintValue()); 
				current = current.getParent(); 
				current.addChildren(replace);
			} else {
				Node newNode = nodes.poll();
				current.addChildren(newNode);
				current = newNode;
			}
		}
		return returnValues;
	}

}
