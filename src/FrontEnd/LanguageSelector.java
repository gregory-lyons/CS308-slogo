package FrontEnd;


import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * Stores a list of commands that the user created. These commands can be clicked to be re-run.
 * @author Rica
 *
 */
public class LanguageSelector {
    private static final String DEFAULT_TEXT = "Select a Language";
    private ComboBox myComboBox;
    private Button myButton;
    private static final int myButtonWidth = 20;
    private List<Object> hasLanguage;
    //private ObservableList<String> options = FXCollections.observableArrayList();
    
    public LanguageSelector(int buttonWidth) {       
        myComboBox = new ComboBox();
        myComboBox.setMaxWidth(buttonWidth);
        myComboBox.setPromptText(DEFAULT_TEXT);
        myComboBox.getItems().addAll("English", "Chinese", "French", "Italian", "Portuguese", "Russian");
        myButton = new Button("Go");
        myButton.setOnMouseClicked(event -> handle());
    }
    
    private void addLanguager(Object o) {
        hasLanguage.add(o);
    }
    
    private void handle () {
        for (Object o : hasLanguage) {
            Class objectClass = o.getClass();
            o = (objectClass) o;
        }
        System.out.println(myComboBox.getValue());
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
