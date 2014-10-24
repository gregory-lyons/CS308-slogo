package FrontEnd;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import Backend.SceneUpdater;
import Backend.Turtle;
import FrontEndCommands.LoadWorkspace;
import FrontEndCommands.SaveWorkspace;
import FrontEndCommands.SuperCommand;
import Pen.Pen;
import Pen.PenColorBox;
import Pen.PenOptions;
import TurtleView.BackgroundColorBox;
import TurtleView.GridCheckBox;
import TurtleView.TurtleImage;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * The View initializes the CommandLine, HistoryBox, CommandFactory, Dropdown Menu, and the display. It accesses
 * the constructor methods in those classes to initialize.
 * @author Rica Zhang, Greg Lyons
 *
 */

public class View {	
	private Scene myScene;
	private Controller myController;
	public static final int SHORT_BUTTON_HEIGHT = 30;
	public static final int PUFFY_BUTTON_HEIGHT = 60;
	public static final int LANGUAGESELECTOR_CB_WIDTH = 100;
	public static final int NEWWORKSPACE_BUTTON_WIDTH = 100;
	public static final int GO_BUTTON_WIDTH = 50;
	public static final int ENTERCLEAR_BUTTON_WIDTH = 100;
	public static final int SIDEBAR_BUTTON_WIDTH = 200;
	public static final int SIDEBAR_COMBOBOX_WIDTH = 200;
	public static final int SIDEBAR_WIDTH = 300;
	public static final Dimension DEFAULT_SIZE = new Dimension(1200, 600);
	public static final double DIALOG_WIDTH = 200;
	public static final double DIALOG_HEIGHT = 100;
	public static final boolean DEFAULT_GRIDLINES = true;
	private static final String DEFAULT_LANGUAGE = DefaultStrings.ENGLISH;

	private HBox languageSelectorHBox = new HBox();
	private VBox myVBox = new VBox();
	private HBox usercmdHBox = new HBox();
	private HBox uservrbHBox = new HBox();
	private HBox bottomHBox = new HBox();
	private VBox myInnerVBox = new VBox();
	private VBox centerVBox = new VBox();
	private HBox backgroundBox;
	private HBox imageBox;
	private HBox gridBox;

	private CommandLine myCommandLine;
	private HistoryBox myHistoryBox;
	private Console myConsole;
	private TurtleWindow myTurtleWindow;
	private ArrowKeyHandler myArrowHandler;
	private List<Turtle> myActives;

	private CommandFactory myCommandFactory;    
	private SuperCommand myEnterCommand;
	private List<SuperCommand> myButtons;

	private UserCommands dropdownCommandMenu;
	private UserVariables dropdownVariablesMenu;
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
		BorderPane root = new BorderPane();
		myTurtleInformation = new TurtleInformation();
		myPenBox = new PenOptions(new Pen());
		myLanguageSelector = new LanguageSelector(root);
		dropdownCommandMenu = new UserCommands(StringChooser.getWordInLang(DEFAULT_LANGUAGE, DefaultStrings.DROPDOWNMENUDEFAULT));
		dropdownVariablesMenu = new UserVariables(StringChooser.getWordInLang(DEFAULT_LANGUAGE, DefaultStrings.DROPDOWNMENUDEFAULT));
		makeTextAreas();
		myCommandFactory = new CommandFactory(myCommandLine);
		myArrowHandler = new ArrowKeyHandler();
		myTurtleWindow = new TurtleWindow(myPenBox);
		myActives = myTurtleWindow.getActiveTurtles();
		myButtons = new ArrayList<SuperCommand>();
		makeEnterButton();

		myVBox.getChildren().add(myTurtleInformation.getVBox());        
		Hyperlink myHyperlink = new Hyperlink("Help!");

		TextFlow flow = new TextFlow(myHyperlink);
		WebView webView = new WebView();
		WebEngine engine = webView.getEngine();
		myHyperlink.setOnAction(event -> {
			engine.load("http://www.cs.duke.edu/courses/fall14/compsci308/assign/03_slogo/commands2.php");
			Stage myHelpStage = new Stage();
			myHelpStage.setScene(new Scene(webView));
			myHelpStage.show();
		});

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
		languageSelectorHBox.getChildren().add(flow);

		root.setTop(languageSelectorHBox);
		usercmdHBox.getChildren().add(dropdownCommandMenu.getComboBox());
		usercmdHBox.getChildren().add(dropdownCommandMenu.getButton());
		uservrbHBox.getChildren().add(dropdownVariablesMenu.getComboBox());
		uservrbHBox.getChildren().add(dropdownVariablesMenu.getButton());
		
		backgroundBox = new HBox();
		myBackgroundColorBox = new BackgroundColorBox(myTurtleWindow);
		backgroundBox.getChildren().addAll(myBackgroundColorBox, 
				new Text(StringChooser.getWordInLang(DEFAULT_LANGUAGE, DefaultStrings.BACKGROUNDCOLOR)));
		imageBox = new HBox();
		myTurtleImageBox = new TurtleImageBox(myTurtleWindow);
		imageBox.getChildren().addAll(myTurtleImageBox, 
				new Text(StringChooser.getWordInLang(DEFAULT_LANGUAGE, DefaultStrings.TURTLEIMAGE)));
		gridBox = new HBox();
		myGridCheckBox = new GridCheckBox(myTurtleWindow);
		gridBox.getChildren().addAll(myGridCheckBox, 
				new Text(StringChooser.getWordInLang(DEFAULT_LANGUAGE, DefaultStrings.DISPLAYGRIDLINES)));

		myVBox.getChildren().addAll(usercmdHBox, uservrbHBox);
		myVBox.getChildren().add(myPenBox);
		myVBox.getChildren().addAll(backgroundBox, imageBox, gridBox);
		root.setCenter(centerVBox);
		centerVBox.getChildren().add(myHistoryBox);
		myInnerVBox.getChildren().add(myEnterCommand.getButton());
		myInnerVBox.getChildren().add(makeClearButton());
		
		bottomHBox.getChildren().add(myCommandLine); 
		bottomHBox.getChildren().add(myInnerVBox);   
		bottomHBox.getChildren().add(myConsole);
		root.setBottom(bottomHBox);

		for (String button : myCommandFactory.getCommandButtons()) {
			SuperCommand sc = myCommandFactory.makeCommand(DEFAULT_LANGUAGE, button);
			myButtons.add(sc);
			myVBox.getChildren().add(sc.getButton());
		}
		LoadWorkspace myLoadWorkspace = new LoadWorkspace(this);
		myVBox.getChildren().add(myLoadWorkspace.getButton());
		SaveWorkspace mySaveWorkspace = new SaveWorkspace(this);
		myVBox.getChildren().add(mySaveWorkspace.getButton());
		ScrollPane sp = new ScrollPane();
		sp.setHbarPolicy(ScrollBarPolicy.NEVER);
		sp.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		sp.setContent(myVBox);
		//myVBox.minWidth(BUTTON_WIDTH*2);
		//sp.prefViewportWidthProperty().bind(myVBox.minWidthProperty());
		sp.setPadding(new Insets(5,5,5,5));
		sp.setMinWidth(SIDEBAR_WIDTH);
		root.setRight(sp);
		root.setLeft(myTurtleWindow);

		myScene = new Scene(root, DEFAULT_SIZE.width, DEFAULT_SIZE.height);
		myTurtleWindow.requestFocus();
		myScene.setOnKeyPressed(event -> sendArrowCommand(event));
	}

	private void sendArrowCommand(KeyEvent ke){
		//myTurtleWindow.startMovingTurtle(ke);
		String instruction = myArrowHandler.makeInstruction(ke.getCode());
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
		myClearButton.setText(StringChooser.getWordInLang(DEFAULT_LANGUAGE, DefaultStrings.CLEAR));
		myClearButton.setMinSize(ENTERCLEAR_BUTTON_WIDTH, PUFFY_BUTTON_HEIGHT);
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
		
		myConsole = new Console(StringChooser.getWordInLang(DEFAULT_LANGUAGE, DefaultStrings.CONSOLEDEFAULT));
	}

	/**
	 * Creates the Enter Button. This is not created in the button for loop above because it is in a
	 * different location than the other regular command buttons.
	 */
	private void makeEnterButton() {
		myEnterCommand = myCommandFactory.makeCommand(DEFAULT_LANGUAGE, DefaultStrings.ENTER);
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
		dropdownCommandMenu.addObserver(myController);
		for (SuperCommand button: myButtons) {
			button.addObserver(myController);
		}
		myEnterCommand.addObserver(myController);
		dropdownCommandMenu.addObserver(myController);
		
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

	public GridCheckBox getMyGridCheckBox () {
		return myGridCheckBox;
	}
	
	public void addHistoryEntry(String instruction) {
		myHistoryBox.addEntry(instruction);
	}
	
	public void addConsoleEntries(List<Double> returnValues) {
		for (double d: returnValues) {
			myConsole.addEntry(String.valueOf(d));
			System.out.println("added");
		}
		
	}

}