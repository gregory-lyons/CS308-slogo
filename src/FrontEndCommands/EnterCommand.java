package FrontEndCommands;

import FrontEnd.CommandLine;
import FrontEnd.View;

/**
 * Sends the text to the parser, clears command line
 * @author Rica
 *
 */
public class EnterCommand extends SuperCommand {
    private CommandLine myCommandLine;
	
    public EnterCommand(CommandLine myLine, String label, String language) {
        super(myLine, label, language);
        myButton.setPrefSize(View.ENTERCLEAR_BUTTON_WIDTH, View.PUFFY_BUTTON_HEIGHT);
        myCommandLine = myLine;
        addObserver(myCommandLine);
    }
	
    public void setMyCommandLine(String s) {
	myCommandLine.setText(s);
    }
	
    @Override
    protected void handle() {
        this.setChanged();
        String myInstruction = myCommandLine.getText();
        notifyObservers(myInstruction);
    }
}
