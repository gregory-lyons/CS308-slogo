package Nodes.turtlecommands;

import javafx.geometry.Point2D;
import Nodes.Node;

public class HomeNode extends ZeroChildrenNode {

	@Override
	public Node update() {
		Point2D nextPoint = new Point2D(0, 0);
		printValue = nextPoint.distance(myTurtle.getLocation());
		myTurtle.addLocation(nextPoint);
		return super.update();
	}

}
