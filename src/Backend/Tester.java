package Backend;

import static org.junit.Assert.*;

import java.util.ArrayDeque;
import java.util.Queue;

import javafx.geometry.Point2D;

import org.junit.Test;

import Nodes.ConstantNode;
import Nodes.Node;
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
		
	}

}
