package Nodes.turtlecommands;

import javafx.geometry.Point2D;
import Nodes.Node;
import TurtleView.PointConverter;

public class HomeNode extends ZeroChildrenNode {

	@Override
	public Node update() {
		Point2D nextPoint = new Point2D(0, 0);
		nextPoint = PointConverter.convertUserToActualPoint(nextPoint);
		printValue = nextPoint.distance(myTurtle.getLocation());
		myTurtle.addLocation(nextPoint);
		return super.update();
	}

}
