package FrontEnd;

import java.util.Observable;
import java.util.Observer;
import FrontEndCommands.EnterCommand;
import FrontEndCommands.SuperCommand;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * CommandLine is the user interface for typing in commands. When the Enter button is pushed, it is updated.
 * @author Rica
 *
 */
public class CommandLine extends TextArea implements Observer {    
    /**
     * Constructs command line of preferred size with wrap text and prompt Text.
     * @param promptText
     */
    public CommandLine(String promptText, HistoryBox h) {
        this.setPrefSize(ViewConstants.COMMANDLINE_WIDTH, ViewConstants.COMMANDLINE_HEIGHT);
        this.setWrapText(true);
        this.setPromptText(promptText);
        this.setOnKeyPressed(event -> handle(event, h));
    }

    private void handle (KeyEvent event, HistoryBox h) {
        if (event.getCode() == KeyCode.UP) {
            this.setText("");
            this.appendText(h.getMostRecentCommand());
            this.requestFocus();
        }
    }

    /**
     * When a button is pushed, new text representing the command is added to the command line
     */
    public void update(Observable button, Object commandText) {
        SuperCommand command = (SuperCommand) button;
        if (command instanceof EnterCommand) {
            this.clear();
        }
    }
}
