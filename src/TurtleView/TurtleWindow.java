package TurtleView;

import java.util.List;

import com.sun.javafx.geom.Point2D;

import javafx.scene.layout.Pane;

/**
 * Stores the turtle and moves it around when commands are executed.
 * @author Rica, Greg
 *
 */
public class TurtleWindow extends Pane {
    
	private TurtleImage myTurtle;
	
    public TurtleWindow() {
        
    }
    
    public void update(List<Point2D> myList, double angle) {
    	moveTurtle(myList.get(myList.size()-1));
    	drawLines(myList);
    	rotateTurtle(angle);
    }
    
    private void drawLines(List<Point2D> myList) {
		
		
	}

	private void moveTurtle(Point2D point) {
		myTurtle.setX(point.x);
		myTurtle.setY(point.y);
    }
	
	private void rotateTurtle(double angle) {
		myTurtle.setRotate(myTurtle.getRotate());
	}
    

}
