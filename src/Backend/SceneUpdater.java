package Backend;

import java.util.ArrayList;
import java.util.List;

import FrontEnd.DefaultStrings;
import TurtleView.UserVariable;

/**
 * This class is an interface between the front-end and the back-end.
 * For each command that is parsed, the back-end creates a new SceneUpdater.
 * Each SceneUpdater instance tells the View how to update the display (is the pen up/down, was there an error message, where does the turtle move, etc.)
 * 
 * @author Greg, Rica, Ashwin, Justin
 *
 */
public class SceneUpdater {
    private List<String> myVariables;
    private boolean noError;
    private String errorMessage;
    private List<Turtle> turtles;
    private List<Double> returnValues;
    
    
    public SceneUpdater(List<Turtle> activeTurtles, List<Double> printValues, boolean nE) {
    	turtles = activeTurtles;
    	returnValues = printValues;
    	noError = nE;
    	errorMessage = DefaultStrings.ERROR_DEFAULT;
    }    
    
    public List<Turtle> getTurtles(){
    	return turtles;
    }
    
    public List<Double> getReturnValues(){
    	return returnValues;
    }
    
    public boolean isNoError() {
        return noError;
    }
	
    public String getErrorMessage(){
	return errorMessage;
    }
}
