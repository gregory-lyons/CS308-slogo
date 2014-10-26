package Nodes.turtlecommands;

import javafx.geometry.Point2D;
import Nodes.Node;
import TurtleView.PointConverter;

public class ClearScreenNode extends HomeNode{

	@Override
	public Node update(){
		myTurtle.setClear();
		return super.update();
	}

}
