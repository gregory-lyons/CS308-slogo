package Nodes.conditionals;

import java.util.ArrayDeque;
import java.util.Queue;

import Nodes.ConstantNode;
import Nodes.ListEndNode;
import Nodes.ListStartNode;
import Nodes.Node;
import Nodes.booleans.BooleanNode;
import Nodes.turtlecommands.CommandNode;
import junit.framework.Assert;
import junit.framework.TestCase;

public class IfNodeTester extends TestCase {
	
	
	
	Queue<Node> testQ = new ArrayDeque<Node>();
	Queue<Node> testQ1 = new ArrayDeque<Node>();
	Queue<Node> expressionQ = new ArrayDeque<Node>();
	Queue<Node> commandQ = new ArrayDeque<Node>();
	IfNode nI;
	ConstantNode n;
	BooleanNode n1;
	ConstantNode n2;
	ConstantNode n3;
	ListStartNode n4;
	CommandNode n5;
	ConstantNode n6;
	ListEndNode n7;
	
	public IfNodeTester() {
		testQ.add(nI);
		testQ.add(n);
		testQ.add(n1);
		testQ.add(n2);
		testQ.add(n3);
		testQ.add(n4);
		testQ.add(n5);
		testQ.add(n6);
		testQ.add(n7);
		testQ1.addAll(testQ);
		
		expressionQ.add(n);
		expressionQ.add(n1);
		expressionQ.add(n2);
		expressionQ.add(n3);
		
		commandQ.add(n5);
		commandQ.add(n6);
	}
	
	public void testExpressionExtractor() {
		assertEquals(expressionQ, testQ.peek().expressionExtractor(testQ));
	}
	
	public void testCommandExtractor() {
		assertEquals(commandQ, testQ1.peek().expressionExtractor(testQ1));
	}
	
	public static void main (String[] args) {
		
	}
	
	
	
	
	
	
	

}
