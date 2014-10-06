package CommandButtons;

import FrontEnd.CommandLine;
import FrontEnd.HistoryBox;

public class HomeCommand extends SuperCommand {

	public HomeCommand(CommandLine myLine, HistoryBox myHistory) {
		super(myLine, myHistory);
		myInstruction = "HOME";
		myLabel = "HOME";
		myButton.setText(myLabel);
	}

}
