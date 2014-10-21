package FrontEnd;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;
import com.sun.javafx.scene.control.skin.LabeledText;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

/**
 * Stores a list of commands that the user created. These commands can be clicked to be re-run.
 * @author Rica
 *
 */
public class LanguageSelector {
    private static final String DEFAULT_TEXT = "Select a Language";
    private ResourceBundle myLanguages = ResourceBundle.getBundle(DefaultStrings.DEFAULT_RESOURCE_PACKAGE);
    
    private BorderPane myRoot;
    private ObservableList<Node> myRootChildren;
    private ComboBox myComboBox;
    private Button myButton;
    private List<Node> leaves = new ArrayList<Node>();
    private int languageNum;

    /**
     * Constructs language selector which includes combo box and has access to the borderpane root
     * @param buttonWidth
     * @param myRoot
     */
    public LanguageSelector(int buttonWidth, BorderPane myRoot) {
        this.myRoot = myRoot;
        myRootChildren = myRoot.getChildren();
        myComboBox = new ComboBox();
        myComboBox.setMaxWidth(buttonWidth);
        myComboBox.getItems().addAll(StringChooser.myLanguageOrder);
        myComboBox.setValue(DefaultStrings.ENGLISH);
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
    /*
    public void createLanguageKeys() {
        ResourceBundle myResources = ResourceBundle.getBundle("resources.languages/Languages");
        Enumeration<String> myLanguageKeys = myResources.getKeys();
        try {
            PrintWriter output;
            
            output = new PrintWriter("C:\\Users\\Rica\\Desktop\\mylanguagekeys.txt");
            while (myLanguageKeys.hasMoreElements()) {
                String current = myLanguageKeys.nextElement();
                output.println("public static final String " + current.toUpperCase() + " = \"" + current + "\";");
            }
            output.close();            
        }
        catch (FileNotFoundException f){
            f.printStackTrace();
        }

    }
    */
    
    /**
     * Gets all the leaf nodes of the children and stores it in the list leaves. Translates the leaf
     * into the selected language by calling the translate method.
     */
    private void handle () {
        String chosenLanguage = myComboBox.getValue().toString();
        languageNum = StringChooser.myLanguageOrder.indexOf(chosenLanguage);

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
    
    /**
     * Translates the text in the leaf node to the appropriate language and passes it back to the handle method.
     * @param currentText
     * @return
     */
    private String translate(String currentText) {
        for (String key : myLanguages.keySet()) {
            List<String> myLanguageList = Arrays.asList(myLanguages.getString(key).split("__"));
            if (myLanguageList.contains(currentText)) {
                return myLanguageList.get(languageNum);
            }
        }
        System.out.println(currentText + " not in dictionary");
        return currentText;
    }
    
    /**
     * Recursive method to construct the list of all leaf nodes
     * @param n
     * @return ObservableList<Node> of all leaves
     */
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

    /**
     * 
     * @return Returns language selector combo box
     */
    public ComboBox getComboBox () {
        return myComboBox;
    }

    /**
     * 
     * @return Returns GO button of combo box
     */
    public Button getButton () {
        return myButton;
    }
}
