package CommandButtons;

import java.util.Observable;

import FrontEnd.CommandLine;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * This is a superclass. The subclasses (each representing a command) will each have their own appropriate String.
 * All subclasses are observable by the CommandLine and notify the CommandLine when they are pressed.
 * @author Rica, Greg
 *
 */
public class SuperCommand extends Observable {
    
	protected String myInstruction;
	protected String myLabel;
	protected Button myButton;
	
    /**
     * This initializes the string representing the command that will be added to the command line when clicked.
     * It also configures the Button properties and sets up the handler.
     * @param myHistory TODO
     */
    public SuperCommand(CommandLine myLine, HistoryBox myHistory) {
    	myButton = new Button();
    	
    	this.addObserver(myLine, myHistory);
    	myButton.setOnAction(new EventHandler<ActionEvent>() {
    		@Override
    		public void handle(ActionEvent event){
    			notifyObservers(myInstruction);
    		}
    	});
    }
    
    public Button getButton(){
    	return myButton;
    }

}
