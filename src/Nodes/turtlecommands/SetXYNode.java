package Nodes.turtlecommands;

import javafx.geometry.Point2D;
import Nodes.ConstantNode;
import Nodes.Node;

public class SetXYNode extends CommandNode {

	@Override
	public Node update() {
		Point2D nextPoint = new Point2D(((ConstantNode) left).returnData(),
				((ConstantNode) right).returnData());
		printValue = nextPoint.distance(myTurtle.getLocation());
		myTurtle.addLocation(nextPoint);
		return super.update();
	}

	public void addChildren(Node newNode) {
		if (left != null) {
			newNode.setParent(this);
			myChildren.add(newNode);
			right = newNode;
			return;
		}
		super.addChildren(newNode);
	}

	@Override
	public boolean noMoreChildren() {
		// TODO Auto-generated method stub
		return (right instanceof ConstantNode);
	}

}
