package Nodes.turtlecommands;

import javafx.geometry.Point2D;
import Backend.Turtle;
import Nodes.ConstantNode;
import Nodes.Node;

public class HomeNode extends CommandNode{

	public HomeNode(Turtle turtle) {
		super(turtle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Node update() {
		Point2D nextPoint = new Point2D(0,0);
		printValue = nextPoint.distance(myTurtle.getLocation());
		myTurtle.setLocation(nextPoint);
		return new ConstantNode(printValue);
	}


	@Override
	public boolean noMoreChildren() {
		// TODO Auto-generated method stub
		return true;
	}

}
