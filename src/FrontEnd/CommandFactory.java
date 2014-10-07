package FrontEnd;
import java.util.List;
import TurtleCommands.BackCommand;
import TurtleCommands.ClearCommand;
import TurtleCommands.EnterCommand;
import TurtleCommands.ForwardCommand;
import TurtleCommands.GoToCommand;
import TurtleCommands.HomeCommand;
import TurtleCommands.LeftCommand;
import TurtleCommands.RightCommand;
import TurtleCommands.SuperCommand;
import TurtleCommands.TowardsCommand;

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
    public SuperCommand makeCommand(String s, String label){
        if (s.equals("Back")) {
            return new BackCommand(myCommandLine, myHistoryBox, label); 
        } 
        if (s.equals("ClearScreen")) {
            return new ClearCommand(myCommandLine, myHistoryBox, label); 
        }
        if (s.equals("Enter")) {
            return new EnterCommand(myCommandLine, myHistoryBox, label);
        }
        if (s.equals("Forward")) {
            return new ForwardCommand(myCommandLine, myHistoryBox, label); 
        }
        if (s.equals("SetPosition")) {
            return new GoToCommand(myCommandLine, myHistoryBox, label); 
        }
        if (s.equals("Home")) {
            return new HomeCommand(myCommandLine, myHistoryBox, label); 
        }
        if (s.equals("Left")) {
            return new LeftCommand(myCommandLine, myHistoryBox, label); 
        }
        if (s.equals("Right")) {
            return new RightCommand(myCommandLine, myHistoryBox, label);
        }
        if (s.equals("SetTowards")) {
            return new TowardsCommand(myCommandLine, myHistoryBox, label); 
        }
        return null;
    }

}
