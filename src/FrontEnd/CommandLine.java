package FrontEnd;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import FrontEndCommands.EnterCommand;
import FrontEndCommands.SuperCommand;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * CommandLine is the user interface for typing in commands. When the Enter button is pushed, it is updated.
 * @author Rica
 *
 */
public class CommandLine extends TextArea implements Observer {
    private static final Dimension SIZE = new Dimension(400, 150);
    
    /**
     * Constructs command line of preferred size with wrap text and prompt Text.
     * @param promptText
     */
    public CommandLine(String promptText) {
        this.setPrefSize(SIZE.width, SIZE.height);
        this.setWrapText(true);
        this.setPromptText(promptText);
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
