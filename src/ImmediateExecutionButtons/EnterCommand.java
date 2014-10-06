package ImmediateExecutionButtons;

import FrontEnd.CommandLine;
import FrontEnd.HistoryBox;

/**
 * Sends the text to the parser, clears command line
 * @author Rica
 *
 */
public class EnterCommand extends SuperCommand {
    private CommandLine myCommandLine;
	
    public EnterCommand(CommandLine myLine, HistoryBox myHistory) {
        super(myLine, myHistory);
        myCommandLine = myLine;
	myLabel = "ENTER";
	myButton.setText(myLabel); 
    }
	
    public void setMyCommandLine(String s) {
	myCommandLine.setText(s);
    }
	
    @Override
    protected void handle() {
        this.setChanged();
        myInstruction = myCommandLine.getText();
        notifyObservers(myInstruction);
    }
}
