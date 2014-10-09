package FrontEndCommands;

import FrontEnd.CommandLine;
import FrontEnd.HistoryBox;

public class BackCommand extends SuperCommand{
	
	public static final int DEFAULT_BACK = 5;

	public BackCommand(CommandLine myLine, HistoryBox myHistory, String label) {
		super(myLine, myHistory);
		myInstruction = "BK " + DEFAULT_BACK;
		myLabel = label;
		myButton.setText(myLabel);
	}

}
