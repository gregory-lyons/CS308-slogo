package Nodes.turtlecommands;

import javafx.geometry.Point2D;
import Backend.Turtle;
import Nodes.ConstantNode;
import Nodes.Node;

public class TowardsNode extends CommandNode {

	@Override
	public Node update() {
		Point2D turnPoint = new Point2D(((ConstantNode) left).returnData(),
				((ConstantNode) right).returnData());
		double dx = turnPoint.getX() - myTurtle.getXCord();
		double dy = turnPoint.getY() - myTurtle.getYCord();
		double theta = Math.atan2(dx, dy);
		theta = Math.toDegrees(theta);
		printValue = theta - myTurtle.getRotate();
		myTurtle.setRotate(theta);
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
