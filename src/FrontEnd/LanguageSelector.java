package FrontEnd;


import java.util.ArrayList;
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
    private BorderPane myRoot;
    private ObservableList<Node> myRootChildren;
    private static final String DEFAULT_TEXT = "Select a Language";
    private ComboBox myComboBox;
    private Button myButton;
    private static final int myButtonWidth = 20;
    private List<Node> englishLeaves = new ArrayList<Node>();
    private List<Node> leavesToTranslate = new ArrayList<Node>();
    private ResourceBundle myResources;
    private ResourceBundle myEnglishResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");

    
    public LanguageSelector(int buttonWidth, BorderPane myRoot) {     
        this.myRoot = myRoot;
        myRootChildren = myRoot.getChildren();
        myComboBox = new ComboBox();
        myComboBox.setMaxWidth(buttonWidth);
        myComboBox.setPromptText(DEFAULT_TEXT);
        myComboBox.getItems().addAll("English", "Chinese", "French", "Italian", "Portuguese", "Russian");
        myButton = new Button("Go");
        myButton.setOnMouseClicked(event -> handle());
    }
    
    private void handle () {
        String language = myComboBox.getValue().toString();
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
        // populates englishLeaves
        for (Node each : myRootChildren) {
            rootChildren(each);
        }
        // populates leavesToTranslate
        for (Node each : myRootChildren) {
            translateRootChildren(each);
        }
        System.out.println(englishLeaves.size());
        System.out.println(leavesToTranslate.size());

        
        for (int i = 0; i < leavesToTranslate.size(); i++) {
            Node englishLeaf = englishLeaves.get(i);
            Node leafToTranslate = leavesToTranslate.get(i);
            if (leafToTranslate.getClass().equals(Text.class)) {
                Text engLeaf = (Text) englishLeaf;
                Text leaf2Translate = (Text) leafToTranslate;
                leaf2Translate.textProperty().unbind();
                String translation = translate(engLeaf.getText());
                leaf2Translate.setText(translation);
                //textLeaf.textProperty().bind();
            }
            else if (leafToTranslate.getClass().equals(LabeledText.class)) {
                LabeledText engLeaf = (LabeledText) englishLeaf;
                LabeledText leaf2Translate = (LabeledText) leafToTranslate;
                leaf2Translate.textProperty().unbind();
                String translation = translate(engLeaf.getText());
                leaf2Translate.setText(translation);
                //textLeaf.textProperty().bind();
            }
        }
        
        System.out.println(myComboBox.getValue());
    }
    
    private String translate(String engButton) {
        String myKey = "";
        for (String key : myEnglishResources.keySet()) {
            if (myEnglishResources.getString(key).equals(engButton)) {
                myKey = key;
            }
        }
        if (myResources.keySet().contains(myKey)) {
            System.out.println("String to translate: " + myKey);
            return myResources.getString(myKey);
        }
        System.out.println("Could not translate: " + myKey);
        return engButton;
    }
    
    private ObservableList<Node> rootChildren(Node n) {
        if (!(n instanceof Parent)) {
            englishLeaves.add(n);
            return null;
        }
        Parent pn = (Parent) n;
        ObservableList<Node> pnChildren = pn.getChildrenUnmodifiable();
        for (Node each : pnChildren) {
            rootChildren(each);
        }
        return pnChildren;
    }
    
    private ObservableList<Node> translateRootChildren(Node n) {
        if (!(n instanceof Parent)) {
            leavesToTranslate.add(n);
            return null;
        }
        Parent pn = (Parent) n;
        ObservableList<Node> pnChildren = pn.getChildrenUnmodifiable();
        for (Node each : pnChildren) {
            translateRootChildren(each);
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
