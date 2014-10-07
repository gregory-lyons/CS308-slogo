package FrontEnd;

import java.util.Observable;
import java.util.Observer;

import Backend.Model;
import Backend.SceneUpdater;
import TurtleCommands.EnterCommand;

/**
 * Passes information from the view to the model and back
 * @author Rica, Greg
 *
 */
public class Controller implements Observer {
    Model myModel;
    View myView;
	
    /**
     * Constructs the controller with the model and view
     * @param v
     * @param m
     */
    public Controller(View v, Model m) {
    	myModel = m;
    	myView = v;
    }

    /**
     * Will notify back-end of any changes
     */
    @Override
    public void update (Observable o, Object instruction) {

    }

}
