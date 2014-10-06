package FrontEnd;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

/**
 * Stores the history of commands
 * @author Rica
 *
 */
public class HistoryBox extends TextArea implements Observer {
    private static final Dimension SIZE = new Dimension(400, 150);
    private static final String DEFAULT_TEXT = "History of Commands";
    private List<String> myContent;
    private ComboBox myComboBox;
        
    public HistoryBox(ComboBox myCombo) {
        this.setPrefSize(SIZE.width, SIZE.height);
        this.setWrapText(true);
        this.setPromptText(DEFAULT_TEXT);
        myContent = new ArrayList<String>();
        myComboBox = myCombo;
    }

    @Override
    public void update(Observable button, Object instruction) {
        this.appendText(instruction + "\n");
        myComboBox.getItems().add((String) instruction);
    }
}
