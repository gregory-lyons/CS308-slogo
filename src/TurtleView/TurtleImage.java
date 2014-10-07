package TurtleView;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

/**
 * 
 * @author Greg Lyons
 *
 */
public class TurtleImage extends ImageView {
    
    public TurtleImage(double x, double y) {
        super();
        this.move(200, 100);
        this.setFitHeight(25.0);
        this.setFitWidth(25.0);
    }
    
    public void move(double x, double y) {
    	this.setX(x-this.getFitWidth()/2);
    	this.setY(y-this.getFitHeight()/2);
    }

}
