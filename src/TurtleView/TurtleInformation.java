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
 * @author Rica
 *
 */
public class TurtleInformation {
    private VBox myVBox = new VBox();
    private Point2D turtlePosition = new Point2D(0,0);
    private String turtleHeading = "Bob";
    private double turtleDirection = 0;
    
    private Label turtleHeadingLabel;
    private Label turtlePositionLabel;
    private Label turtleDirectionLabel;
    
    public TurtleInformation() {
        turtlePositionLabel = new Label("Turtle Position: (" + turtlePosition.getX() + "," + turtlePosition.getY() + ")");
        turtleHeadingLabel = new Label("Turtle Heading: " + turtleHeading);
        turtleDirectionLabel = new Label("Turtle is Facing: " + turtleDirection + " degrees");
        myVBox.getChildren().addAll(turtleHeadingLabel, turtlePositionLabel, turtleDirectionLabel);
    }
    
    public VBox getVBox() {
        return myVBox;
    }


    public void update(List<Turtle> turtles) {
    	//TODO Fix this stuff
    	/*
    	double newX = list.get(list.size()-1).getX();
    	double newY = list.get(list.size()-1).getY();
        turtlePositionLabel.setText("Turtle Position: (" + newX + "," + newY + ")");
        turtleDirection += angle;
        turtleDirectionLabel.setText("Turtle is Facing: " + turtleDirection + " degrees");
        */
    }

}
