package TurtleView;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

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
    

    public double getTurtleX(){
        return (super.getX()+this.getFitWidth()/2);
    }
    
    public double getTurtleY(){
        return (super.getY()+this.getFitHeight()/2);
    }
    
    
    public void move(double x, double y) {
    	this.setX(x-this.getFitWidth()/2);
    	this.setY(y-this.getFitHeight()/2);
    }

}
