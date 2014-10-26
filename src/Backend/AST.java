package Backend;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import Nodes.ConstantNode;
import Nodes.Node;
import Nodes.loops.RepeatNode;

public class AST {
	
	private Queue<Node> copyQ(Queue<Node> q) {
		Queue<Node> q1 = new ArrayDeque<Node>();
		Queue<Node> q2 = new ArrayDeque<Node>();
		while (!(q.isEmpty())) {
			Node x = q.poll();
			q1.add(x);
			q2.add(x);
		}
		q = q1;
		return q2;
	}


	public List<Double> populateTree(Queue<Node> nodes) {
		Node current = null;
		List<Double> returnValues = new ArrayList<Double>();
		while (!nodes.isEmpty() || current != null) {
			if (current == null) {
				current = nodes.poll();
			} else if (current instanceof ConstantNode) {
				current = current.getParent();
			} else if (current.isFinished()) {
				Node replace = current.update();
				returnValues.add(current.returnPrintValue());
				if (current.getParent() != null) {
					current = current.getParent();
					current.addChildren(replace);
				} else
					current = null;
			}
			else if (current instanceof RepeatNode){
				System.out.println("xyz");
				current.addChildren(nodes.poll());
				List<Double> values = new ArrayList<Double>();
				
				for (int i = 0; i < (((RepeatNode) current).counter); i++) {
					Queue<Node> copy = new ArrayDeque<Node>();
					copy.addAll(nodes);
					System.out.println("made it");
					Queue<Node> newCopy = ((RepeatNode) current).iterator(copy);
					System.out.println("dhbfsdkhbf");
					values = populateTree(newCopy);
					
					
				}
				System.out.println(values);
				ConstantNode con = new ConstantNode(values.get(values.size() - 1));
				current = current.getParent();
				current.addChildren(con);
				
			} 
			else {
				Node newNode = nodes.poll();
				current.addChildren(newNode);
				current = newNode;
			}
		}
		return returnValues;
	}

}
