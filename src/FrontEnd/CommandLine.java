package FrontEnd;

import java.util.Observable;
import java.util.Observer;
import ImmediateExecutionButtons.EnterCommand;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

/**
 * For now it is a simple TextArea. This is a separate class so that new features can easily be added.
 * For this particular implementation, it doesn't need any additional methods because TextArea covers all
 * the methods currently needed.
 * @author Rica, Greg
 *
 */
public class CommandLine extends TextArea implements Observer {
    //EnterCommand myEnterButton;
    
    public CommandLine() {
        this.setMinSize(600, 100);
        this.setMaxSize(600, 150);
        this.setWrapText(true);
        this.setText("Write out some commands for the turtle here...");
        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle (KeyEvent event) {
            }
        }); 
    }

    /**
     * When a button is pushed, new text representing the command is added to the command line
     */
	public void update(Observable button, Object commandText) {	
		//this.appendText((String)commandText);
	}

}
