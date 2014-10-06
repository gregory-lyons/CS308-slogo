package FrontEnd;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import ImmediateExecutionButtons.EnterCommand;
import ImmediateExecutionButtons.SuperCommand;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * For now it is a simple TextArea. This is a separate class so that new features can easily be added.
 * For this particular implementation, it doesn't need any additional methods because TextArea covers all
 * the methods currently needed.
 * @author Rica, Greg
 *
 */
public class CommandLine extends TextArea implements Observer {
    private static final Dimension SIZE = new Dimension(400, 150);
    private static final String PROMPT_TEXT = "Write out some commands for the turtle here...";
    //EnterCommand myEnterButton;
    
    public CommandLine() {
        this.setPrefSize(SIZE.width, SIZE.height);
        this.setWrapText(true);
        this.setPromptText(PROMPT_TEXT);
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
