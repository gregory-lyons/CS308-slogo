package Pen;

import java.util.List;

import TurtleView.TurtlePath;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

public class Pen {

	private boolean penDown;
	private int myLineType;
	private Color myColor;
	private double myThickness;
	
	public static final int SOLID = 0;
	public static final int DASHED = 1;
	public static final int DOTTED = 2;
	
	public Pen() {
		penDown = true;
		myLineType = 0;
		myColor = Color.BLACK;
		myThickness = 1.0;
	}
	
	public Polyline drawLines(List<Point2D> pointList){
		if (!penDown) {
			return new Polyline();   //empty
		}
		double[] pointArray = pointListToArray(pointList);
		Polyline path = new Polyline(pointArray);
		path.setStroke(myColor);
		path.setStrokeWidth(myThickness);
		return path;
		
	}
	
	public void update(boolean isDown){
		setPenDown(isDown);
	}

	private double[] pointListToArray(List<Point2D> myList) {
		double[] array = new double[myList.size()*2];
		for (int i=0; i<myList.size(); i++){
			array[2*i] = myList.get(i).getX();
			array[2*i+1] = myList.get(i).getY();
		}
		return array;
	}
	
	public void setPenDown(boolean down) {
		penDown = down;
	}
	
	public void changeColor(Color c){
		if (c != null)
			myColor = c;
	}
	
	public void changeThick(double thick){
		myThickness = thick;
	}
	
	public boolean isDown(){
		return penDown;
	}
}
