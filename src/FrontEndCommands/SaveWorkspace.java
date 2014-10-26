package FrontEndCommands;

//import org.json.*;
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
    private File workspaceSettings = new File("C:\\Users\\Rica\\Desktop\\blah.json");
    
    public SaveWorkspace(View myView) {
        this.myView = myView;
        myButton = new Button(DefaultStrings.SAVE_WORKSPACE);
        myButton.setMinWidth(View.SIDEBAR_BUTTON_WIDTH);
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
        chooseFile();
        writeSettingsToFile();
    }
    
    private void chooseFile() {
        JFrame parentFrame = new JFrame();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose location to save workspace preferences");   
        int userSelection = fileChooser.showSaveDialog(parentFrame);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            workspaceSettings = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + workspaceSettings.getAbsolutePath());
        }
    }
    
    private void writeSettingsToFile () {
        try {
            PrintWriter myPrintWriter = new PrintWriter(workspaceSettings);
            JSONWriter myJSONWriter = new JSONWriter(myPrintWriter);
            myJSONWriter.object()
                .key("Background Color")
                .value(myView.getMyBackgroundColorBox().getValue())
                .key("Turtle Images")
                .value(myView.getMyTurtleImageBox().getItems())
                .key("Language")
                .value(myView.getLanguageSelector().getComboBox().getValue())
            .endObject();
            myPrintWriter.print(myJSONWriter);
            myPrintWriter.close();
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    public Button getButton() {
        return myButton;
    }
}