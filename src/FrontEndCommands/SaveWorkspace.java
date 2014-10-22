package FrontEndCommands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import FrontEnd.DefaultStrings;
import FrontEnd.LanguageSelector;
import FrontEnd.View;

/**
 * Allows users to set, save, and load workspace preferences (like default background, starting 
 * image list, starting number of turtles, starting file to load, command language, etc.)
 * @author Rica
 *
 */
public class SaveWorkspace {
    private Button myButton;
    private List<File> myImages = new ArrayList<File>();
    private String myLanguage;
    private View myView;
    private String myBackgroundColor;
    
    public SaveWorkspace(int buttonWidth, View myView) {
        this.myView = myView;
        myButton = new Button(DefaultStrings.SAVE_WORKSPACE);
        myButton.setMinWidth(buttonWidth/2);
        myButton.setOnMouseClicked(event -> handle());
    }

    private void handle () {
        myLanguage = myView.getLanguageSelector().getCurrentLanguage();
        //System.out.println(myLanguage);
        File dir = new File("src\\TurtleView\\images");
        System.out.println(dir.getAbsolutePath());
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                myImages.add(child);
                //System.out.println(child.getAbsolutePath());
            }
        }
        myBackgroundColor = myView.getMyBackgroundColorBox().getValue();
        writeSettingsToFile();
    }
    
    private void writeSettingsToFile () {
        JFrame parentFrame = new JFrame();
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify location to save workspace preferences");   
         
        int userSelection = fileChooser.showSaveDialog(parentFrame);
        
        File workspaceSettings = new File("workspace_settings.json");
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            workspaceSettings = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + workspaceSettings.getAbsolutePath());
        }
        try {
            PrintWriter pw = new PrintWriter(workspaceSettings);
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //JSONWriter myJSONWriter = new JSONWriter(pw);
        
    }

    public Button getButton() {
        return myButton;
    }
}