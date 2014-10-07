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
    private List<String> myContent;
    private UserCommands myComboBox;
        
    public HistoryBox(UserCommands myCombo, String promptText) {
        this.setPrefSize(SIZE.width, SIZE.height);
        this.setWrapText(true);
        this.setPromptText(promptText);
        myContent = new ArrayList<String>();
        myComboBox = myCombo;
    }

    @Override
    public void update(Observable button, Object instruction) {
        this.appendText(instruction + "\n\n");
        myComboBox.addCommand(instruction);
    }
}
