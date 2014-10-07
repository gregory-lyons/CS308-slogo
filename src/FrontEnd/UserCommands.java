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

    private ComboBox myComboBox;
    private Button myButton;

    //private ObservableList<String> options = FXCollections.observableArrayList();
    
    public UserCommands (String defaultText, int buttonWidth, View v) {       
    	addObserver(v);
        myComboBox = new ComboBox();
        myComboBox.setMaxWidth(buttonWidth);
        myComboBox.setPromptText(defaultText);
        myButton = new Button("Go");
        myButton.setMinWidth(buttonWidth/2);
        myButton.setOnMouseClicked(event -> handle());
    }
    
    private void handle () {
    	this.setChanged();
        System.out.println(myComboBox.getValue());
        notifyObservers(myComboBox.getValue());
    }
    public void addCommand(Object instruction) {
        myComboBox.getItems().add((String) instruction);
    }
    
    public ComboBox getComboBox() {
        return myComboBox;
    }
    
    public Button getButton() {
        return myButton;
    }

}
