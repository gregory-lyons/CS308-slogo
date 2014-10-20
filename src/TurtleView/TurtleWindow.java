package TurtleView;

import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Pen.Pen;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
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

	public static final double ORIGIN_X = 0.0;
	public static final double ORIGIN_Y = 0.0;
	public static final Color DEFAULT_PEN = Color.BLACK;
	public static final String DEFAULT_BACKGROUND = "white";
	public static final String DEFAULT_IMAGE = "turtle1";
	public static final double WINDOW_WIDTH = 600.0;
	public static final double WINDOW_HEIGHT = 423.0;
	public static final double GRID_INTERVAL = 40.0;
	public static final double GRID_STROKE = 1.0;

	private Color myColor;
	private TurtleImage myTurtle;
	private List<Line> myGridLines;
	
	private Pen myPen;

	public TurtleWindow(Pen p) {
		myTurtle = new TurtleImage(ORIGIN_X, ORIGIN_Y);
		myGridLines = new ArrayList<Line>();
		myPen = p;
		changeTurtleImage(DEFAULT_IMAGE);
		this.setMaxSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.getChildren().add(myTurtle);
		changeBackgroundColor(DEFAULT_BACKGROUND);
		makeGrid();
	}

	public void update(List<Point2D> myList, double angle, boolean penDown) {
		moveTurtle(myList.get(myList.size()-1));
		//myPen.setPenDown(penDown);
		this.getChildren().add(myPen.drawLines(myList));
		rotateTurtle(angle);
		myTurtle.toFront();
	}

	public void changeBackgroundColor(String color){
		this.setStyle("-fx-background-color: " + color + ";");
	}

	public void changeTurtleImage(String s){
		String fileName = "images/" + s + ".png";
		try{
			Image newImage = new Image(getClass().getResourceAsStream(fileName));
			myTurtle.setImage(newImage);
		}
		catch(NullPointerException npe){	
		}

	}

	private void moveTurtle(Point2D point) {
		myTurtle.move(point.getX(), point.getY());
	}

	private void rotateTurtle(double angle) {
		myTurtle.setRotate(myTurtle.getRotate()+angle);
	}
	
	    public void startMovingTurtle (KeyEvent myKey) {
	        // TODO remove counter
	        int counter = 0;
	        while (counter < 5) {
	            System.out.println("Moving turtle...");
	            counter += 1;
	            if (myKey.getCode() == KeyCode.UP) {
	                myTurtle.move(myTurtle.getTurtleX() , myTurtle.getTurtleY()-5);
	            }
	            else if (myKey.getCode() == KeyCode.DOWN) {
	                myTurtle.move(myTurtle.getTurtleX() , myTurtle.getTurtleY()+5);
	            }
	            else if (myKey.getCode() == KeyCode.LEFT) {
	                myTurtle.move(myTurtle.getTurtleX()-5 , myTurtle.getTurtleY());
	            }
	            else if (myKey.getCode() == KeyCode.RIGHT) {
	                myTurtle.move(myTurtle.getTurtleX()+5 , myTurtle.getTurtleY());
	            }
	        }
	        System.out.println("Stopped moving turtle\n");

	    }   	    
	
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
