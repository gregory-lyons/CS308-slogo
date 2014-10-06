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
import resources.languages.*;

/**
 * The View initializes the CommandLine, HistoryBox, CommandFactory, Dropdown Menu, and the display. It accesses
 * the constructor methods in those classes to initialize.
 * @author Rica
 *
 */
public class View {
    private static final String LANGUAGE = "Russian";
    private Scene myScene;
    private ResourceBundle myResources;
    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.languages/";
    private static final int BUTTON_WIDTH = 200;
    private static final int BUTTON_HEIGHT = 40;
    private CommandLine myCommandLine;
    private HistoryBox myHistoryBox;
    private CommandFactory myCommandFactory;
    private static final Dimension DEFAULT_SIZE = new Dimension(1100, 600);
    private HBox myHBox = new HBox();
    private VBox myInnerVBox = new VBox();
    private VBox myVBox = new VBox();
    private EnterCommand myEnterCommand;
    private ComboBox dropdownCommandMenu;
    private List<String> myCommandButtons = new ArrayList<String>(Arrays.asList("Forward", "Left", "Right", "Home", "ClearScreen", "SetPosition", "SetTowards"));
    
    /**
     * Constructs the view
     * @param language
     */
    public View(String language) {
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + LANGUAGE);
        BorderPane root = new BorderPane();
        
        makeDropdownCommandMenu();
        makeTextArea();
        myCommandFactory = new CommandFactory(myCommandLine, myHistoryBox);
        makeEnterButton();
        
        myHBox.getChildren().add(myCommandLine);
        myVBox.getChildren().add(dropdownCommandMenu);
        myHBox.getChildren().add(myHistoryBox);
        myInnerVBox.getChildren().add(myEnterCommand.getButton());
        myInnerVBox.getChildren().add(makeClearButton());
        myHBox.getChildren().add(1, myInnerVBox);       
        root.setBottom(myHBox);
        
        for (String button : myCommandButtons) {
            myVBox.getChildren().add(myCommandFactory.makeCommand(button, myResources.getString(button)).getButton());
        }
        root.setRight(myVBox);
        
        myScene = new Scene(root, DEFAULT_SIZE.width, DEFAULT_SIZE.height);
    }

    /**
     * Creates the menu that stores all the user generated commands.
     */
    private void makeDropdownCommandMenu () {
        ObservableList<String> options = FXCollections.observableArrayList();
        dropdownCommandMenu = new ComboBox(options);
        dropdownCommandMenu.setMaxWidth(BUTTON_WIDTH );
        dropdownCommandMenu.setPromptText(myResources.getString("DropdownMenuDefault"));
    }

    /**
     * Creates a clear button that clears the command line when pressed. This is not included in the command
     * factory because it is not a subclass of SuperCommand since it is very simple and doesn't need the features
     * that SuperCommand has.
     * @return clear button
     */
    private Button makeClearButton () {
        Button myClearButton = new Button();
        myClearButton.setText(myResources.getString("Clear"));
        myClearButton.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        myClearButton.setOnAction(new EventHandler<ActionEvent>() {                  
            public void handle (ActionEvent event) {
                myCommandLine.clear();
            }
        });
        return myClearButton;   
    }

    /**
     * Initializes the command line and the history box.
     */
    private void makeTextArea () {
        myCommandLine = new CommandLine(myResources.getString("CommandLineDefault"));
        
        myHistoryBox = new HistoryBox(dropdownCommandMenu, myResources.getString("HistoryBoxDefault"));
        myHistoryBox.setEditable(false);
    }
    
    /**
     * Creates the Enter Button. This is not created in the button for loop above because it is in a
     * different location than the other regular command buttons.
     */
    private void makeEnterButton() {
        myEnterCommand = (EnterCommand) myCommandFactory.makeCommand("Enter", myResources.getString("Enter"));
    }

    /**
     * 
     * @return the scene
     */
    public Scene getScene () {
        return myScene;
    }

}