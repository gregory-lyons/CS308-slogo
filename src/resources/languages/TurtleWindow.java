package resources.languages;

import java.awt.Dimension;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * 
 * @author Rica
 *
 */
public class TurtleWindow {
    private Scene myScene;
    private Object myResources;
    private TextArea myTextArea;
    private String myTextAreaString;
    private static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
    private static final Dimension DEFAULT_SIZE = new Dimension(800, 600);
    private HBox myHBox = new HBox();
    private Button myEnterButton;
    
    public TurtleWindow(String language) {
        //myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language + ".properties");
        BorderPane root = new BorderPane();
        //root.setCenter(makePageDisplay());
        //root.setTop(makeInputPanel());
        myHBox.getChildren().add(makeTextArea());
        myHBox.getChildren().add(makeEnterButton());
        root.setBottom(myHBox);
        myScene = new Scene(root, DEFAULT_SIZE.width, DEFAULT_SIZE.height);

    }

    private TextArea makeTextArea () {
        myTextArea = new TextArea();
        myTextArea.setMinSize(600, 100);
        myTextArea.setMaxSize(600, 150);
        myTextArea.setWrapText(true);
        myTextArea.setText("Write out some commands for the turtle here...");
        myTextArea.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle (KeyEvent event) {
                if (myTextArea.getText().equals("Write out some commands for the turtle here...")) {
                    myTextArea.setText("");
                }
            }
        });
        return myTextArea;
    }
    
    private Button makeEnterButton() {
        myEnterButton = new Button();
        myEnterButton.setText("Enter");
        myEnterButton.setMinHeight(50);
        myEnterButton.setMinWidth(80);
        myEnterButton.setOnAction(new EventHandler<ActionEvent>() {                  
            public void handle (ActionEvent event) {
                // TODO call the model interpreter and send it the string of commands
                myTextArea.setText("Moving the turtle...");
            }
        });
        return myEnterButton;        
    }

    private Button makeCommandButton (String string, EventHandler<ActionEvent> eventHandler) {
        // TODO Auto-generated method stub
        return null;
    }

    public Scene getScene () {
        return myScene;
    }

}
