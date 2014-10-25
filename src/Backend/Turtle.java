package Backend;

import java.util.ArrayList;
import java.util.List;

import Pen.Pen;
import Pen.PenOptions;
import TurtleView.ActiveRing;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polyline;

public class Turtle extends ImageView{

	public static final double DEFAULT_WIDTH = 25.0;
	public static final double DEFAULT_HEIGHT = 25.0;
	public static final String DEFAULT_IMAGE = "turtle1";

	private Point2D myLocation;
	private List<Point2D> nextLocations;
	private double myAngle;
	private Pen myPen;
	private PenOptions myPenOptions;
	private ActiveRing myRing;
	

	public Turtle(Point2D location, double angle) {
		super();
		myPen = new Pen();

		myPenOptions = new PenOptions(myPen);
		changeImage(DEFAULT_IMAGE);
		this.setRotate(angle);
		this.setFitHeight(DEFAULT_WIDTH);
		this.setFitWidth(DEFAULT_HEIGHT);
		this.move(location);
		myRing = new ActiveRing(myLocation.getX(), myLocation.getY(), DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.hideRing();
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
	
	public void setAngle(double angle){
		myAngle = angle;
	}
	
	public double getAngle(){
		return myAngle;
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
		myLocation = point;
	}
	
	public Pen getPen(){
		return myPen;
	}

	public PenOptions getPenOptions(){
		return myPenOptions;
	}

	public void changeImage(String s){
		String fileName = "Images/" + s + ".png";
		try{
			Image newImage = new Image(getClass().getResourceAsStream(fileName));
			this.setImage(newImage);
		}
		catch(NullPointerException npe){	
		}

	}
	
	public void hide(){
		this.setOpacity(0);
	}

	public void show(){
		this.setOpacity(1);
	}

	public Polyline moveAndDrawPath() {
		List<Point2D> points = new ArrayList<Point2D>();
		points.add(myLocation);
		points.addAll(nextLocations);
		move(points.get(points.size()-1));
		return myPen.drawLines(points);
	}
    
    public double getXCord(){
    	return getLocation().getX();
    }
    
    public double getYCord(){
    	return getLocation().getY();
    }
    
    public void showRing(){
    	myRing.setOpacity(1);
    }
    
    public void hideRing(){
    	myRing.setOpacity(0);
    }
    
    public ActiveRing getRing(){
    	return myRing;
    }

}
