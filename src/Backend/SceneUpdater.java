package Backend;

import java.util.List;

import com.sun.javafx.geom.Point2D;

/**
 * This class is an interface between the front-end and the back-end.
 * For each command that is parsed, the back-end creates a new SceneUpdater.
 * Each SceneUpdater instance tells the View how to update the display (is the pen up/down, was there an error message, where does the turtle move, etc.)
 * 
 * @author Greg
 *
 */

public class SceneUpdater {

	public SceneUpdater() {
		
	}
	
	public boolean penUp(){
		return false;
	}
	
	public String getErrorMessage(){
		return null;
	}

	public List<Point2D> getTurtleMoves(){
		return null;
	}

}
