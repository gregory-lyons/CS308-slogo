package Backend;

import static org.junit.Assert.*;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import javafx.geometry.Point2D;

import org.junit.Test;

import Nodes.ConstantNode;
import Nodes.Node;
import Nodes.booleans.AndNode;
import Nodes.math.ProductNode;
import Nodes.math.SumNode;
import Nodes.turtlecommands.ForwardNode;
import Nodes.turtlecommands.RightNode;

public class Tester {

	AST tree = new AST();
	
	@Test
	public void testIfTurtleMovesForwardAndRotates() {
		Turtle checkTurtle = new Turtle(new Point2D(0,50), 90, 1);
		Turtle testTurtle = new Turtle(new Point2D(0,0), 0 , 1);
		Queue<Node> moves = new ArrayDeque<Node>();
		ForwardNode fd = new ForwardNode();
		fd.addTurtle(testTurtle);
		RightNode rt = new RightNode();
		rt.addTurtle(testTurtle);
		moves.add(fd);
		moves.add(new ConstantNode(50));
		moves.add(rt);
		moves.add(new ConstantNode(90));
		tree.populateTree(moves);
		assertEquals(testTurtle, checkTurtle);
	}
	
	@Test
	public void testIfAdditionWorks(){
		SumNode sum = new SumNode();
		ConstantNode five = new ConstantNode(5);
		ConstantNode nine = new ConstantNode(9);
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.add(sum);
		queue.add(five);
		queue.add(nine);
		List<Double> results = tree.populateTree(queue);
		double result = results.get(0);
		assertEquals(14.0, result, .01);
	}
	
	@Test
	public void testIfNestedPrintStatementsWork(){
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.add(new SumNode());
		queue.add(new ConstantNode(300));
		queue.add(new AndNode());
		queue.add(new ConstantNode(1));
		queue.add(new ConstantNode(5));
		List<Double> results = tree.populateTree(queue);
		assertEquals(results.get(1), 301, .1);
		
	}

}
