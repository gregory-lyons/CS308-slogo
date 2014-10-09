package Backend;

import java.util.ArrayList;
import java.util.List;
import TurtleView.UserVariable;
import javafx.geometry.Point2D;

/**
 * This class is an interface between the front-end and the back-end.
 * For each command that is parsed, the back-end creates a new SceneUpdater.
 * Each SceneUpdater instance tells the View how to update the display (is the pen up/down, was there an error message, where does the turtle move, etc.)
 * 
 * @author Greg, Rica
 *
 */
public class SceneUpdater {
    private List<Point2D> myLocation;
    private double myAngle;
    private List<String> myVariables;
    private boolean penDown;
    private boolean noError;
    private String errorMessage;
    
    public SceneUpdater(Turtle turtle) {
    	myLocation = turtle.myLocation;
    	myAngle = turtle.myAngle;
    	myVariables = turtle.myVariables;
    	penDown = turtle.penDown;
    	noError = turtle.noError;
    	errorMessage = turtle.errorMessage;
    }
    
    public List<Point2D> getLocation(){
        return myLocation;
    }
    
    public double getAngle(){
    	return myAngle;
    }
    
    public List<String> getVariables() {
        return myVariables;
    }
    
    /**
     * Creates a UserVariable object for each variable that the user created in their command.
     * @return List of UserVariables created
     */
    public List<UserVariable> constructAllVariables() {
        List<UserVariable> myUserVariables = new ArrayList<>();
        for (String var : myVariables) {
            UserVariable userVariable = new UserVariable(var);
            myUserVariables.add(userVariable);
        }
        return myUserVariables;
    }
	
    public boolean penIsDown(){
        return penDown;
    }
    
    public boolean isNoError() {
        return noError;
    }
	
    public String getErrorMessage(){
	return errorMessage;
    }
}
