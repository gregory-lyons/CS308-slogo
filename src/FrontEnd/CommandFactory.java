package FrontEnd;
import FrontEndCommands.AmountCommand;
import FrontEndCommands.SuperCommand;
import FrontEndCommands.CoordinateCommand;

/**
 * The CommandFactory can create a command of the desired type using the makeCommand method.
 * 
 * @author Rica
 *
 */

public class CommandFactory {
    
    public CommandFactory(CommandLine c) {
    }
    
    /**
     * Takes a String describing the desired type of command and returns a new instance of that command
     * Each command will be a subclass of SuperCommand and will have its own correct String
     * 
     * @param s
     * @return SuperCommand
     */
    public SuperCommand makeCommand(String language, String label){
        if (label.equals(DefaultStrings.FORWARD) || label.equals(DefaultStrings.LEFT) || label.equals(DefaultStrings.RIGHT)) {
            return new AmountCommand(label, language);
        }
        else if (label.equals(DefaultStrings.SETPOSITION) || label.equals(DefaultStrings.SETTOWARDS)) {
            return new CoordinateCommand(label);
        }
        else {
            return new SuperCommand(label);
        }
    }
    
}
