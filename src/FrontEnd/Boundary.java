package FrontEnd;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;

public class Boundary {
	
	private double myHeight;
	private double myWidth;
	private boolean xBig;
	private boolean xSmall;
	private boolean yBig;
	private boolean ySmall;
	private double newX;
	private double newY;
	
	public Boundary (double w, double h) {
		myWidth = w;
		myHeight = h;
		xBig = false;
		xSmall = false;
		yBig = false;
		ySmall = false;
	}

	public List<Point2D> checkWrap(Point2D newPoint, Point2D currentPoint){
		double dx = newPoint.getX() - currentPoint.getX();
		double dy = currentPoint.getY() - newPoint.getY();
		double theta = Math.toDegrees(Math.atan2(dy, dx));
		newX = newPoint.getX();
		newY = newPoint.getY();
		List<Point2D> points = new ArrayList<Point2D>();
		xBig = newPoint.getX()>myWidth;
		yBig = newPoint.getY()>myWidth;
		xSmall = newPoint.getX()<0;
		ySmall = newPoint.getY()<0;
		newX = newPoint.getX() % myWidth;
		newY = newPoint.getY() % myHeight;
		
		if (xBig){
			double px = myWidth;
			double py = myHeight/2 - myWidth*Math.tan(Math.toRadians(theta));
			Point2D p = new Point2D(px, py);
			
			double qx = 0;
			double qy = myHeight/2 + myWidth*Math.tan(Math.toRadians(theta));
			Point2D q = new Point2D(qx, qy);
			
			newX = newPoint.getX() % myWidth;
			newY = newPoint.getY() % myHeight;
			if (newX < 0) newX+= myWidth;
			if (newY < 0) newY+= myHeight;
			Point2D location = new Point2D(newX, newY);
			points.add(p);
			points.add(q);
			points.add(location);
		}
		if (xSmall){
			
		}
		
			return points;

	}

}
