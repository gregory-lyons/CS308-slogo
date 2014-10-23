package Nodes.turtlecommands;

import javafx.geometry.Point2D;
import Backend.Turtle;
import Nodes.ConstantNode;
import Nodes.Node;

public class TowardsNode extends CommandNode {

	public TowardsNode(Turtle myTurtle) {
		super(myTurtle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Node update() {
		Point2D turnPoint = new Point2D(((ConstantNode) left).returnData(),
				((ConstantNode) right).returnData());
		if (myTurtle.getLocation().getX() != turnPoint.getX()) {
			double slope = (myTurtle.getLocation().getY() - turnPoint.getY())
					/ (myTurtle.getLocation().getX() - turnPoint.getX());
			double newAngle = Math.atan(slope);
			if (slope != 0) {
				if (slope > 0) {
					if (turnPoint.getX() < myTurtle.getLocation().getX()) {
						newAngle = newAngle + 180;
					}
				}
				if (slope < 0) {
					if (turnPoint.getX() > myTurtle.getLocation().getX()) {
						newAngle = 360 - newAngle;
					} else if (turnPoint.getX() < myTurtle.getLocation().getX()) {
						newAngle = 180 - newAngle;
					}
				}
			}
		}
		
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
