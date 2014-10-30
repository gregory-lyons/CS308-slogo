// This entire file is part of my masterpiece.
// YOUR NAME
package FrontEnd;

import java.util.ArrayList;
import java.util.List;
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

    /**
     * Constructs language selector which includes combo box and has access to the borderpane root
     * @param buttonWidth
     * @param myRoot
     */
    public LanguageSelector(BorderPane myRoot) {
        myRootChildren = myRoot.getChildren();
        myComboBox = new ComboBox<String>();
        myComboBox.setMaxWidth(View.LANGUAGESELECTOR_CB_WIDTH);
        myComboBox.getItems().addAll(Translator.myLanguageOrder);
        myComboBox.setValue(DefaultStrings.ENGLISH);
        myComboBox.setOnAction(event -> handle());
    }
    
    /**
     * Gets all the leaf nodes of the children and stores it in the list of leaves. By calling
     * the recursive rootChildren method. Translates each of the leaf text nodes in the leaf list
     * into the selected language by calling the translate method in the translator class.
     */
    private void handle () {
        String chosenLanguage = myComboBox.getValue().toString();

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
     * @param a node in the tree
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
     * Allows the view to get the Language Selector ComboBox to add to the display
     * @return Returns language selector combo box to add to view
     */
    public ComboBox<String> getComboBox () {
        return myComboBox;
    }
    
    /**
     * Allows parties to get the current language that the program is displaying
     * @return current language that program displays
     */
    public String getCurrentLanguage() {
        return myComboBox.getValue();
    }
}
