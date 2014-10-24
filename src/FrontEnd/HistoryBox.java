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
public class HistoryBox extends TextArea {
    private static final Dimension SIZE = new Dimension(400, 600);
    private UserCommands myComboBox;

    /**
     * Constructs a history box of preferred size and wrap text with prompt text
     * Also has combo box so that it can update with new instructions
     * @param myCombo
     * @param promptText
     */
    public HistoryBox(UserCommands myCombo, String promptText) {
        this.setPrefSize(SIZE.width, SIZE.height);
        this.setWrapText(true);
        this.setPromptText(promptText);
        myComboBox = myCombo;
    }

    public void addEntry(String instruction) {
        this.appendText(instruction + "\n\n");
        myComboBox.addCommand(instruction);
    }
}
