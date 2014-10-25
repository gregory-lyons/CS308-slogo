package TurtleView;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import Backend.Turtle;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Tells the user information about the turtle, updates whenever the turtle changes because it is an observer of the turtle
 * @author Greg Lyons, Rica Zhang
 *
 */
public class TurtleInformation extends VBox {
	private Turtle myTurtle;

	private Label turtleIndexLabel;
	private Label turtlePositionLabel;
	private Label turtleDirectionLabel;

	public TurtleInformation(Turtle t) {
		turtleIndexLabel = new Label();
		turtlePositionLabel = new Label();
		turtleDirectionLabel = new Label();
		changeTurtle(t);
		this.getChildren().addAll(turtleIndexLabel, turtlePositionLabel, turtleDirectionLabel);
	}

	public void changeTurtle(Turtle t) {
		myTurtle = t;
		update();
	}

	public void update(){
		if (myTurtle == null) 
			emptyInfo();
		else{
			turtleIndexLabel.setText("Turtle Index: " + myTurtle.getID());
			turtlePositionLabel.setText("Turtle Position: (" + myTurtle.getXCord() + "," + myTurtle.getYCord() + ")");
			turtleDirectionLabel.setText("Turtle is Facing: " + myTurtle.getRotate() + " degrees");
		}
	}

	private void emptyInfo(){
		turtleIndexLabel.setText("No turtle selected");
		turtlePositionLabel.setText("");
		turtleDirectionLabel.setText("");
	}



}
