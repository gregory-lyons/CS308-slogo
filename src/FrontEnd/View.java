package FrontEnd;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import ImmediateExecutionButtons.EnterCommand;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * The View initializes the CommandLine, HistoryBox, CommandFactory, Dropdown Menu, and the display. It accesses
 * the constructor methods in those classes to initialize.
 * @author Rica
 *
 */
public class View {
    private Scene myScene;
    //private Object myResources;
    //private static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
    private static final int BUTTON_WIDTH = 200;
    private static final int BUTTON_HEIGHT = 30;
    private static final String DROPDOWN_COMMAND_MENU_DEFAULT_TEXT = "User Generated Commands";
    private CommandLine myCommandLine;
    private HistoryBox myHistoryBox;
    private CommandFactory myCommandFactory;
    private static final Dimension DEFAULT_SIZE = new Dimension(1100, 600);
    private HBox myHBox = new HBox();
    private VBox myInnerVBox = new VBox();
    private VBox myVBox = new VBox();
    private EnterCommand myEnterButton;
    private ComboBox comboBox;
    private List<String> myCommandButtons = new ArrayList<String>(Arrays.asList("Forward", "Left", "Right", "Home", "Clear", "Go To", "Towards"));
    

    public View(String language) {
        //myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language + ".properties");
        BorderPane root = new BorderPane();
        
        makeDropdownCommandMenu();
        makeTextArea();
        myCommandFactory = new CommandFactory(myCommandLine, myHistoryBox);
        makeEnterButton();
        
        myHBox.getChildren().add(myCommandLine);
        myVBox.getChildren().add(comboBox);
        myHBox.getChildren().add(myHistoryBox);
        myInnerVBox.getChildren().add(myEnterButton.getButton());
        myInnerVBox.getChildren().add(makeClearButton());
        myHBox.getChildren().add(1, myInnerVBox);       
        root.setBottom(myHBox);
        
        for (String button : myCommandButtons) {
            myVBox.getChildren().add(myCommandFactory.makeCommand(button).getButton());
        }
        root.setRight(myVBox);
        
        myScene = new Scene(root, DEFAULT_SIZE.width, DEFAULT_SIZE.height);
    }

    /**
     * Creates the menu that stores all the user generated commands.
     */
    private void makeDropdownCommandMenu () {
        ObservableList<String> options = FXCollections.observableArrayList();
        comboBox = new ComboBox(options);
        comboBox.setMaxWidth(BUTTON_WIDTH );
        comboBox.setPromptText(DROPDOWN_COMMAND_MENU_DEFAULT_TEXT);
    }

    /**
     * Creates a clear button that clears the command line when pressed. This is not included in the command
     * factory because it is not a subclass of SuperCommand since it is very simple and doesn't need the features
     * that SuperCommand has.
     * @return clear button
     */
    private Button makeClearButton () {
        Button myClearButton = new Button();
        myClearButton.setText("Clear");
        myClearButton.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        myClearButton.setOnAction(new EventHandler<ActionEvent>() {                  
            public void handle (ActionEvent event) {
                // TODO call the model interpreter and send it the string of commands
                myCommandLine.clear();
            }
        });
        return myClearButton;   
    }

    /**
     * Initializes the command line and the history box.
     */
    private void makeTextArea () {
        myCommandLine = new CommandLine();
        
        myHistoryBox = new HistoryBox(comboBox);
        myHistoryBox.setEditable(false);
    }
    
    /**
     * Creates the Enter Button. This is not created in the button for loop above because it is in a
     * different location than the other regular command buttons.
     */
    private void makeEnterButton() {
        myEnterButton = (EnterCommand) myCommandFactory.makeCommand("Enter");
    }

    /**
     * 
     * @return the scene
     */
    public Scene getScene () {
        return myScene;
    }

}