package TurtleView;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;


/**
 * Stores the turtle and moves it around when commands are executed.
 * @author Greg Lyons
 *
 */
public class TurtleWindow extends Pane {
    
	public static final double ORIGIN_X = 0.0;
	public static final double ORIGIN_Y = 0.0;
	public static final Color DEFAULT_PEN = Color.BLACK;
	public static final String DEFAULT_BACKGROUND = "white";
	public static final String DEFAULT_IMAGE = "images/turtle1.png";
	public static final double WINDOW_WIDTH = 600.0;
	public static final double WINDOW_HEIGHT = 300.0;
	
	private Color myColor;
	private TurtleImage myTurtle;

    public TurtleWindow() {
    	myTurtle = new TurtleImage(ORIGIN_X, ORIGIN_Y);
    	changeTurtleImage(DEFAULT_IMAGE);
    	this.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.getChildren().add(myTurtle);
        changeBackgroundColor(DEFAULT_BACKGROUND);
        choosePenColor(DEFAULT_PEN);
        test();
    }
    
    public void test(){ 
        List<Point2D> list = new ArrayList<Point2D>();
        list.add(new Point2D(5.0, 5.0));
        list.add(new Point2D(300.0, 200.0));
        list.add(new Point2D(100.0, 250.0));
        drawLines(list); 
    }
    
    public void update(List<Point2D> myList, double angle, boolean penDown) {
    	moveTurtle(myList.get(myList.size()-1));
    	if (penDown) 
    		drawLines(myList);
    	rotateTurtle(angle);

    }
    
    public void changeBackgroundColor(String color){
    	this.setStyle("-fx-background-color: " + color + ";");
    }
    
    private void drawLines(List<Point2D> pointList) {
		double[] pointArray = pointListToArray(pointList);
		TurtlePath path = new TurtlePath(pointArray, myColor);
		this.getChildren().add(path);
    }
    
    private double[] pointListToArray(List<Point2D> myList) {
    	double[] array = new double[myList.size()*2];
		for (int i=0; i<myList.size(); i++){
			array[2*i] = myList.get(i).getX();
			array[2*i+1] = myList.get(i).getY();
		}
		return array;
	}

	private void choosePenColor(Color c) {
    	myColor = c;
    }
		
    public void changeTurtleImage(String s){
    	try{
    	Image newImage = new Image(getClass().getResourceAsStream(s));
		myTurtle.setImage(newImage);
    	}
    	catch(NullPointerException npe){	
    		
    	}

    }
    
	private void moveTurtle(Point2D point) {
		myTurtle.move(point.getX(), point.getY());
    }
	
	private void rotateTurtle(double angle) {
		myTurtle.setRotate(myTurtle.getRotate());
	}

}
