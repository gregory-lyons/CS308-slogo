package TurtleView;

import java.util.ArrayList;
import java.util.List;

import Backend.Turtle;
import FrontEnd.DefaultStrings;
import FrontEnd.View;
import FrontEnd.ViewConstants;
import Pen.Pen;
import Pen.PenOptions;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
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
	public static final int DEFAULT_TURTLE_INDEX = 0;

	public static final double GRID_INTERVAL = 40.0;
	public static final double GRID_STROKE = 1.0;
	public static final int START_TURTLES = 2;

	private List<Turtle> allTurtles;
	private List<Turtle> activeTurtles;
	private List<Line> myGridLines;
	private PenOptions myPenBox;
	private TurtleImageBox myTurtleImageBox;
	private TurtleInformation myTurtleInformation;
	private int numTurtles;

	public TurtleWindow(PenOptions penBox, TurtleImageBox imageBox, TurtleInformation turtleInfo) {
		numTurtles = 0;
		myPenBox = penBox;
		myTurtleImageBox = imageBox;
		myTurtleInformation = turtleInfo;
		allTurtles = new ArrayList<Turtle>();
		activeTurtles = new ArrayList<Turtle>();
		for (int i = 0; i<START_TURTLES; i++){
			makeTurtle();
		}
		click(allTurtles.get(0));
		myGridLines = new ArrayList<Line>();
		this.setMaxSize(ViewConstants.TURTLEWINDOW_WIDTH, ViewConstants.TURTLEWINDOW_HEIGHT);
		changeBackgroundColor(DEFAULT_BACKGROUND);
		makeGrid();
	}

    public Turtle makeTurtle(){
		Point2D location = new Point2D(Math.random()*ViewConstants.TURTLEWINDOW_WIDTH, Math.random()*ViewConstants.TURTLEWINDOW_HEIGHT);
		Turtle newTurtle = new Turtle(location, DEFAULT_ANGLE, numTurtles++);
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
			myTurtleImageBox.changeTurtle(t);
			myTurtleInformation.changeTurtle(t);
			t.requestFocus();
		}
		else {
			activeTurtles.remove(t);
			t.hideRing();
			myPenBox.changePen(new Pen());
			myTurtleImageBox.changeTurtle(new Turtle());
			myTurtleInformation.changeTurtle(null);
		}

	}
	
	public void update(List<Turtle> updates) {
		for (Turtle t: updates){
			this.getChildren().add(t.moveAndDrawPath());
			if (t.needsClear()){
				for (Polyline pl :t.getTrail()){
					this.getChildren().remove(pl);
				}
				t.clearTrail();
			}
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
	
	public List<Turtle> getAllTurtles() {
	    return allTurtles;
	}
	
	private void makeGrid(){
		for (int i=0;i<ViewConstants.TURTLEWINDOW_WIDTH;i+=GRID_INTERVAL){
			Line l = new Line(i, 0, i, ViewConstants.TURTLEWINDOW_HEIGHT);
			l.setStroke(Color.GREY);
			myGridLines.add(l);
		}
		for (int i=0;i<ViewConstants.TURTLEWINDOW_HEIGHT;i+=GRID_INTERVAL){
			Line l = new Line(0, i, ViewConstants.TURTLEWINDOW_WIDTH, i);
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
