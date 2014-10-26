package FrontEndCommands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
public class SaveWorkspace {
    private Button myButton;
    private List<File> myImages = new ArrayList<File>();
    private View myView;
    private File workspaceSettings;
    
    public SaveWorkspace(View myView) {
        this.myView = myView;
        myButton = new Button(DefaultStrings.SAVE_WORKSPACE);
        myButton.setMinWidth(View.SIDEBAR_BUTTON_WIDTH);
        myButton.setOnMouseClicked(event -> handle());
    }

    private void handle () {
        File dir = new File("src\\TurtleView\\images");
        System.out.println(dir.getAbsolutePath());
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                myImages.add(child);
                //System.out.println(child.getAbsolutePath());
            }
        }
        chooseFile();
        writeSettingsToFile();
    }
    
    private void chooseFile() {
        JFrame parentFrame = new JFrame();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose location to save workspace preferences");   
        int userSelection = fileChooser.showSaveDialog(parentFrame);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            workspaceSettings = new File(fileChooser.getSelectedFile().getAbsolutePath() + ".properties");
            System.out.println("Save as file: " + workspaceSettings.getAbsolutePath());
        }
    }
    
    private void writeSettingsToFile () {
        try {
            PrintWriter pw = new PrintWriter(workspaceSettings);
            String myLanguage = myView.getLanguageSelector().getCurrentLanguage();
            pw.println(myLanguage);
            String myBackgroundColor = myView.getMyBackgroundColorBox().getValue();
            pw.println(myBackgroundColor);
            int myNumberOfTurtles = myView.getTurtleWindow().getAllTurtles().size();
            pw.println(myNumberOfTurtles);
            pw.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("This file was not found.");
        }        
    }

    public Button getButton() {
        return myButton;
    }
}