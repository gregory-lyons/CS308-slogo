package Backend;

import java.util.List;

import Pen.Pen;
import Pen.PenOptions;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Turtle extends ImageView{
	
	public static final double DEFAULT_WIDTH = 25.0;
	public static final double DEFAULT_HEIGHT = 25.0;
	
	protected Point2D myLocation;
	protected List<Point2D> nextLocations;
	protected double myAngle;
	protected Pen myPen;
	protected PenOptions myPenOptions;
	
	public Turtle(Point2D location, double angle) {
		super();
		myPen = new Pen();
		myPenOptions = new PenOptions(myPen);

        this.move(location);
		this.setRotate(angle);
        this.setFitHeight(DEFAULT_WIDTH);
        this.setFitWidth(DEFAULT_HEIGHT);
	}
	
	public void setPenDown() {
		myPen.setPenDown();
	}
	
	public void setPenUp() {
		myPen.setPenUp();
	}
	
	public boolean penStatus(){
		return myPen.isDown();
	}
	
	public Point2D getLocation() {
		return myLocation;
	}
	
	public void addLocation(Point2D location){
		nextLocations.add(location);
	}
	
	public Point2D nextLocation(double distance, double angle){
		double x = myLocation.getX();
		double y = myLocation.getY();
		double rotation = myAngle = angle;
		x += distance*Math.sin(rotation);
		y += distance*Math.cos(rotation);
		return new Point2D(x,y);
	}
	
	public List<Point2D> getNextLocations() {
		return nextLocations;
	}
    
    public void move(Point2D point){
    	this.setX(point.getX()-this.getFitWidth()/2);
    	this.setY(point.getY()-this.getFitHeight()/2);
    	myLocation = new Point2D(this.getX(), this.getY());
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
    
    public double getXCord(){
    	return getLocation().getX();
    }
    
    public double getYCord(){
    	return getLocation().getY();
    }
}
