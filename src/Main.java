import Backend.Model;
import FrontEnd.View;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class to start up the window and load the turtlewindow and set the model.
 * 
 * @author Rica
 */
public class Main extends Application {

    /**
     * Initializes a new window in a particular language, sets the title, sets the scene, and shows.
     */
    @Override
    public void start (Stage s) {   
        Model myModel = new Model();
        View myView = new View(myModel);
        s.setTitle("My Turtle Program!");
        s.setScene(myView.getScene());
        s.show();
    }
    
    /**
     * Starts everything
     */
    public static void main (String[] args) {
        launch(args);
    }

}
