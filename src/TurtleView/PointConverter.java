package TurtleView;

import com.sun.javafx.geom.Point2D;
import FrontEnd.View;

/**
 * Converts the point to the xy coordinate system that the user sees
 * @author Rica
 *
 */
public class PointConverter {
    public double getX(double x) {
        return x + View.TURTLEWINDOW_WIDTH/2;
    }
    
    public double getY(double y) {
        return y - View.TURTLEWINDOW_HEIGHT/2;
    }
    
    public Point2D getPoint(Point2D p) {
        p.x = (float) getX(p.x);
        p.y = (float) getY(p.y);
        return p;
    }
}
