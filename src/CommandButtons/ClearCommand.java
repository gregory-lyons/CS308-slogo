package CommandButtons;

import FrontEnd.CommandLine;
import FrontEnd.HistoryBox;

public class ClearCommand extends SuperCommand {

	public ClearCommand(CommandLine myLine, HistoryBox myHistory) {
		super(myLine, myHistory);
		myInstruction = "CS";
		myLabel = "CLEARSCREEN";
		myButton.setText(myLabel);
	}

}
