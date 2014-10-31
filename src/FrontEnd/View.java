// This entire file is part of my masterpiece.
// GREG LYONS

package FrontEnd;

import java.util.ArrayList;
import java.util.List;

import Backend.Turtle;
import FrontEndCommands.ClearCommand;
import FrontEndCommands.MakeTurtleCommand;
import FrontEndCommands.NewWorkspace;
import FrontEndCommands.SuperCommand;
import Pen.Pen;
import Pen.PenOptions;
import TurtleView.BackgroundColorBox;
import TurtleView.GridCheckBox;
import TurtleView.TurtleImageBox;
import TurtleView.TurtleInformation;
import TurtleView.TurtleWindow;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
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
	

	private HBar myTopBar;
	private SideBar mySideBar;
	private HBar myBottomBar;
	private Hyperlink myLink;


	private CommandLine myCommandLine;
	private Button addTurtleButton;
	private Button clearButton;
	private HistoryBox myHistoryBox;
	private Console myConsole;
	private TurtleWindow myTurtleWindow;
	private ArrowKeyHandler myArrowHandler;

	private CommandFactory myCommandFactory;    
	private SuperCommand myEnterCommand;
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
		dropdownCommandMenu = new UserCommands(ViewConstants.DEFAULT_LANGUAGE);
		dropdownVariablesMenu = new UserVariablesStorage(ViewConstants.DEFAULT_LANGUAGE);
		makeTextAreas();
		myCommandFactory = new CommandFactory(myCommandLine);
		myArrowHandler = new ArrowKeyHandler();
		myTurtleWindow = new TurtleWindow(myPenBox, myTurtleImageBox, myTurtleInformation);
		addTurtleButton = new MakeTurtleCommand(myTurtleWindow);
		clearButton = new ClearCommand(myCommandLine);
		myButtons = new ArrayList<SuperCommand>();
		makeEnterButton();
		myLink = new Hyperlink(ViewConstants.HELP_LABEL);

		myTopBar = new HBar(myLanguageSelector.getComboBox(), new HelpPage(myLink), new NewWorkspace().getButton());


		myBottomBar = new HBar(myCommandLine, myEnterCommand.getButton(), clearButton, myConsole);
		myBottomBar.setPrefHeight(ViewConstants.BOTTOMBAR_HEIGHT);
		
		myBackgroundColorBox = new BackgroundColorBox(myTurtleWindow);
		myGridCheckBox = new GridCheckBox(myTurtleWindow);
		mySideBar = new SideBar(myTurtleInformation, addTurtleButton, dropdownCommandMenu.getComboBox(), dropdownVariablesMenu.getComboBox(), myPenBox, myBackgroundColorBox, myTurtleImageBox, myGridCheckBox);
		for (String button : myCommandFactory.getCommandButtons()) {
			SuperCommand sc = myCommandFactory.makeCommand(ViewConstants.DEFAULT_LANGUAGE, button);
			myButtons.add(sc);
			mySideBar.add(sc.getHBox());
		}
		
		root.setTop(myTopBar);
		root.setBottom(myBottomBar);
		root.setLeft(myTurtleWindow);
		root.setCenter(myHistoryBox);
		root.setRight(mySideBar);

		myScene = new Scene(root, ViewConstants.DEFAULT_SIZE.width, ViewConstants.DEFAULT_SIZE.height);
		updateFocus();
		myScene.setOnKeyPressed(event -> sendArrowCommand(event));
	}

	private void sendArrowCommand(KeyEvent ke){
		String instruction = myArrowHandler.makeInstruction(ke.getCode());
		if (instruction.equals(DefaultStrings.EMPTY)) return;
		myEnterCommand.change();
		myEnterCommand.notifyObservers(instruction);
		ke.consume();
	}


	/**
	 * Initializes the command line and the history box.
	 */
	private void makeTextAreas () {
		myHistoryBox = new HistoryBox(dropdownCommandMenu, 
				StringChooser.getWordInLang(ViewConstants.DEFAULT_LANGUAGE, DefaultStrings.HISTORYBOXDEFAULT));
		myCommandLine = new CommandLine(StringChooser.getWordInLang(ViewConstants.DEFAULT_LANGUAGE, DefaultStrings.COMMANDLINEDEFAULT), myHistoryBox);
		myConsole = new Console(StringChooser.getWordInLang(ViewConstants.DEFAULT_LANGUAGE, DefaultStrings.CONSOLEDEFAULT));
	}

	/**
	 * Creates the Enter Button. This is not created in the button for loop above because it is in a
	 * different location than the other regular command buttons.
	 */
	private void makeEnterButton() {
		myEnterCommand = myCommandFactory.makeCommand(ViewConstants.DEFAULT_LANGUAGE, DefaultStrings.ENTER);
	}

	public Stage makeErrorDialog(String message, String command){
		message = message + "\nInvalid command: " + command;
		Stage dialog = new Stage();
		dialog.initStyle(StageStyle.UTILITY);
		Scene errorScene = new Scene(new Group(new Text(ViewConstants.ERROR_WIDTH, ViewConstants.ERROR_HEIGHT, message)),
														ViewConstants.DIALOG_WIDTH, ViewConstants.DIALOG_HEIGHT);
		dialog.setScene(errorScene);
		return dialog;
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

}