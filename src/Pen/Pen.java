package Pen;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

public class Pen {

	private boolean penDown;
	private List<Double> myLineType;
	private Color myColor;
	private double myThickness;
	
	public static final double DEFAULT_THICKNESS = 1.0;
	public static final Color DEFAULT_COLOR = Color.BLACK;
	public static final List<Double> SOLID = new ArrayList<Double>();
	public static final List<Double> DASHED = new ArrayList(Arrays.asList(10.0,10.0));
	public static final List<Double> DOTTED = new ArrayList(Arrays.asList(2.0, 35.0));
		
	public Pen() {
		penDown = true;
		myLineType = SOLID;
		myColor = DEFAULT_COLOR;
		myThickness = DEFAULT_THICKNESS;
	}
	
	public Polyline drawLines(List<Point2D> pointList){
		List<Polyline> lineList = new ArrayList<Polyline>();
		if (!penDown) {
			return new Polyline();   //empty
		}
		double[] pointArray = pointListToArray(pointList);
		Polyline path = new Polyline(pointArray);
		path.setStroke(myColor);
		path.setStrokeWidth(myThickness);
		path.getStrokeDashArray().addAll(myLineType);
		return path;
		
	}

	private double[] pointListToArray(List<Point2D> myList) {
		double[] array = new double[myList.size()*2];
		for (int i=0; i<myList.size(); i++){
			array[2*i] = myList.get(i).getX();
			array[2*i+1] = myList.get(i).getY();
		}
		return array;
	}
	
	public void setPenDown() {
		penDown = true;
	}
	
	public void setPenUp() {
		penDown = false;
	}
	
	public void changeColor(Color c){
		if (c != null)
			myColor = c;
	}
	
	public void changeThick(double thick){
		myThickness = thick;
	}
	
	public void changeType(List<Double> type) {
		myLineType = type;
	}
	
	public boolean isDown(){
		return penDown;
	}
}
