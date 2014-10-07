package FrontEnd;

import java.util.Observable;
import java.util.Observer;

import Backend.Model;
import Backend.SceneUpdater;
import TurtleCommands.EnterCommand;

public class Controller implements Observer {
	
	Model myModel;
	View myView;
	
    public Controller(View v, Model m) {
    	myModel = m;
    	myView = v;
    }

    @Override
    public void update (Observable o, Object instruction) {
          // SceneUpdater updater = myModel.updateBackEnd((String)instruction);
         //  myView.updateFrontEnd(updater);
            
           
        
    }

}
