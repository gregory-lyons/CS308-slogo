package FrontEnd;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class UserCommands {
    private ComboBox myComboBox;
    private ObservableList<String> options = FXCollections.observableArrayList();
    
    public UserCommands(String defaultText, int buttonWidth) {       
        myComboBox = new ComboBox(options);
        myComboBox.setMaxWidth(buttonWidth );
        myComboBox.setPromptText(defaultText);
    }
    
    public void addCommand(Object instruction) {
        myComboBox.getItems().add((String) instruction);
    }
    
    public ComboBox getComboBox() {
        return myComboBox;
    }

}
