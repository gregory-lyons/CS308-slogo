package TurtleCommands;

import FrontEnd.CommandLine;
import FrontEnd.HistoryBox;

public class ClearCommand extends SuperCommand {

	public ClearCommand(CommandLine myLine, HistoryBox myHistory, String label) {
		super(myLine, myHistory);
		myInstruction = "CS";
		myLabel = label;
		myButton.setText(myLabel);
	}

}
