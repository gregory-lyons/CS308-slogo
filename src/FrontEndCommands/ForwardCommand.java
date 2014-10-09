package FrontEndCommands;

import FrontEnd.CommandLine;
import FrontEnd.HistoryBox;

public class ForwardCommand extends SuperCommand{

	public static final int DEFAULT_FORWARD = 5;
	
	public ForwardCommand(CommandLine myLine, HistoryBox myHistory, String label) {
		super(myLine, myHistory);
		myInstruction = "FD " + DEFAULT_FORWARD;
		myLabel = label;
		myButton.setText(label);
	}

}
