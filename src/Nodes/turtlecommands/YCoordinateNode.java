package Nodes.turtlecommands;

import Nodes.Node;
import TurtleView.PointConverter;

public class YCoordinateNode extends ZeroChildrenNode {
	@Override
	public Node update() {
		printValue = PointConverter.convertActualToUserY(myTurtle.getYCord());		
		return super.update();
	}
}
