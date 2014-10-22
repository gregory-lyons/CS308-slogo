package FrontEnd;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import Backend.Model;
import Backend.SceneUpdater;
import FrontEndCommands.SuperCommand;
import Pen.Pen;
import Pen.PenColorBox;
import Pen.PenOptions;
import TurtleView.BackgroundColorBox;
import TurtleView.GridCheckBox;
import TurtleView.TurtleImageBox;
import TurtleView.TurtleInformation;
import TurtleView.TurtleWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * The View initializes the CommandLine, HistoryBox, CommandFactory, Dropdown Menu, and the display. It accesses
 * the constructor methods in those classes to initialize.
 * @author Rica Zhang, Greg Lyons
 *
 */
public class View implements Observer {	
    private Model myModel;
    private Scene myScene;
    private Controller myController;
    public static final int BUTTON_WIDTH = 200;
    public static final int BUTTON_HEIGHT = 40;
    public static final Dimension DEFAULT_SIZE = new Dimension(1200, 600);
    public static final double DIALOG_WIDTH = 200;
    public static final double DIALOG_HEIGHT = 100;
    public static final boolean DEFAULT_GRIDLINES = true;

    private HBox languageSelectorHBox = new HBox();
    private VBox myVBox = new VBox();
    private HBox usercmdHBox = new HBox();
    private HBox uservrbHBox = new HBox();
    private HBox bottomHBox = new HBox();
    private VBox myInnerVBox = new VBox();
    private VBox centerVBox = new VBox();
    
    private CommandLine myCommandLine;
    private HistoryBox myHistoryBox;
    private TurtleWindow myTurtleWindow;
    
    private CommandFactory myCommandFactory;    
    private SuperCommand myEnterCommand;
    
    private UserCommands dropdownCommandMenu;
    private Pen myPen;
    private UserVariables dropdownVariablesMenu;
    private LanguageSelector myLanguageSelector;
    private TurtleInformation myTurtleInformation;
    private static final String DEFAULT_LANGUAGE = DefaultStrings.ENGLISH;
    
    /**
     * Constructs the view
     * @param language
     */
    public View(Model m) {           	
    	myModel = m;    	
    	myPen = new Pen();
        BorderPane root = new BorderPane();
        
        myTurtleInformation = new TurtleInformation();
        myLanguageSelector = new LanguageSelector(BUTTON_WIDTH, root);
        dropdownCommandMenu = new UserCommands(StringChooser.getWordInLang(DEFAULT_LANGUAGE, DefaultStrings.DROPDOWNMENUDEFAULT), BUTTON_WIDTH, this);
        dropdownVariablesMenu = new UserVariables(StringChooser.getWordInLang(DEFAULT_LANGUAGE, DefaultStrings.DROPDOWNMENUDEFAULT), BUTTON_WIDTH);
        makeTextAreas();
        myCommandFactory = new CommandFactory(myCommandLine, myHistoryBox);
        myTurtleWindow = new TurtleWindow(myPen);
        makeEnterButton();

        myVBox.getChildren().add(myTurtleInformation.getVBox());
        
        /*
        Hyperlink myHyperlink = new Hyperlink("FrontEnd/help.html");
        TextFlow flow = new TextFlow(myHyperlink);
        final WebView webView = WebViewBuilder.create().prefHeight(450).prefWidth(1000).build();
        myHyperlink.setOnAction(event -> {
            webView.getEngine().load("FrontEnd/help.html");
        });
        */
        Button newWindowButton = new Button(StringChooser.getWordInLang(DEFAULT_LANGUAGE, DefaultStrings.NEWWORKSPACE));
        newWindowButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle (MouseEvent m) {
                Stage myStage = new Stage();
                new Workspace(myStage);
            }
        });
        languageSelectorHBox.getChildren().add(newWindowButton);
        languageSelectorHBox.getChildren().add(myLanguageSelector.getComboBox());
        languageSelectorHBox.getChildren().add(myLanguageSelector.getButton());
        root.setTop(languageSelectorHBox);
        bottomHBox.getChildren().add(myCommandLine); 
        usercmdHBox.getChildren().add(dropdownCommandMenu.getComboBox());
        usercmdHBox.getChildren().add(dropdownCommandMenu.getButton());
        uservrbHBox.getChildren().add(dropdownVariablesMenu.getComboBox());
        uservrbHBox.getChildren().add(dropdownVariablesMenu.getButton());

        HBox penBox = new HBox();
        Text penBoxText = new Text(StringChooser.getWordInLang(DEFAULT_LANGUAGE, DefaultStrings.PENCOLOR));
        penBox.getChildren().addAll(new PenColorBox(), penBoxText);
        HBox backgroundBox = new HBox();
        backgroundBox.getChildren().addAll(new BackgroundColorBox(myTurtleWindow), 
                                           new Text(StringChooser.getWordInLang(DEFAULT_LANGUAGE, DefaultStrings.BACKGROUNDCOLOR)));
        HBox imageBox = new HBox();
        imageBox.getChildren().addAll(new TurtleImageBox(myTurtleWindow), 
                                      new Text(StringChooser.getWordInLang(DEFAULT_LANGUAGE, DefaultStrings.TURTLEIMAGE)));
        HBox gridBox = new HBox();
        gridBox.getChildren().addAll(new GridCheckBox(myTurtleWindow), 
                                     new Text(StringChooser.getWordInLang(DEFAULT_LANGUAGE, DefaultStrings.DISPLAYGRIDLINES)));

        myVBox.getChildren().addAll(usercmdHBox, uservrbHBox);
        myVBox.getChildren().add(new PenOptions(myPen));
        myVBox.getChildren().addAll(backgroundBox, imageBox, gridBox);
        root.setCenter(centerVBox);
        centerVBox.getChildren().add(myHistoryBox);
        myInnerVBox.getChildren().add(myEnterCommand.getButton());
        myInnerVBox.getChildren().add(makeClearButton());
        bottomHBox.getChildren().add(1, myInnerVBox);       
        root.setBottom(bottomHBox);
        
        for (String button : myCommandFactory.getCommandButtons()) {
        	SuperCommand sc = myCommandFactory.makeCommand(DEFAULT_LANGUAGE, button);
        	sc.addObserver(this);
            myVBox.getChildren().add(sc.getButton());
        }
        root.setRight(myVBox);
        root.setLeft(myTurtleWindow);
        
        myScene = new Scene(root, DEFAULT_SIZE.width, DEFAULT_SIZE.height);
        myTurtleWindow.requestFocus();
        myScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle (KeyEvent thisKey) {
                System.out.println(thisKey.getCode());
                myTurtleWindow.startMovingTurtle(thisKey);
                thisKey.consume();
            }   
        });
    }
    
    @Override
    public void update(Observable o, Object arg) {
        SceneUpdater updater = myModel.parse((String)arg, myPen.isDown());
	if(!updater.isNoError()) {
    	    makeErrorDialog(updater.getErrorMessage()).show();
    	    return;
    	}
        updater.getVariables();
    	myTurtleWindow.update(updater.getLocation(), updater.getAngle(), updater.penIsDown());
    	myTurtleInformation.update(updater.getLocation(), updater.getAngle());
    }

    /**
     * Creates a clear button that clears the command line when pressed. This is not included in the command
     * factory because it is not a subclass of SuperCommand since it is very simple and doesn't need the features
     * that SuperCommand has.
     * @return clear button
     */
    private Button makeClearButton () {
        Button myClearButton = new Button();
        myClearButton.setText(StringChooser.getWordInLang(DEFAULT_LANGUAGE, DefaultStrings.CLEAR));
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
        myCommandLine = new CommandLine(StringChooser.getWordInLang(DEFAULT_LANGUAGE, DefaultStrings.COMMANDLINEDEFAULT));
        
        myHistoryBox = new HistoryBox(dropdownCommandMenu, 
                                      StringChooser.getWordInLang(DEFAULT_LANGUAGE, DefaultStrings.HISTORYBOXDEFAULT));
        myHistoryBox.setEditable(false);
    }
    
    /**
     * Creates the Enter Button. This is not created in the button for loop above because it is in a
     * different location than the other regular command buttons.
     */
    private void makeEnterButton() {
        // TODO fix repetition
        myEnterCommand = myCommandFactory.makeCommand(DEFAULT_LANGUAGE, DefaultStrings.ENTER);
        myEnterCommand.addObserver(this);
    }
    
    public Stage makeErrorDialog(String message){
    	Stage dialog = new Stage();
    	dialog.initStyle(StageStyle.UTILITY);
    	Scene errorScene = new Scene(new Group(new Text(DIALOG_WIDTH/2, DIALOG_HEIGHT/2, message)), DIALOG_WIDTH, DIALOG_HEIGHT);
    	dialog.setScene(errorScene);
    	return dialog;
    }

    /**
     * 
     * @return the scene
     */
    public Scene getScene () {
        return myScene;
    }
    
    public TurtleWindow getTurtleWindow() {
    	return myTurtleWindow;
    }
    
    public TurtleInformation getTurtleInfo() {
    	return myTurtleInformation;
    }
    
    public void addController (Controller c) {
    	myController = c;
    }



}