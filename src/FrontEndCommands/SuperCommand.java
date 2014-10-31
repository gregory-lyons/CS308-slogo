package FrontEndCommands;

import java.util.Observable;

import FrontEnd.CommandLine;
import FrontEnd.StringChooser;
import FrontEnd.View;
import FrontEnd.ViewConstants;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * This is a superclass. The subclasses (each representing a command) will each have their own appropriate String.
 * All subclasses are observable by the CommandLine and notify the CommandLine when they are pressed.
 * @author Rica, Greg
 *
 */
public class SuperCommand extends Observable {
	protected String myLabel;
	protected Button myButton;
	protected HBox myHBox = new HBox(ViewConstants.BOX_SPACING);
	
    /**
     * This initializes the string representing the command that will be added to the command line when clicked.
     * It also configures the Button properties and sets up the handler.
     * @param myHistory TODO
     */
    public SuperCommand(CommandLine myLine, String label, String language) {
    	myButton = new Button();    	    	
        String myLabel = StringChooser.getWordInLang(language, label);
        myButton.setText(myLabel);
    	myButton.setPrefSize(ViewConstants.SIDEBAR_AMOUNT_BUTTON_WIDTH, ViewConstants.SHORT_BUTTON_HEIGHT);
    	myButton.setOnAction(event -> handle());
    	myHBox.getChildren().add(myButton);
    }
    
    protected void handle() {
        change();
    	this.notifyObservers(myButton.getText());
    }

    public HBox getHBox() {
        return myHBox;
    }

    public Button getButton () {
        return myButton;
    }
    
	public void change() {
		this.setChanged();
	}

}
