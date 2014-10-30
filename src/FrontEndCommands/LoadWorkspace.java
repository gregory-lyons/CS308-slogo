package FrontEndCommands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javafx.scene.control.Button;
import FrontEnd.DefaultStrings;
import FrontEnd.View;

/**
 * Allows users to set, save, and load workspace preferences (like default background, starting 
 * image list, starting number of turtles, starting file to load, command language, etc.)
 * @author Rica
 *
 */
public class LoadWorkspace {
    private Button myButton;
    private String myLanguage;
    private View myView;
    private String myBackgroundColor;
    private File selectedFile;
    private int myNumberTurtles;
    private static final String CURRENT_DIRECTORY = "user.home";
    
    public LoadWorkspace(View myView) {
        this.myView = myView;
        myButton = new Button(DefaultStrings.LOAD_WORKSPACE);
        myButton.setMinWidth(View.SIDEBAR_BUTTON_WIDTH);
        myButton.setOnMouseClicked(event -> handle());
    }

    private void handle () {
        JFrame parentFrame = new JFrame();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty(CURRENT_DIRECTORY)));
        int result = fileChooser.showOpenDialog(parentFrame);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        }
        getSettingsFromFile();
    }
    
    private void getSettingsFromFile () {

        try {
                Scanner in = new Scanner(selectedFile);
                myLanguage = in.next();
                myBackgroundColor = in.next();
                myNumberTurtles = Integer.valueOf(in.next());
                in.close();

            myView.getLanguageSelector().getComboBox().setValue(myLanguage);
            myView.getLanguageSelector().getComboBox().arm();
            
            for(int i = 0; i < myNumberTurtles; i++) {
                myView.getAddTurtleButton().fire();

            }
            
            //myTurtleImageBox = myView.getMyTurtleImageBox();
            //myTurtleImageBox.getItems().add("‪C:\\Users\\Rica\\Desktop\\springcakes8.jpg");
            //myTurtleImageBox.getItems().add("‪C:\\Users\\Rica\\Desktop\\berry6.jpg");
            //myTurtleImageBox.getItems().add("‪C:\\Users\\Rica\\Desktop\\pudding4.jpg");            
            
            myView.getMyBackgroundColorBox().setValue(myBackgroundColor);
            myView.getMyBackgroundColorBox().arm();

        }
        catch (FileNotFoundException f) {
            myView.makeErrorDialog("Could not find resource bundle for load workspace", selectedFile.getAbsolutePath());
        }
        catch (Exception e) {
            myView.makeErrorDialog("File improperly formatted", selectedFile.getAbsolutePath());
            handle();
        }

    }

    public Button getButton() {
        return myButton;
    }
}