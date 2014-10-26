package FrontEnd;

import javafx.geometry.Point2D;

public class Boundary {
	
	private double myHeight;
	private double myWidth;

	
	public Boundary (double w, double h) {
		myWidth = w;
		myHeight = h;

	}

	public Point2D checkBoundary(Point2D checkPoint) {
		double x = checkPoint.getX();
		double y = checkPoint.getY();
		if (x<0) x = 0;
		if (y<0) y = 0;
		if (x>myWidth) x = myWidth;
		if (y>myHeight) y = myHeight;
		return new Point2D(x,y);
		
	}
}
