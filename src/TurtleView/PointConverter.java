package TurtleView;

import javafx.geometry.Point2D;
import FrontEnd.View;
import FrontEnd.ViewConstants;

/**
 * Converts the point to the xy coordinate system that the user sees
 * @author Rica
 *
 */
public class PointConverter {
    public static double convertUserToActualX(double x) {
        return x + ViewConstants.TURTLEWINDOW_WIDTH/2;
    }
    
    public static double convertUserToActualY(double y) {
        return ViewConstants.TURTLEWINDOW_HEIGHT/2 - y;   
   }
    
    public static Point2D convertUserToActualPoint(Point2D p) {
        Point2D newPoint = new Point2D(convertUserToActualX(p.getX()), convertUserToActualY(p.getY()));
        return newPoint;
    }
    
    public static double convertActualToUserX(double x) {
        return x - ViewConstants.TURTLEWINDOW_WIDTH/2;
    }
    
    public static double convertActualToUserY(double y) {
        return ViewConstants.TURTLEWINDOW_HEIGHT/2 - y;   
   }
    
    public static Point2D convertActualToUserPoint(Point2D p) {
        Point2D newPoint = new Point2D(convertUserToActualX(p.getX()), convertUserToActualY(p.getY()));
        return newPoint;
    }
}
