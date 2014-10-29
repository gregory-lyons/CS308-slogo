package FrontEnd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import com.sun.javafx.scene.control.skin.LabeledText;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

/**
 * Stores a list of commands that the user created. These commands can be clicked to be re-run.
 * @author Rica
 *
 */
public class LanguageSelector {   
    private ObservableList<Node> myRootChildren;
    private ComboBox<String> myComboBox;
    private List<Node> leaves = new ArrayList<Node>();

    private String chosenLanguage;

    /**
     * Constructs language selector which includes combo box and has access to the borderpane root
     * @param buttonWidth
     * @param myRoot
     */
    public LanguageSelector(BorderPane myRoot) {
        //this.myRoot = myRoot;
        myRootChildren = myRoot.getChildren();
        myComboBox = new ComboBox<String>();
        myComboBox.setMaxWidth(View.LANGUAGESELECTOR_CB_WIDTH);
        myComboBox.getItems().addAll(Translator.myLanguageOrder);
        myComboBox.setValue(DefaultStrings.ENGLISH);
        myComboBox.setOnAction(event -> handle());
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
        chosenLanguage = myComboBox.getValue().toString();

        // populates leaves
        for (Node each : myRootChildren) {
            rootChildren(each);
        }
        
        for (Node leaf : leaves) {
            if (leaf.getClass().equals(Text.class)) {
                Text myLeaf = (Text) leaf;
                myLeaf.textProperty().unbind();
                String translation = Translator.translateDirect(myLeaf.getText(), chosenLanguage);
                myLeaf.setText(translation);
            }
            else if (leaf.getClass().equals(LabeledText.class)) {
                LabeledText myLeaf = (LabeledText) leaf;
                myLeaf.textProperty().unbind();
                String translation = Translator.translateDirect(myLeaf.getText(), chosenLanguage);
                myLeaf.setText(translation);
            }
        }
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
    public ComboBox<String> getComboBox () {
        return myComboBox;
    }
    
    public String getCurrentLanguage() {
        return myComboBox.getValue();
    }
}
