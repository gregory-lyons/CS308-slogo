package FrontEnd;

import TurtleView.TurtleInformation;
import TurtleView.TurtleWindow;
import Backend.Model;
import Backend.SceneUpdater;

public class Controller {
	
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
	
	public void executeCommand(String s, boolean penState){
		SceneUpdater u = myModel.parse(s, penState);
		interpret(u);
	}
	
	private void interpret(SceneUpdater u) {
		if(!u.isNoError()) {
    	    myView.makeErrorDialog(u.getErrorMessage()).show();
    	    return;
    	}
        u.getVariables();
    	myTurtleWindow.update(u.getLocation(), u.getAngle(), u.penIsDown());
    	myTurtleInformation.update(u.getLocation(), u.getAngle());
	}

}
