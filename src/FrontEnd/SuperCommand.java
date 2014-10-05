package FrontEnd;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Button;

/**
 * This is a superclass. The subclasses (each representing a command) will each have their own appropriate String.
 * All subclasses are observable by the CommandLine and notify the CommandLine when they are pressed.
 * @author Rica, Greg
 *
 */
public class SuperCommand extends Button implements Observable {
    
    /**
     * This initializes the string representing the command that will be added to the command line when clicked.
     * It also configures the Button properties and sets up the handler.
     */
    public SuperCommand() {
        
    }

    //The CommandLine will be the listener for all subclasses
    @Override
    public void addListener (InvalidationListener arg0) {
        
    }

    @Override
    public void removeListener (InvalidationListener arg0) {

    }
    
}
