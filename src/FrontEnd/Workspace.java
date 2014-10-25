package FrontEnd;
import javafx.stage.Stage;
import Backend.Model;
import FrontEnd.Controller;
import FrontEnd.View;


public class Workspace {

	public Workspace(Stage s) {
        Model myModel = new Model();
        View myView = new View();
        Controller myController = new Controller(myView, myModel);
        myView.addController(myController);
        s.setTitle("My Turtle Program!");
        s.setScene(myView.getScene());
        s.show();
	}

}
