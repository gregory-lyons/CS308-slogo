package TurtleView;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

/**
 * 
 * @author Greg Lyons
 *
 */

public class TurtlePath extends Polyline {
	
	public static final Color DEFAULT_PEN = Color.BLACK;
	
	public TurtlePath(){
		super();
	}
	
	public TurtlePath(double[] pointArray, Color c){
		super(pointArray);
		this.setStroke(c);
		this.toBack();
	}
}
