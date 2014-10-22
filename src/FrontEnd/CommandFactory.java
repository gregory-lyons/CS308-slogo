package FrontEnd;
import java.util.List;

import FrontEndCommands.BackCommand;
import FrontEndCommands.ClearCommand;
import FrontEndCommands.EnterCommand;
import FrontEndCommands.ForwardCommand;
import FrontEndCommands.GoToCommand;
import FrontEndCommands.HomeCommand;
import FrontEndCommands.LeftCommand;
import FrontEndCommands.RightCommand;
import FrontEndCommands.SuperCommand;
import FrontEndCommands.TowardsCommand;

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
        /*
        if (label.equals("Back")) {
            return new BackCommand(myCommandLine, myHistoryBox, label, language); 
        } 
        if (label.equals("ClearScreen")) {
            return new ClearCommand(myCommandLine, myHistoryBox, label, language); 
        }
        if (label.equals("Enter")) {
            return new EnterCommand(myCommandLine, myHistoryBox, label, language);
        }
        if (label.equals("Forward")) {
            return new ForwardCommand(myCommandLine, myHistoryBox, label, language); 
        }
        if (label.equals("SetPosition")) {
            return new GoToCommand(myCommandLine, myHistoryBox, label, language); 
        }
        if (label.equals("Home")) {
            return new HomeCommand(myCommandLine, myHistoryBox, label, language); 
        }
        if (label.equals("Left")) {
            return new LeftCommand(myCommandLine, myHistoryBox, label, language); 
        }
        if (label.equals("Right")) {
            return new RightCommand(myCommandLine, myHistoryBox, label, language);
        }
        if (label.equals("SetTowards")) {
            return new TowardsCommand(myCommandLine, myHistoryBox, label); 
        }
        return null;
        */
    }

}
