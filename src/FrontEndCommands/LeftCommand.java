package FrontEndCommands;

import FrontEnd.CommandLine;
import FrontEnd.HistoryBox;

public class LeftCommand extends SuperCommand {

	public static final double DEFAULT_LEFT = 270.0;
	
	public LeftCommand(CommandLine myLine, HistoryBox myHistory, String label) {
		super(myLine, myHistory);
		myInstruction = "LT "+ DEFAULT_LEFT;
		myLabel = label;
		myButton.setText(myLabel);
	}

}
