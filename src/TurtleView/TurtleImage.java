package TurtleView;

import java.util.ArrayList;
import java.util.List;

import Pen.Pen;
import Pen.PenOptions;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polyline;

/**
 * 
 * @author Greg Lyons
 *
 */
public class TurtleImage extends ImageView {
	
	public static final double DEFAULT_WIDTH = 25.0;
	public static final double DEFAULT_HEIGHT = 25.0;
	public static final double DEFAULT_X = 200.0;
	public static final double DEFAULT_Y = 100.0;
	
	private Pen myPen;
	private PenOptions myPenOptions;
	private List<Point2D> myPoints;
    
    public TurtleImage(double x, double y, double angle) {
        super();
        this.move(DEFAULT_X, DEFAULT_Y);
        this.setFitHeight(DEFAULT_WIDTH);
        this.setFitWidth(DEFAULT_HEIGHT);
        myPen = new Pen();
        myPenOptions = new PenOptions(myPen);
        myPoints = new ArrayList<Point2D>();
    }
    

    public double getTurtleX(){
        return (super.getX()+this.getFitWidth()/2);
    }
    
    public double getTurtleY(){
        return (super.getY()+this.getFitHeight()/2);
    }
    
    public Polyline moveAndDrawPath(List<Point2D> pointList){
    	myPoints = pointList;
    	move(myPoints.get(myPoints.size()-1));
    	return myPen.drawLines(myPoints);
    }
    
    public void move(double x, double y) {
    	this.setX(x-this.getFitWidth()/2);
    	this.setY(y-this.getFitHeight()/2);
    }
    
    public void move(Point2D point){
    	this.setX(point.getX()-this.getFitWidth()/2);
    	this.setY(point.getY()-this.getFitHeight()/2);
    }
    
    public VBox getPenOptions(){
    	return myPenOptions;
    }

	public void changeImage(String s){
		String fileName = "images/" + s + ".png";
		try{
			Image newImage = new Image(getClass().getResourceAsStream(fileName));
			this.setImage(newImage);
		}
		catch(NullPointerException npe){	
		}

	}
    

}
