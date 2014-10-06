package TurtleView;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

/**
 * This is the turtle and all of its methods.
 * @author Rica
 *
 */
public class TurtleImage extends ImageView {
    
    public TurtleImage(double x, double y) {
        super();
        this.setX(20);
        this.setY(20);
        this.setFitHeight(50.0);
        this.setFitWidth(50.0);
    }

}
