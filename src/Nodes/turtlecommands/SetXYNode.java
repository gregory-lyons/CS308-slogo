package Nodes.turtlecommands;

import javafx.geometry.Point2D;
import Backend.Turtle;
import Nodes.ConstantNode;
import Nodes.Node;

public class SetXYNode extends CommandNode {

	@Override
	public Node update() {
		Point2D nextPoint = new Point2D(((ConstantNode) left).returnData(),
				((ConstantNode) right).returnData());
		printValue = nextPoint.distance(myTurtle.getLocation());
		myTurtle.addLocation(nextPoint);
		return new ConstantNode(printValue);
	}

	public void addChildren(Node newNode) {
		super.addChildren(newNode);
		if (left == null)
			left = newNode;
		else
			right = newNode;
	}

	@Override
	public boolean noMoreChildren() {
		// TODO Auto-generated method stub
		return (right instanceof ConstantNode);
	}

}
