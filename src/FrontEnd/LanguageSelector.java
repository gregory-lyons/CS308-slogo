package FrontEnd;


import java.util.ArrayList;
import java.util.List;
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
    private BorderPane myRoot;
    private ObservableList<Node> myRootChildren;
    private static final String DEFAULT_TEXT = "Select a Language";
    private ComboBox myComboBox;
    private Button myButton;
    private static final int myButtonWidth = 20;
    private List<Node> leaves = new ArrayList<Node>();
    //private ObservableList<String> options = FXCollections.observableArrayList();
    
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
        for (Node each : myRootChildren) {
            rootChildren(each);
        }
        for (Node leaf : leaves) {
            if (leaf.getClass().equals(Text.class)) {
                Text textLeaf = (Text) leaf;
                textLeaf.textProperty().unbind();
                String myText = textLeaf.getText();
                textLeaf.setText("yay!");
                //textLeaf.textProperty().bind();
            }
        }
        System.out.println(myComboBox.getValue());
    }
    
    private ObservableList<Node> rootChildren(Node n) {
        if (!(n instanceof Parent)) {
            leaves.add(n);
            System.out.println(n);
            System.out.println(n.getClass());
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
