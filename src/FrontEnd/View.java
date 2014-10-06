package FrontEnd;


import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import ImmediateExecutionButtons.EnterCommand;
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
    private CommandLine myCommandLine;
    private HistoryBox myHistoryBox;
    private CommandFactory myCommandFactory;
    private static final Dimension DEFAULT_SIZE = new Dimension(1100, 600);
    private HBox myHBox = new HBox();
    private VBox myInnerVBox = new VBox();
    private VBox myVBox = new VBox();
    private EnterCommand myEnterButton;
    private List<String> myCommandButtons = new ArrayList<String>(Arrays.asList("Forward", "Left", "Home"));
    
    public View(String language) {
        //myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language + ".properties");
        BorderPane root = new BorderPane();
        //root.setTop(makeInputPanel());
        //root.setLeft(makeTurtleScreen());
        myHBox.getChildren().add(makeTextArea());
        myHBox.getChildren().add(makeHistoryBox());
        myInnerVBox.getChildren().add(makeEnterButton());
        myInnerVBox.getChildren().add(makeClearButton());
        myHBox.getChildren().add(1, myInnerVBox);
        
        root.setBottom(myHBox);
        
        myCommandFactory = new CommandFactory(myCommandLine, myHistoryBox);
        for (String button : myCommandButtons) {
            myVBox.getChildren().add(myCommandFactory.makeCommand(button).getButton());
        }
        root.setRight(myVBox);
        myScene = new Scene(root, DEFAULT_SIZE.width, DEFAULT_SIZE.height);

    }

    private HistoryBox makeHistoryBox () {
        myHistoryBox = new HistoryBox();
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

    private CommandLine makeTextArea () {
        myCommandLine = new CommandLine();
        return myCommandLine;
    }
    
    private Button makeEnterButton() {
        myEnterButton = new EnterCommand(myCommandLine, myHistoryBox);
        return myEnterButton.getButton();
        
    }

    public Scene getScene () {
        return myScene;
    }

}