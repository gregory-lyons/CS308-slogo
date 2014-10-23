package Nodes.turtlecommands;

import javafx.geometry.Point2D;
import Backend.Turtle;
import Nodes.ConstantNode;
import Nodes.Node;

public class HomeNode extends CommandNode{

	@Override
	public Node update() {
		Point2D nextPoint = new Point2D(0,0);
		printValue = nextPoint.distance(myTurtle.getLocation());
		myTurtle.addLocation(nextPoint);
		return new ConstantNode(printValue);
	}


	@Override
	public boolean noMoreChildren() {
		// TODO Auto-generated method stub
		return true;
	}

}
