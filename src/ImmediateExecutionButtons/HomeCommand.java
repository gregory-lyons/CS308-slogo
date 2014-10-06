package ImmediateExecutionButtons;

import FrontEnd.CommandLine;
import FrontEnd.HistoryBox;

public class HomeCommand extends SuperCommand {

	public HomeCommand(CommandLine myLine, HistoryBox myHistory, String label) {
		super(myLine, myHistory);
		myInstruction = "HOME";
		myLabel = label;
		myButton.setText(myLabel);
	}

}
