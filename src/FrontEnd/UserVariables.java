package FrontEnd;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * Is a class that would have objects that represent the variables the user created. These are editable
 * and when edited, back-end will be notified.
 * @author Rica
 *
 */
public class UserVariables {
    private ComboBox<String> myComboBox;
    
    public UserVariables(String language) {       
        myComboBox = new ComboBox<String>();
        myComboBox.setMinWidth(View.SIDEBAR_COMBOBOX_WIDTH);
        myComboBox.getItems().addAll("Blue", "Purple", "Red");
        myComboBox.setPromptText(StringChooser.getWordInLang(language, DefaultStrings.USER_VARIABLES));
        myComboBox.setEditable(true);
        myComboBox.setOnAction(event -> handle());
    }
    
    private void handle () {
        // TODO On clicked, tell back-end variable name has changed
        System.out.println(myComboBox.getValue());
    }
    public void addVariable(Object instruction) {
        myComboBox.getItems().add((String) instruction);
    }
    
    public ComboBox<String> getComboBox() {
        return myComboBox;
    }
}