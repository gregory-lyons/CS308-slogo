package Nodes.turtlecommands;

import javafx.geometry.Point2D;
import Nodes.ConstantNode;
import Nodes.Node;

public class SetXYNode extends TwoChildNode {

	@Override
	public Node update() {
		Point2D nextPoint = new Point2D(((ConstantNode) left).returnData(),
				((ConstantNode) right).returnData());
		printValue = nextPoint.distance(myTurtle.getLocation());
		myTurtle.addLocation(nextPoint);
		return super.update();
	}
}
