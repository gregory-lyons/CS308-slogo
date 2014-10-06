package ImmediateExecutionButtons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import FrontEnd.CommandLine;
import FrontEnd.HistoryBox;

public class EnterCommand extends SuperCommand {
	private CommandLine myCommandLine;
	
	public EnterCommand(CommandLine myLine, HistoryBox myHistory) {
		super(myLine, myHistory);
		myCommandLine = myLine;
		myInstruction = myLine.getText();
		myLabel = "ENTER";
		myButton.setText(myLabel); 
	}
	
	public void setMyCommandLine(String s) {
	    myCommandLine.setText(s);
	}
	
	@Override
	protected void handle() {
	        myInstruction = myCommandLine.getText();
		notifyObservers(myInstruction);
		myCommandLine.clear();
	}
	
	

}
