package FrontEnd;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class UserVariables {
    private ComboBox myComboBox;
    private Button myButton;
    private static final int myButtonWidth = 20;
    //private ObservableList<String> options = FXCollections.observableArrayList();
    
    public UserVariables(String defaultText, int buttonWidth) {       
        myComboBox = new ComboBox();
        myComboBox.setMaxWidth(buttonWidth);
        myComboBox.getItems().addAll("Blue", "Purple", "Red");
        myComboBox.setPromptText(defaultText);
        myComboBox.setEditable(true);
        myButton = new Button("Go");
        myButton.setOnMouseClicked(event -> handle());
    }
    
    private void handle () {
        // TODO On clicked, tell back-end variable name has changed
        System.out.println(myComboBox.getValue());
    }
    public void addVariable(Object instruction) {
        myComboBox.getItems().add((String) instruction);
    }
    
    public ComboBox getComboBox() {
        return myComboBox;
    }
    
    public Button getButton() {
        return myButton;
    }

}