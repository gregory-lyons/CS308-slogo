package FrontEnd;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import TurtleView.TurtleInformation;
import TurtleView.TurtleWindow;
import Backend.Model;
import Backend.SceneUpdater;
import Backend.Turtle;

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
	
	public void executeCommand(String s, List<Turtle> actives){
		SceneUpdater u = myModel.parse(s, actives);
		interpret(u);
	}
	
	private void interpret(SceneUpdater u) {
		if(!u.isNoError()) {
    	    myView.makeErrorDialog(u.getErrorMessage()).show();
    	    return;
    	}
        u.getVariables();
    	myTurtleWindow.update(u.getTurtles());
    	myTurtleInformation.update(u.getTurtles());
	}

	@Override
	public void update(Observable o, Object arg) {
		executeCommand((String)arg, myTurtleWindow.getActiveTurtles());
		
	}

}
