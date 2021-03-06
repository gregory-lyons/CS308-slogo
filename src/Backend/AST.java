package Backend;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import Nodes.ConstantNode;
import Nodes.ListEndNode;
import Nodes.Node;
import Nodes.booleans.BooleanNode;
import Nodes.conditionals.ConditionalNode;
import Nodes.loops.LoopNode;
import Nodes.turtlecommands.CommandNode;

/**
 * 
 * @author Ashwin, Justin
 *
 */


public class AST {
	
	public List<Double> populateTree(Queue<Node> nodes) {
		
		Node current = null;
		List<Double> returnValues = new ArrayList<Double>();
		while (!nodes.isEmpty() || current != null) {
			if (current == null) {
				current = nodes.poll();
			} else if (current instanceof ConstantNode) {
				if (current.getParent() == null) current = null;
				else {
					current = current.getParent();
				}
				
			} else if (current.isFinished()) {
				Node replace = current.update();
				returnValues.add(current.returnPrintValue());
				if (current.getParent() != null) {
					current = current.getParent();
					current.addChildren(replace);
				} else current = null;
			}
			else if (current instanceof LoopNode){
				
				current.addChildren(nodes.poll());
				List<Double> values = new ArrayList<Double>();
				
				for (int i = 0; i < (((LoopNode) current).counter); i++) {
					
					Queue<Node> copy = new ArrayDeque<Node>();
					Queue<Node> copy1 = new ArrayDeque<Node>();
					copy.addAll(nodes);
					while (!copy.isEmpty()) {
						Node n = copy.poll();
						n.clearChildren();
						if (n instanceof CommandNode) {
							((CommandNode) n).clear();
						}
						else if (n instanceof BooleanNode) {
							((BooleanNode) n).clear();
						}
						else if (n instanceof ConditionalNode) {
							((ConditionalNode) n).clear();
						}
						copy1.add(n);
					}
					Queue<Node> newCopy = ((LoopNode) current).iterator(copy1);
					values = populateTree(newCopy);
				}
				while (!(nodes.peek() instanceof ListEndNode)) {
					nodes.poll();
				}
				nodes.poll();
				ConstantNode con = new ConstantNode(values.get(values.size() - 1));
				current = current.getParent();
				if (current != null) current.addChildren(con);	
			} 
			else {
				Node newNode = nodes.poll();
				if (newNode != null) {
					current.addChildren(newNode);
					current = newNode;
				}
				else current = null;	
			}
		}
		return returnValues;
	}

}
