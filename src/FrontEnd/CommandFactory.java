package FrontEnd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import FrontEndCommands.SuperCommand;

/**
 * 
 * The CommandFactory can create a command of the desired type using the makeCommand method.
 * 
 * @author Rica
 *
 */

public class CommandFactory {
    private CommandLine myCommandLine;
    private HistoryBox myHistoryBox;
    private List<String> myCommandButtons = new ArrayList<String>(Arrays.asList("Forward", "Left", 
                                                                                "Right", "Home", 
                                                                                "ClearScreen", "SetPosition", 
                                                                                "SetTowards"));
    
    public CommandFactory(CommandLine c, HistoryBox h) {
        myCommandLine = c;
        myHistoryBox = h;
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
        return new SuperCommand(myCommandLine, myHistoryBox, label, language);
    }
    
    public List<String> getCommandButtons() { 
        return myCommandButtons;
    }

}
