package FrontEnd;

import javafx.scene.control.TextArea;

/**
 * Stores the history of commands
 * @author Rica
 *
 */
public class HistoryBox extends TextArea {
    private UserCommands myComboBox;

    /**
     * Constructs a history box of preferred size and wrap text with prompt text
     * Also has combo box so that it can update with new instructions
     * @param myCombo
     * @param promptText
     */
    public HistoryBox(UserCommands myCombo, String promptText) {
        this.setPrefSize(View.HISTORY_BOX_WIDTH, View.HISTORY_BOX_HEIGHT);
        this.setWrapText(true);
        this.setPromptText(promptText);
        myComboBox = myCombo;
    }

    public void addEntry(String instruction) {
        this.appendText(instruction + "\n");
        myComboBox.addCommand(instruction);
    }
}
