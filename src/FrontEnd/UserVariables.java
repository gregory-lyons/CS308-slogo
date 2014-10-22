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
    private Button myButton;
    
    public UserVariables(String defaultText) {       
        myComboBox = new ComboBox<String>();
        myComboBox.setMinWidth(View.SIDEBAR_COMBOBOX_WIDTH);
        myComboBox.getItems().addAll("Blue", "Purple", "Red");
        myComboBox.setPromptText(defaultText);
        myComboBox.setEditable(true);
        myButton = new Button(DefaultStrings.GO);
        myButton.setMinWidth(View.GO_BUTTON_WIDTH);
        myButton.setOnMouseClicked(event -> handle());
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
    
    public Button getButton() {
        return myButton;
    }

}