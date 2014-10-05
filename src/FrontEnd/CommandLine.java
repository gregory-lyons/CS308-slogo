package FrontEnd;

import java.util.Observable;
import java.util.Observer;
import javafx.scene.control.TextArea;

/**
 * For now it is a simple TextArea. This is a separate class so that new features can easily be added.
 * For this particular implementation, it doesn't need any additional methods because TextArea covers all
 * the methods currently needed.
 * @author Rica, Greg
 *
 */
public class CommandLine extends TextArea implements Observer {
    
    public CommandLine() {
        
    }

    /**
     * When a button is pushed, new text representing the command is added to the command line
     */
    @Override
    public void update (Observable arg0, Object arg1) {
        // TODO Auto-generated method stub
        
    }

}
