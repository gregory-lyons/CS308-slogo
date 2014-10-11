package Backend;

import java.util.List;

import javafx.geometry.Point2D;

public class Turtle {
	
	protected List<Point2D> myLocation;
	protected double myAngle;
	protected List<String> myVariables;
	protected boolean penDown;
	protected boolean noError;
	protected String errorMessage;
	
	public Turtle(List<Point2D> location, double angle, List<String> variables, boolean penDown, boolean noError, String errorMessage) {
		myLocation = location;
		myAngle = angle;
		myVariables = variables;
		this.penDown = penDown;
		this.noError = noError;
		this.errorMessage = errorMessage;
		
	}
	
	
	
	public void setPenDown() {
		this.penDown = true;
	}
	
	public void setPenUp() {
		this.penDown = false;
	}
	
	public void setAngle(double angle) {
		this.myAngle = angle;
	}
	
	public double getAngle() {
		return myAngle;
	}
	
	public List<Point2D> getLocation() {
		return myLocation;
	}

	public void setLocation(Point2D location){
		myLocation.add(location);
	}
}
