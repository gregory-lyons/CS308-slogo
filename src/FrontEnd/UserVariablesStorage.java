package FrontEnd;

import java.util.Arrays;
import java.util.List;
import javafx.scene.control.ComboBox;

/**
 * Is a class that would have objects that represent the variables the user created. These are editable
 * and when edited, back-end will be notified.
 * @author Rica
 *
 */
public class UserVariablesStorage {
    private ComboBox<String> myComboBox;
    private static final List<String> MY_DEFAULT_VARIABLES = Arrays.asList("myforward = 5", "myturning = 40", "mycolor = GREEN");
    
    public UserVariablesStorage(String language) {       
        myComboBox = new ComboBox<String>();
        myComboBox.setMinWidth(ViewConstants.SIDEBAR_COMBOBOX_WIDTH);
        myComboBox.getItems().addAll(MY_DEFAULT_VARIABLES);
        myComboBox.setPromptText(StringChooser.getWordInLang(language, DefaultStrings.USER_VARIABLES));
        myComboBox.setEditable(true);
        myComboBox.setOnAction(event -> handle());
    }
    
    private void handle () {
        addVariable(myComboBox.getValue());
        System.out.println(myComboBox.getValue());
    }
    
    public void addVariable(String updatedVariable) {
        for (String each : myComboBox.getItems()) {
            if (each.equals(updatedVariable)) {
                return;
            }
        }
        myComboBox.getItems().add((String) updatedVariable);
    }
    
    public ComboBox<String> getComboBox() {
        return myComboBox;
    }

    public void update (List<String> variables) {
        for (String eachVariable : variables) {
            addVariable(eachVariable);
        }
        
    }
}