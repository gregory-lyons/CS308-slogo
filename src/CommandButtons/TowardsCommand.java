package CommandButtons;

import FrontEnd.CommandLine;
import FrontEnd.HistoryBox;

public class TowardsCommand extends SuperCommand {

	public static final int DEFAULT_X = 0;
	public static final int DEFAULT_Y = 0;
	
	public TowardsCommand(CommandLine myLine, HistoryBox myHistory) {
		super(myLine, myHistory);
		myInstruction = "TOWARDS "+ DEFAULT_X + " " + DEFAULT_Y;
		myLabel = "TOWARDS X Y";
		myButton.setText(myLabel);
	}

}
