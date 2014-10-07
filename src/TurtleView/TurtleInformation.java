package TurtleView;

import java.util.Observable;
import java.util.Observer;
import com.sun.javafx.geom.Point2D;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Tells the user information about the turtle, updates whenever the turtle changes because it is an observer of the turtle
 * @author Rica
 *
 */
public class TurtleInformation implements Observer {
    private VBox myVBox = new VBox();
    private Point2D turtlePosition = new Point2D(0,0);
    private String turtleHeading = "Bob";
    private double turtleDirection = 0;
    
    private Label turtleHeadingLabel;
    private Label turtlePositionLabel;
    private Label turtleDirectionLabel;
    
    public TurtleInformation() {
        turtlePositionLabel = new Label("Turtle Position: (" + turtlePosition.x + "," + turtlePosition.y + ")");
        turtleHeadingLabel = new Label("Turtle Heading: " + turtleHeading);
        turtleDirectionLabel = new Label("Turtle is Facing: " + turtleDirection + " degrees");
        myVBox.getChildren().addAll(turtleHeadingLabel, turtlePositionLabel, turtleDirectionLabel);
    }
    
    public VBox getVBox() {
        return myVBox;
    }

    @Override
    public void update (Observable arg0, Object arg1) {
        // TODO update whenever the turtle is moved
        
    }

}
