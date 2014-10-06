package FrontEnd;


import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * The View mainly has private classes to initialize the View. If you need to change aspects of the View, 
 * use the classes that it stores such as CommandControl, Turtle, CommandLine, and TurtleWindow.
 * @author Rica
 *
 */
public class View {
    private Scene myScene;
    //private Object myResources;
    //private static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
    private TextArea myCommandLine;
    private TextArea myHistoryBox;
    private CommandControl myCommandControl; 
    private CommandFactory myCommandFactory;
    private static final Dimension DEFAULT_SIZE = new Dimension(1100, 600);
    private HBox myHBox = new HBox();
    private VBox myInnerVBox = new VBox();
    private VBox myVBox = new VBox();
    private Button myEnterButton;
    private List<String> myCommandButtons = new ArrayList<String>(Arrays.asList("Forward", "Left", "Show Turtle", "Hide Turtle",
                                                                                "XCor", "YCor"));
    
    public View(String language) {
        //myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language + ".properties");
        BorderPane root = new BorderPane();
        //root.setTop(makeInputPanel());
        //root.setLeft(makeTurtleScreen());
        myHBox.getChildren().add(makeTextArea());
        myInnerVBox.getChildren().add(makeEnterButton());
        myInnerVBox.getChildren().add(makeClearButton());
        myHBox.getChildren().add(myInnerVBox);
        myHBox.getChildren().add(makeHistoryBox());
        root.setBottom(myHBox);
        
        for (String button : myCommandButtons) {
            myVBox.getChildren().add(makeCommandButton(button));
        }
        root.setRight(myVBox);
        myScene = new Scene(root, DEFAULT_SIZE.width, DEFAULT_SIZE.height);

    }

    private TextArea makeHistoryBox () {
        myHistoryBox = new TextArea();
        myHistoryBox.setEditable(false);
        return myHistoryBox;
    }

    private Button makeClearButton () {
        Button myClearButton = new Button();
        myClearButton.setText("Clear");
        myClearButton.setMinHeight(50);
        myClearButton.setMinWidth(80);
        myClearButton.setOnAction(new EventHandler<ActionEvent>() {                  
            public void handle (ActionEvent event) {
                // TODO call the model interpreter and send it the string of commands
                myCommandLine.clear();
            }
        });
        return myClearButton;   
    }

    private TextArea makeTextArea () {
        myCommandLine = new TextArea();
        myCommandLine.setMinSize(600, 100);
        myCommandLine.setMaxSize(600, 150);
        myCommandLine.setWrapText(true);
        myCommandLine.setText("Write out some commands for the turtle here...");
        myCommandLine.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle (KeyEvent event) {
                if (myCommandLine.getText().equals("Write out some commands for the turtle here...")) {
                    myCommandLine.setText("");
                }
            }
        });
        return myCommandLine;
    }
    
    private Button makeEnterButton() {
        myEnterButton = new Button();
        myEnterButton.setText("Enter");
        myEnterButton.setMinHeight(50);
        myEnterButton.setMinWidth(80);
        myEnterButton.setOnAction(new EventHandler<ActionEvent>() {                  
            public void handle (ActionEvent event) {
                // TODO call the model interpreter and send it the string of commands
                myCommandLine.setText("Moving the turtle...");
            }
        });
        return myEnterButton;        
    }

    /**
     * Method to make command buttons with a string name specified
     * @param string name of the command button
     * @return the button
     */
    private Button makeCommandButton (String str) {
        final Button myButton = new Button();
        myButton.setText(str);
        myButton.setMinHeight(50);
        myButton.setMinWidth(150);
        myButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle (MouseEvent arg0) {
               if (myCommandLine.getText().equals("Write out some commands for the turtle here...")) {
                   myCommandLine.setText(myButton.getText() + " ");
               }
               else {
                   myCommandLine.appendText(myButton.getText() + " ");
               }
            }
        });
        return myButton;
    }

    public Scene getScene () {
        return myScene;
    }

}