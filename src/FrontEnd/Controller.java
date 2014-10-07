package FrontEnd;

import java.util.Observable;
import java.util.Observer;
import TurtleCommands.EnterCommand;

public class Controller implements Observer {
    public Controller() {
        
    }

    @Override
    public void update (Observable o, Object arg) {
        if (o instanceof EnterCommand) {
            
        }
        else {
            
        }
        
    }

}
