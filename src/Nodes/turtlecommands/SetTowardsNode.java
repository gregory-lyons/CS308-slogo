package Nodes.turtlecommands;

import javafx.geometry.Point2D;
import Nodes.ConstantNode;
import Nodes.Node;
import TurtleView.PointConverter;

public class SetTowardsNode extends TwoChildNode {

	@Override
	public Node update() {
		Point2D turnPoint = new Point2D(((ConstantNode) left).returnData(),
				((ConstantNode) right).returnData());
		turnPoint = PointConverter.convertUserToActualPoint(turnPoint);
		double dx = turnPoint.getX() - myTurtle.getXCord();
		double dy = myTurtle.getYCord() - turnPoint.getY();
		double theta = Math.atan2(dx, dy);
		theta = Math.toDegrees(theta);
		printValue = theta + myTurtle.getRotate();
		myTurtle.setAngle(theta);
		return super.update();
	}
}
