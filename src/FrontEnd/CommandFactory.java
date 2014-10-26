package FrontEnd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import FrontEndCommands.EnterCommand;
import FrontEndCommands.AmountCommand;
import FrontEndCommands.SetXYCommand;
import FrontEndCommands.SuperCommand;
import FrontEndCommands.TowardCommand;

/**
 * 
 * The CommandFactory can create a command of the desired type using the makeCommand method.
 * 
 * @author Rica
 *
 */

public class CommandFactory {
    private CommandLine myCommandLine;
    private List<String> myCommandButtons = new ArrayList<String>(Arrays.asList(DefaultStrings.FORWARD, 
                                                                                DefaultStrings.LEFT,
                                                                                DefaultStrings.RIGHT, 
                                                                                DefaultStrings.SETPOSITION, 
                                                                                DefaultStrings.SETTOWARDS, 
                                                                                DefaultStrings.HOME, 
                                                                                DefaultStrings.CLEARSCREEN));
    
    public CommandFactory(CommandLine c) {
        myCommandLine = c;
    }
    
    /**
     * 
     * Takes a String describing the desired type of command and returns a new instance of that command
     * Each command will be a subclass of SuperCommand and will have its own correct String
     * 
     * @param s
     * @return SuperCommand
     */
    public SuperCommand makeCommand(String language, String label){
        if (label.equals(DefaultStrings.ENTER)) {
            return new EnterCommand(myCommandLine, label, language);
        }
        else if (label.equals(DefaultStrings.FORWARD) || label.equals(DefaultStrings.LEFT) || label.equals(DefaultStrings.RIGHT)) {
            return new AmountCommand(myCommandLine, label, language);
        }
        else if (label.equals(DefaultStrings.SETPOSITION)) {
            return new SetXYCommand(myCommandLine, label, language);
        }
        else if (label.equals(DefaultStrings.SETTOWARDS)) {
            return new TowardCommand(myCommandLine, label, language);
        }
        else {
            return new SuperCommand(myCommandLine, label, language);
        }
    }
    
    public List<String> getCommandButtons() { 
        return myCommandButtons;
    }

}
