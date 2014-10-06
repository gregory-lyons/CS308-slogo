package CommandButtons;

import FrontEnd.CommandLine;
import FrontEnd.HistoryBox;

public class LeftCommand extends SuperCommand {

	public static final double DEFAULT_LEFT = 270.0;
	
	public LeftCommand(CommandLine myLine, HistoryBox myHistory) {
		super(myLine, myHistory);
		myInstruction = "LT "+ DEFAULT_LEFT;
		myLabel = "LEFT";
		myButton.setText(myLabel);
	}

}
