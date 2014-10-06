package TurtleView;

import java.util.List;

import com.sun.javafx.geom.Point2D;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

/**
 * Stores the turtle and moves it around when commands are executed.
 * @author Rica, Greg
 *
 */
public class TurtleWindow extends Pane {
    
	public static final double ORIGIN_X = 0.0;
	public static final double ORIGIN_Y = 0.0;
	
	private TurtleImage myTurtle;
	
    public TurtleWindow() {
    	myTurtle = new TurtleImage(ORIGIN_X, ORIGIN_Y);
    	//Image image = new Image(getClass().getResourceAsStream("images/turtle1.png"));
        //myTurtle.setImage(image);
    	changeTurtleImage("images/turtle1.png");
        this.getChildren().add(myTurtle);
    }
    
    public void update(List<Point2D> myList, double angle) {
    	moveTurtle(myList.get(myList.size()-1));
    	drawLines(myList);
    	rotateTurtle(angle);
    }
    
    private void drawLines(List<Point2D> myList) {
		
		
	}

    public void changeTurtleImage(String s){
    	try{
    	Image newImage = new Image(getClass().getResourceAsStream(s));
		myTurtle.setImage(newImage);
    	}
    	catch(NullPointerException npe){
    		
    	}

    }
    
	private void moveTurtle(Point2D point) {
		myTurtle.setX(point.x);
		myTurtle.setY(point.y);
    }
	
	private void rotateTurtle(double angle) {
		myTurtle.setRotate(myTurtle.getRotate());
	}
    

}
