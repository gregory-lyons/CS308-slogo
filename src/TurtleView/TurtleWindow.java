package TurtleView;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Backend.Turtle;
import FrontEnd.DefaultStrings;
import Pen.Pen;
import Pen.PenOptions;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;


/**
 * Stores the turtle and moves it around when commands are executed.
 * @author Greg Lyons, Rica Zhang
 *
 */
public class TurtleWindow extends Pane {

	public static final double ORIGIN_X = 200.0;
	public static final double ORIGIN_Y = 100.0;
	public static final double DEFAULT_ANGLE = 0;
	public static final Color DEFAULT_PEN = Color.BLACK;
	public static final String DEFAULT_BACKGROUND = DefaultStrings.BACKGROUND_COLOR_DEFAULTS.get(0);
	public static final String DEFAULT_IMAGE = "turtle1";
	public static final double WINDOW_WIDTH = 600.0;
	public static final double WINDOW_HEIGHT = 423.0;
	public static final double GRID_INTERVAL = 40.0;
	public static final double GRID_STROKE = 1.0;

	private List<Turtle> allTurtles;
	private List<Turtle> activeTurtles;
	private List<Line> myGridLines;
	private PenOptions myPenBox;
	private int numTurtles;

	public TurtleWindow(PenOptions penBox) {
		numTurtles = 2;
		myPenBox = penBox;
		allTurtles = new ArrayList<Turtle>();
		activeTurtles = new ArrayList<Turtle>();
		for (int i = 0; i<numTurtles; i++){
			makeTurtle();
		}
		myGridLines = new ArrayList<Line>();
		this.setMaxSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		changeBackgroundColor(DEFAULT_BACKGROUND);
		makeGrid();
	}

	public Turtle makeTurtle(){
		Point2D location = new Point2D(Math.random()*WINDOW_WIDTH, Math.random()*WINDOW_HEIGHT);
		Turtle newTurtle = new Turtle(location, DEFAULT_ANGLE);
		allTurtles.add(newTurtle);
		newTurtle.setOnMouseClicked(event -> click(newTurtle));
		this.getChildren().addAll(newTurtle, newTurtle.getRing());
		newTurtle.toFront();
		return newTurtle;
	}
	
	private void click(Turtle t){
		if (!activeTurtles.contains(t)) {
			activeTurtles.add(t);
			t.showRing();
			myPenBox.changePen(t.getPen());
		}
		else {
			activeTurtles.remove(t);
			t.hideRing();
			myPenBox.changePen(new Pen());
		}

	}
	
	public void update(List<Turtle> updates) {
		for (Turtle t: updates){
			this.getChildren().add(t.moveAndDrawPath());
			t.setRotate(t.getAngle());
		}
		for (Turtle t: allTurtles) 
			t.toFront();
	}

	public void changeBackgroundColor(String color){
		this.setStyle("-fx-background-color: " + color + ";");
	}

	public List<Turtle> getActiveTurtles(){
		return activeTurtles;

	}
	
	// TODO New method so that new images can be loaded

	/*public void startMovingTurtle (KeyEvent myKey) {
		// TODO remove counter
		int counter = 0;
		while (counter < 5) {
			System.out.println("Moving turtle...");
			counter += 1;
			for (TurtleImage t: activeTurtles){
				if (myKey.getCode() == KeyCode.UP) {
					t.move(t.getTurtleX() , t.getTurtleY()-5);
				}
				else if (myKey.getCode() == KeyCode.DOWN) {
					t.move(t.getTurtleX() , t.getTurtleY()+5);
				}
				else if (myKey.getCode() == KeyCode.LEFT) {
					t.move(t.getTurtleX()-5 , t.getTurtleY());
				}
				else if (myKey.getCode() == KeyCode.RIGHT) {
					t.move(t.getTurtleX()+5 , t.getTurtleY());
				}
			}
		}
		System.out.println("Stopped moving turtle\n"); 

	}   	    */

	private void makeGrid(){
		for (int i=0;i<WINDOW_WIDTH;i+=GRID_INTERVAL){
			Line l = new Line(i, 0, i, WINDOW_HEIGHT);
			l.setStroke(Color.GREY);
			myGridLines.add(l);
		}
		for (int i=0;i<WINDOW_HEIGHT;i+=GRID_INTERVAL){
			Line l = new Line(0, i, WINDOW_WIDTH, i);
			l.setStroke(Color.GREY);
			myGridLines.add(l);
		}
		this.getChildren().addAll(myGridLines);
	}

	public void gridLines(boolean gridOn){
		if (gridOn)
			for (Line l: myGridLines)
				l.setStrokeWidth(1);
		else
			for (Line l: myGridLines)
				l.setStrokeWidth(0);
	}
}
