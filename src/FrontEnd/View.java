package FrontEnd;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import TurtleCommands.EnterCommand;
import TurtleView.TurtleInformation;
import TurtleView.TurtleWindow;
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
    private String language = "English";
    private Scene myScene;
    private ResourceBundle myResources;
    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.languages/";
    private static final int BUTTON_WIDTH = 200;
    private static final int BUTTON_HEIGHT = 40;
    private static final Dimension DEFAULT_SIZE = new Dimension(1100, 600);
    
    private HBox languageSelectorHBox = new HBox();
    private VBox myVBox = new VBox();
    private HBox usercmdHBox = new HBox();
    private HBox uservrbHBox = new HBox();
    private HBox bottomHBox = new HBox();
    private VBox myInnerVBox = new VBox();
    private VBox centerVBox = new VBox();
    
    private CommandLine myCommandLine;
    private HistoryBox myHistoryBox;
    
    private CommandFactory myCommandFactory;    
    private EnterCommand myEnterCommand;
    
    private UserCommands dropdownCommandMenu;
    private UserVariables dropdownVariablesMenu;
    private LanguageSelector myLanguageSelector;
    private TurtleInformation myTurtleInformation;
    private List<String> myCommandButtons = new ArrayList<String>(Arrays.asList("Forward", "Left", "Right", "Home", "ClearScreen", "SetPosition", "SetTowards"));

    /**
     * Constructs the view
     * @param language
     */
    public View() {       
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
        BorderPane root = new BorderPane();
        
        myTurtleInformation = new TurtleInformation();
        myLanguageSelector = new LanguageSelector(BUTTON_WIDTH);
        dropdownCommandMenu = new UserCommands(myResources.getString("DropdownMenuDefault"), BUTTON_WIDTH);
        dropdownVariablesMenu = new UserVariables(myResources.getString("DropdownMenuDefault"), BUTTON_WIDTH);
        makeTextAreas();
        myCommandFactory = new CommandFactory(myCommandLine, myHistoryBox);
        makeEnterButton();

        myVBox.getChildren().add(myTurtleInformation.getVBox());
        languageSelectorHBox.getChildren().add(myLanguageSelector.getComboBox());
        languageSelectorHBox.getChildren().add(myLanguageSelector.getButton());
        root.setTop(languageSelectorHBox);
        bottomHBox.getChildren().add(myCommandLine);
        usercmdHBox.getChildren().add(dropdownCommandMenu.getComboBox());
        usercmdHBox.getChildren().add(dropdownCommandMenu.getButton());
        uservrbHBox.getChildren().add(dropdownVariablesMenu.getComboBox());
        uservrbHBox.getChildren().add(dropdownVariablesMenu.getButton());
        myVBox.getChildren().add(usercmdHBox);
        myVBox.getChildren().add(uservrbHBox);
        root.setCenter(centerVBox);
        centerVBox.getChildren().add(myHistoryBox);
        myInnerVBox.getChildren().add(myEnterCommand.getButton());
        myInnerVBox.getChildren().add(makeClearButton());
        bottomHBox.getChildren().add(1, myInnerVBox);       
        root.setBottom(bottomHBox);
        
        for (String button : myCommandButtons) {
            myVBox.getChildren().add(myCommandFactory.makeCommand(button, myResources.getString(button)).getButton());
        }
        root.setRight(myVBox);
        root.setLeft(new TurtleWindow());
        
        myScene = new Scene(root, DEFAULT_SIZE.width, DEFAULT_SIZE.height);
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
    private void makeTextAreas () {
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