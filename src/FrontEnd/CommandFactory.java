package FrontEnd;
import CommandButtons.BackCommand;
import CommandButtons.ClearCommand;
import CommandButtons.EnterCommand;
import CommandButtons.ForwardCommand;
import CommandButtons.GoToCommand;
import CommandButtons.HomeCommand;
import CommandButtons.LeftCommand;
import CommandButtons.RightCommand;
import CommandButtons.SetXYCommand;
import CommandButtons.TowardsCommand;
import CommandButtons.SuperCommand;

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
    public SuperCommand makeCommand(String s){
        if (s.equals("Forward")) {
            return new ForwardCommand(myCommandLine, myHistoryBox); 
        }
        if (s.equals("Back")) {
            return new BackCommand(myCommandLine, myHistoryBox); 
        } 
        if (s.equals("Clear")) {
            return new ClearCommand(myCommandLine, myHistoryBox); 
        }
        if (s.equals("Go To")) {
            return new GoToCommand(myCommandLine, myHistoryBox); 
        }
        if (s.equals("Home")) {
            return new HomeCommand(myCommandLine, myHistoryBox); 
        }
        if (s.equals("Left")) {
            return new LeftCommand(myCommandLine, myHistoryBox); 
        }
        if (s.equals("SetXY")) {
            return new SetXYCommand(myCommandLine, myHistoryBox); 
        }
        if (s.equals("Towards")) {
            return new TorwardsCommand(myCommandLine, myHistoryBox); 
        }
    }

}
