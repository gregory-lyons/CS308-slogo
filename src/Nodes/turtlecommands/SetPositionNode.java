package Nodes.turtlecommands;

import javafx.geometry.Point2D;
import Nodes.ConstantNode;
import Nodes.Node;
import TurtleView.PointConverter;

public class SetPositionNode extends TwoChildNode {

	@Override
	public Node update() {
		Point2D nextPoint = new Point2D(((ConstantNode) left).returnData(),
				((ConstantNode) right).returnData());
		nextPoint = PointConverter.convertUserToActualPoint(nextPoint);
		printValue = nextPoint.distance(myTurtle.getLocation());
		myTurtle.addLocation(nextPoint);
		return super.update();
	}
}
