package FrontEndCommands;

import FrontEnd.DefaultStrings;
import FrontEnd.StringChooser;
import FrontEnd.View;
import FrontEnd.Workspace;
import javafx.event.EventHandler;
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
        newWindowButton = new Button(StringChooser.getWordInLang(View.DEFAULT_LANGUAGE, DefaultStrings.NEWWORKSPACE));
        newWindowButton.setMinWidth(View.SIDEBAR_BUTTON_WIDTH);
        newWindowButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle (MouseEvent m) {
                        Stage myStage = new Stage();
                        new Workspace(myStage);
                }
        });
    }
    
    public Button getButton() {
        return newWindowButton;
    }

}
