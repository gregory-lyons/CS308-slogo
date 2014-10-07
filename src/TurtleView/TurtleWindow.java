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
 * @author Rica, Greg
 *
 */
public class TurtleWindow extends Pane {
    
	public static final double ORIGIN_X = 0.0;
	public static final double ORIGIN_Y = 0.0;
	public static final Color DEFAULT_PEN = Color.BLACK;
	public static final String DEFAULT_BACKGROUND = "white";
	
	private Color myColor;
	
	private TurtleImage myTurtle;
	
    public TurtleWindow() {
    	myTurtle = new TurtleImage(ORIGIN_X, ORIGIN_Y);
    	changeTurtleImage("images/turtle1.png");
    	this.setPrefSize(600.0, 300.0);
        this.getChildren().add(myTurtle);
        changeBackgroundColor(DEFAULT_BACKGROUND);
        choosePenColor(DEFAULT_PEN);
        List<Point2D> list = new ArrayList<Point2D>();
        list.add(new Point2D(5.0, 5.0));
        list.add(new Point2D(300.0, 200.0));
        list.add(new Point2D(100.0, 250.0));
        drawLines(list);       
    }
    
    public void update(List<Point2D> myList, double angle) {
    	moveTurtle(myList.get(myList.size()-1));
    	drawLines(myList);
    	rotateTurtle(angle);
    }
    
    public void changeBackgroundColor(String color){
    	this.setStyle("-fx-background-color: " + color + ";");
    }
    
    private void drawLines(List<Point2D> myList) {
		double[] pointArray = new double[myList.size()*2];
		for (int i=0; i<myList.size(); i++){
			pointArray[2*i] = myList.get(i).getX();
			pointArray[2*i+1] = myList.get(i).getY();
		}
		
		Polyline path = new Polyline(pointArray);
		path.setStroke(Color.RED);
		this.getChildren().add(path);
		path.toBack();
		moveTurtle(myList.get(myList.size()-1));
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
		//this.getChildren().remove(myTurtle);
		myTurtle.move(point.getX(), point.getY());
    }
	
	private void rotateTurtle(double angle) {
		myTurtle.setRotate(myTurtle.getRotate());
	}

}
