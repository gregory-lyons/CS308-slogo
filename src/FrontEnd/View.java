package FrontEnd;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import Backend.Turtle;
import FrontEndCommands.EnterButton;
import FrontEndCommands.LoadWorkspace;
import FrontEndCommands.NewWorkspace;
import FrontEndCommands.SaveWorkspace;
import FrontEndCommands.SuperCommand;
import Pen.Pen;
import Pen.PenOptions;
import TurtleView.BackgroundColorBox;
import TurtleView.GridCheckBox;
import TurtleView.TurtleImageBox;
import TurtleView.TurtleInformation;
import TurtleView.TurtleWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * The View is the overall container class for the front end.  It holds all of the GUI components and has various methods to update its state.
 * @author Rica Zhang, Greg Lyons
 *
 */
public class View {	
	private Scene myScene;
	BorderPane root;
	private Controller myController;
	public static final int SHORT_BUTTON_HEIGHT = 30;
	public static final int PUFFY_BUTTON_HEIGHT = 60;
	public static final int LANGUAGESELECTOR_CB_WIDTH = 100;
	public static final int NEWWORKSPACE_BUTTON_WIDTH = 100;
	public static final int GO_BUTTON_WIDTH = 50;
	public static final int ENTERCLEAR_BUTTON_WIDTH = 100;
	public static final int COMMANDLINE_WIDTH = 500;
	public static final int COMMANDLINE_HEIGHT = 150;
	public static final int HISTORY_BOX_WIDTH = 400;
	public static final int HISTORY_BOX_HEIGHT = 400;
	public static final int SIDEBAR_WIDTH = 250;
	public static final int SIDEBAR_BUTTON_WIDTH = 200;
	public static final int SIDEBAR_AMOUNT_BUTTON_WIDTH = 125;
	public static final int SIDEBAR_AMOUNT_WIDTH = 75;
	public static final int SIDEBAR_COMBOBOX_WIDTH = 200;
	public static final Dimension DEFAULT_SIZE = new Dimension(1200, 600);
	public static final double DIALOG_WIDTH = 400;
	public static final double DIALOG_HEIGHT = 100;
	public static final Insets PADDING = new Insets(5);
	public static final int BOX_SPACING = 5;
	public static final double TURTLEWINDOW_WIDTH = 600.0;
	public static final double TURTLEWINDOW_HEIGHT = 400.0;
	public static final boolean DEFAULT_GRIDLINES = true;
	public static final String DEFAULT_LANGUAGE = DefaultStrings.ENGLISH;
	public static final double ERROR_HEIGHT = 30;
	public static final double ERROR_WIDTH = 30;

	private HBox topHBox = new HBox(BOX_SPACING);
	private VBox leftVBox = new VBox(BOX_SPACING);
        private VBox centerVBox = new VBox(BOX_SPACING);
	private VBox sidebarVBox = new VBox(BOX_SPACING);
	private HBox usercmdHBox = new HBox(BOX_SPACING);
	private HBox uservrbHBox = new HBox(BOX_SPACING);
	private HBox bottomLeftHBox = new HBox(BOX_SPACING);
	private VBox enterclearVBox = new VBox(BOX_SPACING);
	private VBox backgroundBox = new VBox();
	private VBox imageBox = new VBox();
	private HBox gridBox = new HBox(BOX_SPACING);

	private CommandLine myCommandLine;
	private Button addTurtleButton;
	private HistoryBox myHistoryBox;
	private Console myConsole;
	private TurtleWindow myTurtleWindow;
	private ArrowKeyHandler myArrowHandler;

	private CommandFactory myCommandFactory;    
	private EnterButton myEnterCommand;
	private List<SuperCommand> myButtons;

	private UserCommands dropdownCommandMenu;
	private UserVariablesStorage dropdownVariablesMenu;
	private LanguageSelector myLanguageSelector;
	private TurtleInformation myTurtleInformation;

	private PenOptions myPenBox;
	private BackgroundColorBox myBackgroundColorBox;
	private TurtleImageBox myTurtleImageBox;
	private GridCheckBox myGridCheckBox;

	/**
	 * Constructs the view
	 * @param language
	 */
	public View() {           	
		root = new BorderPane();
		myTurtleInformation = new TurtleInformation(null);
		myPenBox = new PenOptions(new Pen());
		myTurtleImageBox = new TurtleImageBox(new Turtle());
		myLanguageSelector = new LanguageSelector(root);
		dropdownCommandMenu = new UserCommands();
		dropdownVariablesMenu = new UserVariablesStorage();
		makeTextAreas();
		myCommandFactory = new CommandFactory(myCommandLine);
		myArrowHandler = new ArrowKeyHandler();
		myTurtleWindow = new TurtleWindow(myPenBox, myTurtleImageBox, myTurtleInformation);
		myButtons = new ArrayList<SuperCommand>();
		makeEnterButton();
		makeTurtleButton();
		
		topHBox.setPadding(PADDING);
		leftVBox.setPadding(PADDING);
		centerVBox.setPadding(PADDING);
		sidebarVBox.setPadding(PADDING);						
		
		NewWorkspace myNewWorkspace = new NewWorkspace();
	        LoadWorkspace myLoadWorkspace = new LoadWorkspace(this);
	        SaveWorkspace mySaveWorkspace = new SaveWorkspace(this);
		topHBox.getChildren().addAll(myLanguageSelector.getComboBox());
		topHBox.getChildren().add(createHelpLink());
		topHBox.getChildren().add(myNewWorkspace.getButton());
		topHBox.getChildren().add(myLoadWorkspace.getButton());
		topHBox.getChildren().add(mySaveWorkspace.getButton());
		root.setTop(topHBox);
		
	        enterclearVBox.getChildren().add(myEnterCommand.getButton());
	        enterclearVBox.getChildren().add(makeClearButton());
	        bottomLeftHBox.getChildren().add(myCommandLine); 
	        bottomLeftHBox.getChildren().add(enterclearVBox);
	        leftVBox.getChildren().add(myTurtleWindow);
	        leftVBox.getChildren().add(bottomLeftHBox);
	        root.setLeft(leftVBox);
		
	        centerVBox.getChildren().add(myHistoryBox);
	        centerVBox.getChildren().add(myConsole);
	        root.setCenter(centerVBox);
		
		usercmdHBox.getChildren().addAll(dropdownCommandMenu.getComboBox());
		uservrbHBox.getChildren().addAll(dropdownVariablesMenu.getComboBox());
		myBackgroundColorBox = new BackgroundColorBox(myTurtleWindow);
		Text backgroundColorBoxText = new Text(Translator.translateWithKey(DefaultStrings.BACKGROUNDCOLOR, DEFAULT_LANGUAGE));
		backgroundBox.getChildren().addAll(backgroundColorBoxText, myBackgroundColorBox);
		Text turtleImageBoxText = new Text(Translator.translateWithKey(DefaultStrings.TURTLEIMAGE, DEFAULT_LANGUAGE));
		imageBox.getChildren().addAll(turtleImageBoxText , myTurtleImageBox);
		myGridCheckBox = new GridCheckBox(myTurtleWindow);
		Text gridCheckBoxText = new Text(Translator.translateWithKey(DefaultStrings.DISPLAYGRIDLINES, DEFAULT_LANGUAGE));
		gridBox.getChildren().addAll(myGridCheckBox, gridCheckBoxText);		                             

	        sidebarVBox.getChildren().add(myTurtleInformation);
		sidebarVBox.getChildren().add(addTurtleButton);
		sidebarVBox.getChildren().addAll(usercmdHBox, uservrbHBox);
		sidebarVBox.getChildren().add(myPenBox);
		sidebarVBox.getChildren().addAll(backgroundBox, imageBox, gridBox);

		for (String button : DefaultStrings.COMMAND_BUTTONS) {
                    SuperCommand sc = myCommandFactory.makeCommand(DEFAULT_LANGUAGE, button);
                    myButtons.add(sc);
                    sidebarVBox.getChildren().add(sc.getHBox());
		}
		
		ScrollPane sp = new ScrollPane();
		sp.setHbarPolicy(ScrollBarPolicy.NEVER);
		sp.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		sp.setContent(sidebarVBox);
		sp.setMinWidth(SIDEBAR_WIDTH);
		root.setRight(sp);
		
		myScene = new Scene(root, DEFAULT_SIZE.width, DEFAULT_SIZE.height);
		updateFocus();
		myScene.setOnKeyPressed(event -> sendArrowCommand(event));
	}

	private Hyperlink createHelpLink () {
	    Hyperlink myHyperlink = new Hyperlink("Help!");
            myHyperlink.setOnAction(event -> 
                {
                        WebView webView = new WebView();
                        WebEngine engine = webView.getEngine();                 
                        engine.load(DefaultStrings.HELP_PAGE_URL);
                        Stage myHelpStage = new Stage();
                        myHelpStage.setScene(new Scene(webView));
                        myHelpStage.show();
                });
            return myHyperlink;
        }

        private void sendArrowCommand(KeyEvent ke) {
		String instruction = myArrowHandler.makeInstruction(ke.getCode());
		if (instruction.equals(DefaultStrings.EMPTY)) return;
		myEnterCommand.change();
		myEnterCommand.notifyObservers(instruction);
		ke.consume();
	}

	/**
	 * Creates a clear button that clears the command line when pressed. This is not included in the command
	 * factory because it is not a subclass of SuperCommand since it is very simple and doesn't need the features
	 * that SuperCommand has.
	 * @return clear button
	 */
	private Button makeClearButton () {
		Button myClearButton = new Button();
		myClearButton.setText(Translator.translateWithKey(DefaultStrings.CLEAR, DEFAULT_LANGUAGE));
		myClearButton.setMinSize(ENTERCLEAR_BUTTON_WIDTH, PUFFY_BUTTON_HEIGHT);
		myClearButton.setOnAction(new EventHandler<ActionEvent>() {                  
			public void handle (ActionEvent event) {
				myCommandLine.clear();
			}
		});
		return myClearButton;   
	}
	
	private void makeTurtleButton(){
	    addTurtleButton = new Button();
	    addTurtleButton.setText(Translator.translateWithKey(DefaultStrings.TURTLEBUTTON, DEFAULT_LANGUAGE));
	    addTurtleButton.setPrefSize(SIDEBAR_BUTTON_WIDTH, SHORT_BUTTON_HEIGHT);
	    addTurtleButton.setOnAction(event -> myTurtleWindow.makeTurtle());
	}

	/**
	 * Initializes the command line and the history box.
	 */
	private void makeTextAreas () {
	        myHistoryBox = new HistoryBox(dropdownCommandMenu); 
	        myHistoryBox.setEditable(false);
		myCommandLine = new CommandLine(myHistoryBox);		
		myConsole = new Console();
	}

	/**
	 * Creates the Enter Button. This is not created in the button for loop above because it is in a
	 * different location than the other regular command buttons.
	 */
	private void makeEnterButton () {
		myEnterCommand = new EnterButton(myCommandLine);
	}

	public Stage makeErrorDialog(String message, String command){
	    message = message + "\nInvalid command: " + command;
		Stage dialog = new Stage();
		dialog.initStyle(StageStyle.UTILITY);
		Scene errorScene = new Scene(new Group(new Text(ERROR_WIDTH, ERROR_HEIGHT, message)), DIALOG_WIDTH, DIALOG_HEIGHT);
		dialog.setScene(errorScene);
		return dialog;
	}
	
	public void addController (Controller c) {
            myController = c;
            dropdownCommandMenu.addObserver(myController);
            for (SuperCommand button: myButtons) {
                    button.addObserver(myController);
            }
            myEnterCommand.addObserver(myController);
            dropdownCommandMenu.addObserver(myController);
        }
	
        public void addHistoryEntry(String instruction) {
            myHistoryBox.addEntry(instruction);
        }
    
        public void addConsoleEntries(List<Double> returnValues) {
            String consoleText = "";
            for (double d: returnValues) {
                    consoleText+= String.valueOf(d) + "\n";
            }            
            myConsole.setText(consoleText);
            myConsole.appendText("");
        }

        public void updateFocus() {
                root.requestFocus();
        }
    
        public void updateTurtleInfo(List<Turtle> activeTurtles) {
            myTurtleInformation.update();
        }
    
        public void updateUserVariables (List<String> variables) {
            dropdownVariablesMenu.update(variables);        
        }	

	public Scene getScene () {
		return myScene;
	}
	
	public String getCurrentLanguage(){
		return myLanguageSelector.getComboBox().getValue();
	}

	public TurtleWindow getTurtleWindow() {
		return myTurtleWindow;
	}

	public TurtleInformation getTurtleInfo() {
		return myTurtleInformation;
	}

	public LanguageSelector getLanguageSelector() {
		return myLanguageSelector;
	}


	public BackgroundColorBox getMyBackgroundColorBox () {
		return myBackgroundColorBox;
	}

	public TurtleImageBox getMyTurtleImageBox () {
		return myTurtleImageBox;
	}
	
	public Button getAddTurtleButton() {
	    return addTurtleButton;
	}

	public GridCheckBox getMyGridCheckBox () {
		return myGridCheckBox;
	}
}