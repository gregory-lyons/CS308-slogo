package FrontEnd;

import java.util.Observable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * Stores a list of commands that the user created. These commands can be clicked to be re-run.
 * @author Rica
 *
 */
public class UserCommands extends Observable{

    private ComboBox<String> myComboBox;
    private Button myButton;

    //private ObservableList<String> options = FXCollections.observableArrayList();

    public UserCommands (String defaultText) {       
        myComboBox = new ComboBox<String>();
        myComboBox.setMinWidth(View.SIDEBAR_COMBOBOX_WIDTH);
        myComboBox.setPromptText(defaultText);
        myButton = new Button(DefaultStrings.GO);
        myButton.setMinWidth(View.GO_BUTTON_WIDTH);
        myButton.setOnMouseClicked(event -> handle());
    }
    
    private void handle () {
    	this.setChanged();
        notifyObservers(myComboBox.getValue());
    }
    public void addCommand(Object instruction) {
        myComboBox.getItems().add((String) instruction);
    }
    
    public ComboBox<String> getComboBox() {
        return myComboBox;
    }
    
    public Button getButton() {
        return myButton;
    }

}
