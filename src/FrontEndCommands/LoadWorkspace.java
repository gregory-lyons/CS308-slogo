package FrontEndCommands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import FrontEnd.DefaultStrings;
import FrontEnd.LanguageSelector;
import FrontEnd.View;
import TurtleView.TurtleImageBox;

/**
 * Allows users to set, save, and load workspace preferences (like default background, starting 
 * image list, starting number of turtles, starting file to load, command language, etc.)
 * @author Rica
 *
 */
public class LoadWorkspace {
    private Button myButton;
    private List<File> myImages = new ArrayList<File>();
    private String myLanguage;
    private View myView;
    private String myBackgroundColor;
    private TurtleImageBox myTurtleImageBox;
    
    public LoadWorkspace(View myView) {
        this.myView = myView;
        myButton = new Button(DefaultStrings.LOAD_WORKSPACE);
        myButton.setMinWidth(View.SIDEBAR_BUTTON_WIDTH);
        myButton.setOnMouseClicked(event -> handle());
    }

    private void handle () {
        JFrame parentFrame = new JFrame();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(parentFrame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        }
        getSettingsFromFile();
    }
    
    private void getSettingsFromFile () {
        String testerLanguage = "Italian";
        myView.getLanguageSelector().getComboBox().setValue(testerLanguage);
        //myView.getLanguageSelector().fire();
        
        myTurtleImageBox = myView.getMyTurtleImageBox();
        myTurtleImageBox.getItems().add("‪C:\\Users\\Rica\\Desktop\\springcakes8.jpg");
        myTurtleImageBox.getItems().add("‪C:\\Users\\Rica\\Desktop\\berry6.jpg");
        myTurtleImageBox.getItems().add("‪C:\\Users\\Rica\\Desktop\\pudding4.jpg");
        
        
        myBackgroundColor = myView.getMyBackgroundColorBox().getValue();
    }

    public Button getButton() {
        return myButton;
    }
}