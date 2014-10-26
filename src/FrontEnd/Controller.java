package FrontEnd;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import TurtleView.TurtleInformation;
import TurtleView.TurtleWindow;
import Backend.Model;
import Backend.SceneUpdater;
import Backend.Turtle;

/**
 * 
 * 
 * @author Greg Lyons
 * 
 * The Controller serves as the interface between the front end and the back end.  Its executeCommand method calls the Model's parse method,
 * and then it interprets the resulting output and updates the front end accordingly.
 *
 */

public class Controller implements Observer {
	
	View myView;
	Model myModel;
	TurtleWindow myTurtleWindow;
	TurtleInformation myTurtleInformation;

	public Controller(View v, Model m) {
		myView = v;
		myModel = m;
		myTurtleWindow = myView.getTurtleWindow();
		myTurtleInformation = myView.getTurtleInfo();
	}
	
	public void executeCommand(String command, List<Turtle> actives){
		SceneUpdater sceneUpdater = myModel.parse(command, actives, myView.getCurrentLanguage());
		interpret(sceneUpdater, command);
		myView.updateFocus();
	}
	
	private void interpret(SceneUpdater sceneUpdater, String command) {
		if(!sceneUpdater.isNoError()) {
    	    myView.makeErrorDialog(sceneUpdater.getErrorMessage(), command).show();
    	    return;
    	}
        sceneUpdater.getVariables();
    	myTurtleWindow.update(sceneUpdater.getTurtles());
    	myView.addConsoleEntries(sceneUpdater.getReturnValues());
    	myView.addHistoryEntry(command);
    	myView.updateTurtleInfo(myTurtleWindow.getActiveTurtles());
    	myView.updateUserVariables(sceneUpdater.getVariables());
	}

	@Override
	public void update(Observable o, Object arg) {
		executeCommand((String)arg, myTurtleWindow.getActiveTurtles());		
	}

}
