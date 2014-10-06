package CommandButtons;

import FrontEnd.CommandLine;
import FrontEnd.HistoryBox;

public class BackCommand extends SuperCommand{
	
	public static final int DEFAULT_BACK = 5;

	public BackCommand(CommandLine myLine, HistoryBox myHistory) {
		super(myLine, myHistory);
		myInstruction = "BK " + DEFAULT_BACK;
		myLabel = "BACK";
		myButton.setText(myLabel);
	}

}
