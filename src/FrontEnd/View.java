package FrontEnd;


import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * The View mainly has private classes to initialize the View. If you need to change aspects of the View, 
 * use the classes that it stores such as CommandControl, Turtle, CommandLine, and TurtleWindow.
 * @author Rica, Greg
 *
 */
public class View {
    
    /**
     * Constructs a view in the proper language
     * @param language
     */
    public View(String language) {
        
     }

    /**
     * For the main class to access the screen in order to initialize the window
     * @return the Scene
     */
    public Scene getScene () {
        return null;
    }

}
