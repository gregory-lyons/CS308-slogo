package FrontEnd;

import java.util.List;
import javafx.scene.control.Button;
import CommandButtons.SuperCommand;

/**
 * Creates and stores all the buttons for the view to display.
 * @author Rica
 *
 */
public class CommandControl {
    private List<SuperCommand> myCommandList;

    /**
     * Constructor uses CommandFactory to create new commands with their buttons.
     * Based on a list of Strings that describe the commands available, the CommandFactory class will be used
     * to initialize a list of Commands.  This list can be accessed by getCommands()
     */
    public CommandControl() {
        //create the list of commands
        
    }
    
    public Button createButton(SuperCommand buttonType) {
        return null;
    }
    
    /**
     * This allows the View to access of all the Command buttons so they can be added to the display.
     * @return List<Button>
     */
    public List<SuperCommand> getCommands() {
        return myCommandList;
    }

}
