package FrontEnd;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import com.sun.javafx.scene.control.skin.LabeledText;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

/**
 * Stores a list of commands that the user created. These commands can be clicked to be re-run.
 * @author Rica
 *
 */
public class LanguageSelector {
    public static final String DEFAULT_RESOURCE_PACKAGE = "resources.languages/";
    private static final String DEFAULT_TEXT = "Select a Language";
    private ResourceBundle myLanguages = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "Languages");
    
    private BorderPane myRoot;
    private ObservableList<Node> myRootChildren;
    private ComboBox myComboBox;
    private Button myButton;
    private List<Node> leaves = new ArrayList<Node>();
    private int languageNum;

    public LanguageSelector(int buttonWidth, BorderPane myRoot) {
        //createLanguagesFile();
        this.myRoot = myRoot;
        myRootChildren = myRoot.getChildren();
        myComboBox = new ComboBox();
        myComboBox.setMaxWidth(buttonWidth);
        myComboBox.setPromptText(DEFAULT_TEXT);
        myComboBox.getItems().addAll("English", "Chinese", "French", "Italian", "Portuguese", "Russian");
        myButton = new Button("Go");
        myButton.setMinWidth(buttonWidth/2);
        myButton.setOnMouseClicked(event -> handle());
    }
    
    /*
    public void createLanguagesFile() {
        try {
            PrintWriter output;
                output = new PrintWriter("C:\\Users\\Rica\\Desktop\\myfile.txt");
                
            ResourceBundle eng = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");
            ResourceBundle chn = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "Chinese");
            ResourceBundle frn = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "French");
            ResourceBundle ita = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "Italian");
            ResourceBundle por = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "Portuguese");
            ResourceBundle rus = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "Russian");
            for (String key : eng.keySet()) {
                String x = "__";
                output.println(key + " = " +  eng.getString(key) + x + chn.getString(key) + x + frn.getString(key) + x + ita.getString(key) + x + por.getString(key) + x + rus.getString(key));
            }
            output.close();            
        }
        catch (FileNotFoundException f){
            f.printStackTrace();
        }
    }
    */
    
    private void handle () {
        String chosenLanguage = myComboBox.getValue().toString();
        if (chosenLanguage.equals("English")) { languageNum = 0; }
        else if (chosenLanguage.equals("Chinese")) { languageNum = 1; }
        else if (chosenLanguage.equals("French")) { languageNum = 2; }
        else if (chosenLanguage.equals("Italian")) { languageNum = 3; }
        else if (chosenLanguage.equals("Portuguese")) { languageNum = 4; }
        else if (chosenLanguage.equals("Russian")) { languageNum = 5; }

        // populates leaves
        for (Node each : myRootChildren) {
            rootChildren(each);
        }
        
        for (Node leaf : leaves) {
            if (leaf.getClass().equals(Text.class)) {
                Text myLeaf = (Text) leaf;
                myLeaf.textProperty().unbind();
                String translation = translate(myLeaf.getText());
                myLeaf.setText(translation);
                //textLeaf.textProperty().bind();
            }
            else if (leaf.getClass().equals(LabeledText.class)) {
                LabeledText myLeaf = (LabeledText) leaf;
                myLeaf.textProperty().unbind();
                String translation = translate(myLeaf.getText());
                myLeaf.setText(translation);
                //textLeaf.textProperty().bind();
            }
        }
    }
    
    private String translate(String currentText) {
        String myKey;
        for (String key : myLanguages.keySet()) {
            List<String> myLanguageList = Arrays.asList(myLanguages.getString(key).split("__"));
            if (myLanguageList.contains(currentText)) {
                return myLanguageList.get(languageNum);
            }
        }
        return currentText;
    }
    
    private ObservableList<Node> rootChildren(Node n) {
        if (!(n instanceof Parent)) {
            leaves.add(n);
            return null;
        }
        Parent pn = (Parent) n;
        ObservableList<Node> pnChildren = pn.getChildrenUnmodifiable();
        for (Node each : pnChildren) {
            rootChildren(each);
        }
        return pnChildren;
    }

    public ComboBox getComboBox () {
        return myComboBox;
    }

    public Button getButton () {
        return myButton;
    }
}
