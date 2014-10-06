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
        Stage dialog = new Stage();
        LanguageSelector myLanguageSelector = new LanguageSelector(s, dialog);
        dialog.setTitle("Select Language for Turtles Program");
        dialog.setScene(myLanguageSelector.getScene());
        dialog.show();
    }
    
    /**
     * Starts everything
     */
    public static void main (String[] args) {
        launch(args);
    }

}
