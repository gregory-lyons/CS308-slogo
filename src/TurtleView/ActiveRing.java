package TurtleView;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ActiveRing extends Circle {
	
	public static final double DEFAULT_THICK = 3.0;
	public static final double OFFSET = 5;

	public ActiveRing(double x, double y, double width, double height) {
		double radius = Math.max(width, height)/2 + OFFSET;
		this.setRadius(radius);
		this.setStroke(Color.ORANGE);
		this.setFill(Color.WHITE);
		this.setStrokeWidth(DEFAULT_THICK);
		this.setCenterX(x);
		this.setCenterY(y);
	}
	
	public void update(Point2D newPoint) {
		this.setCenterX(newPoint.getX());
		this.setCenterY(newPoint.getY());
	}

}
