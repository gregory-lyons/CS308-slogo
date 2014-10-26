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

    //private ObservableList<String> options = FXCollections.observableArrayList();

    public UserCommands (String language) {       
        myComboBox = new ComboBox<String>();
        myComboBox.setMinWidth(View.SIDEBAR_COMBOBOX_WIDTH);
        myComboBox.setPromptText(StringChooser.getWordInLang(language, DefaultStrings.DROPDOWNMENUDEFAULT));
        myComboBox.setOnAction(event -> handle());
    }
    
    private void handle () {
    	this.setChanged();
        notifyObservers(myComboBox.getValue());
    }
    
    /**
     * Checks if it has the command already, if not it will add the command
     * @param instruction
     */
    public void addCommand(Object instruction) {
        for (String each : myComboBox.getItems()) {
            if (each.equals(instruction)) {
                return;
            }
        }
        myComboBox.getItems().add((String) instruction);
    }
    
    public ComboBox<String> getComboBox() {
        return myComboBox;
    }
}
