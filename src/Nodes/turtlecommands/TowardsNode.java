package Nodes.turtlecommands;

import javafx.geometry.Point2D;
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
		return super.update();
	}

	public void addChildren(Node newNode) {
		if (left == null)
			super.addChildren(newNode);
		else {
			newNode.setParent(this);
			myChildren.add(newNode);
			right = newNode;
		}
	}

	@Override
	public boolean noMoreChildren() {
		// TODO Auto-generated method stub
		return (right instanceof ConstantNode);
	}

}
