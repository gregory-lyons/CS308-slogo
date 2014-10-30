package FrontEndCommands;

import java.util.Observable;
import javafx.scene.control.Button;
import FrontEnd.CommandLine;
import FrontEnd.DefaultStrings;
import FrontEnd.View;

/**
 * Sends the text to the parser, clears command line
 * @author Rica
 *
 */
public class EnterButton extends Observable {
    String myLabel;
    private Button myButton;
    private CommandLine myCommandLine;
	
    public EnterButton(CommandLine myLine) {
        myButton = new Button();
        myLabel = DefaultStrings.ENTER;
        myButton.setText(myLabel);
        myButton.setOnAction(event -> handle());
        myButton.setPrefSize(View.ENTERCLEAR_BUTTON_WIDTH, View.PUFFY_BUTTON_HEIGHT);
        myCommandLine = myLine;
        addObserver(myCommandLine);
    }
	
    public void setMyCommandLine(String s) {
	myCommandLine.setText(s);
    }
	
    protected void handle() {
        change();
        String myInstruction = myCommandLine.getText();
        notifyObservers(myInstruction);
    }

    public Button getButton () {
        return myButton;
    }

    public void change () {
        this.setChanged();
        
    }
}