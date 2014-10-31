package Backend;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import FrontEnd.Boundary;
import FrontEnd.View;
import Pen.Pen;
import Pen.PenOptions;
import TurtleView.ActiveRing;
import TurtleView.TurtleImageBox;
import TurtleView.TurtleInformation;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 
 * 
 *  * @author Ashwin, Justin, Greg, Rica
 * 
 * This Turtle class is used by both the front end and the back end.  It extends ImageView so that it can
 * be added directly to the Scene as a visual representation, but it also holds much data and has many methods for updating its state.

 *
 */

public class Turtle extends ImageView {

	public static final double DEFAULT_WIDTH = 25.0;
	public static final double DEFAULT_HEIGHT = 25.0;
	public static final String DEFAULT_IMAGE = "turtle1";
	public static final String IMAGE_ERROR = "This turtle image does not exist: ";


	private Point2D myLocation;
	private List<Point2D> nextLocations;
	private double myAngle;
	private Pen myPen;
	private PenOptions myPenOptions;
	private TurtleImageBox myImageBox;
	private TurtleInformation myTurtleInformation;
	private ActiveRing myRing;
	private int myID;
	private boolean needsClear;
	private List<Polyline> myTrail;
	

	public Turtle(Point2D location, double angle, int id) {
		super();
		myID = id;
		myPen = new Pen();
		myImageBox = new TurtleImageBox(this);
		myPenOptions = new PenOptions(myPen);
		nextLocations = new ArrayList<Point2D>();
		myAngle = angle;
		myTrail = new ArrayList<Polyline>();
		needsClear = false;
		changeToDefaultImage(DEFAULT_IMAGE);
		this.setRotate(angle);
		this.setFitHeight(DEFAULT_WIDTH);
		this.setFitWidth(DEFAULT_HEIGHT);
		myLocation = location;
		myRing = new ActiveRing(myLocation.getX(), myLocation.getY(), DEFAULT_WIDTH, DEFAULT_HEIGHT);
		myTurtleInformation = new TurtleInformation(this);
		this.move(location);
		this.hideRing();
	}

    //Empty Turtle for when no Turtle is selected as active
	public Turtle() {		
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
		Boundary window = new Boundary(View.TURTLEWINDOW_WIDTH, View.TURTLEWINDOW_HEIGHT);
		Point2D newPoint = window.checkBoundary(location);
		nextLocations.add(myLocation);
		nextLocations.add(newPoint);
		move(newPoint);
	}

	public Point2D nextLocation(double distance, double angle){
		double x = myLocation.getX();
		double y = myLocation.getY();
		double rotation = myAngle + angle;
		x += distance*Math.sin(Math.toRadians(rotation));
		y -= distance*Math.cos(Math.toRadians(rotation));
		return new Point2D(x,y);
	}

	public List<Point2D> getNextLocations() {
		return nextLocations;
	}

	public void move(Point2D point){
		this.setX(point.getX()-this.getFitWidth()/2);
		this.setY(point.getY()-this.getFitHeight()/2);
		myLocation = point;
		myTurtleInformation.update();
		myRing.update(point);
	}
	
	public void moveTurtle(Point2D point) {
		
	}
	
	public Pen getPen(){
		return myPen;
	}

	public PenOptions getPenOptions(){
		return myPenOptions;
	}
	
	public TurtleImageBox getImageBox(){
		return myImageBox;
	}

	public void changeToDefaultImage(String imageName){
		String fileName = "Images/" + imageName + ".png";
		try{
			Image newImage = new Image(getClass().getResourceAsStream(fileName));
			this.setImage(newImage);
		}
		catch(NullPointerException npe){
		    System.out.println(IMAGE_ERROR + imageName);
		}

	}
	
	public void changeToLoadedImage(String imageLocation){
            try{
                File file = new File(imageLocation);
                Image newImage = new Image(file.toURI().toString());
                this.setImage(newImage);
                this.toFront();
                this.setFitHeight(DEFAULT_WIDTH);
                this.setFitWidth(DEFAULT_HEIGHT);
                
                Stage dialog = new Stage();
                dialog.initStyle(StageStyle.UTILITY);
                Scene myScene = new Scene(new Group(this));
                dialog.setScene(myScene);
                dialog.show();
            }
            catch(NullPointerException npe){
                System.out.println(IMAGE_ERROR + imageLocation);
            }
        }
	
	public void hide(){
		this.setOpacity(0);
	}

	public void show(){
		this.setOpacity(1);
	}

	public Polyline moveAndDrawPath() {
		Polyline newPath = myPen.drawLines(nextLocations);
		nextLocations.clear();
		myTrail.add(newPath);
		return newPath;
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
    
    public int getID(){
    	return myID;
    }
    
    public void setClear(){
    	needsClear = true;
    }
    
    public void clearTrail(){
    	myTrail.clear();
    	needsClear = false;
    }

	public List<Polyline> getTrail() {
		return myTrail;
	}

	public boolean needsClear() {
		return needsClear;
	}

}
