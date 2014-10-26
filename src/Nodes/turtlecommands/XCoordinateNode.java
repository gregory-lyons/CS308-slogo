package Nodes.turtlecommands;

import Nodes.Node;
import TurtleView.PointConverter;

public class XCoordinateNode extends ZeroChildrenNode {

	@Override
	public Node update() {
		printValue = PointConverter.convertActualToUserX(myTurtle.getXCord());
		System.out.println(myTurtle.getXCord());
		System.out.println(printValue);
		return super.update();
	}
}
