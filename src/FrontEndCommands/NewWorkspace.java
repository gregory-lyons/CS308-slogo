package FrontEndCommands;

import FrontEnd.DefaultStrings;
import FrontEnd.Translator;
import FrontEnd.View;
import FrontEnd.Workspace;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Creates a new turtle workspace for user
 * @author Rica
 *
 */
public class NewWorkspace {
    Button newWindowButton;
    
    public NewWorkspace() {
        newWindowButton = new Button(Translator.translateWithKey(DefaultStrings.NEWWORKSPACE, View.DEFAULT_LANGUAGE));
        newWindowButton.setMinWidth(View.SIDEBAR_BUTTON_WIDTH);
        newWindowButton.setOnMouseClicked(event -> handle(event));
    }
    
    public void handle(MouseEvent m) {
            Stage myStage = new Stage();
            new Workspace(myStage);
    }      
    
    public Button getButton() {
        return newWindowButton;
    }

}
