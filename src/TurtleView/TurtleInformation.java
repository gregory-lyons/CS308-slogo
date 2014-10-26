package TurtleView;


import Backend.Turtle;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

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
		turtlePositionLabel = new Label("Turtle Position: ");
		turtleDirectionLabel = new Label("Direction (degrees): ");
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
			turtleIndexLabel.textProperty().set(String.valueOf(myTurtle.getID()));
			turtleIndexLabel.setText("Turtle Index: "+String.valueOf(myTurtle.getID()));
			turtlePositionLabel.setText("Turtle Position: (" + truncate(myTurtle.getXCord()) + "," + truncate(myTurtle.getYCord()) + ")");
			turtleDirectionLabel.setText("Turtle is Facing: " + truncate(myTurtle.getRotate()) + " degrees");
		}
	}

	private void emptyInfo(){
		turtleIndexLabel.setText("No turtle selected");
		turtlePositionLabel.setText("");
		turtleDirectionLabel.setText("");
	}
	
	private double truncate(double val){
		  if ( val > 0 )
		    return Math.floor(val * 100)/100;
		  else
		    return Math.ceil(val * 100)/100;
		}



}
