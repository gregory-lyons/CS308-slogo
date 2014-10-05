package FrontEnd;

import java.util.List;
import javafx.scene.control.Button;

/**
 * Creates and stores all the buttons for the view to display.
 * @author Rica
 *
 */
public class CommandControl {

    /**
     * Constructor uses CommandFactory to create new commands with their buttons.
     * Based on a list of Strings that describe the commands available, the CommandFactory class will be used
     * to initialize a list of Commands.  This list can be accessed by getCommands()
     */
    public CommandControl() {
        
    }
    
    /**
     * This allows the View to access of all the Command buttons so they can be added to the display.
     * @return List<Button>
     */
    public List<SuperCommand> getCommands() {
        return null;
    }

}
