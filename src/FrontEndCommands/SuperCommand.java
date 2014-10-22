package FrontEndCommands;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import FrontEnd.CommandLine;
import FrontEnd.DefaultStrings;
import FrontEnd.HistoryBox;
import FrontEnd.StringChooser;
import FrontEnd.View;
import javafx.scene.control.Button;

/**
 * This is a superclass. The subclasses (each representing a command) will each have their own appropriate String.
 * All subclasses are observable by the CommandLine and notify the CommandLine when they are pressed.
 * @author Rica, Greg
 *
 */
public class SuperCommand extends Observable {
        private static final int MIN_HEIGHT = 30;
        private static final int MIN_WIDTH = 200;
        private Map<String, Double> myCommandValues = new HashMap<String, Double>();
	protected String myInstruction;
	protected String myLabel;
	protected Button myButton;
	
    /**
     * This initializes the string representing the command that will be added to the command line when clicked.
     * It also configures the Button properties and sets up the handler.
     * @param myHistory TODO
     */
    public SuperCommand(CommandLine myLine, HistoryBox myHistory, String label, String language) {
    	myButton = new Button();
    	//this.addObserver(myLine);
    	this.addObserver(myHistory);
    	
    	myCommandValues.put(DefaultStrings.BACKWARD, 5.0);
    	myCommandValues.put(DefaultStrings.FORWARD, 5.0);
    	myCommandValues.put(DefaultStrings.LEFT, 270.0);
    	myCommandValues.put(DefaultStrings.LEFT, 90.0);
    	myCommandValues.put(DefaultStrings.XCOORDINATE, 0.0);
    	myCommandValues.put(DefaultStrings.YCOORDINATE, 0.0);
    	
        String myLabel = StringChooser.getWordInLang(language, label);
        myInstruction = myLabel.toUpperCase() + " " + myCommandValues.get(label);
        myButton.setText(myLabel);
    	myButton.setPrefSize(View.SIDEBAR_BUTTON_WIDTH, View.SHORT_BUTTON_HEIGHT);
    	myButton.setOnAction(event -> handle());
    }
    
    public Button getButton(){
    	return myButton;
    }
    
    protected void handle() {
        this.setChanged();
    	this.notifyObservers(myInstruction);
    }

}
