package Nodes.turtlecommands;

import javafx.geometry.Point2D;
import Nodes.ConstantNode;
import Nodes.Node;

public class SetTowardsNode extends TwoChildNode {

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
}
