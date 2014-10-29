package FrontEnd;

import java.util.Observable;
import java.util.Observer;
import FrontEndCommands.SuperCommand;
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
    public CommandLine(HistoryBox h) {
        this.setPrefSize(View.COMMANDLINE_WIDTH, View.COMMANDLINE_HEIGHT);
        this.setWrapText(true);
        this.setPromptText(Translator.translateWithKey(DefaultStrings.COMMANDLINEDEFAULT, View.DEFAULT_LANGUAGE));
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
        if (!(button instanceof SuperCommand))
            this.clear();
    }
}
