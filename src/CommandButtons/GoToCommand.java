package CommandButtons;

import FrontEnd.CommandLine;
import FrontEnd.HistoryBox;

public class GoToCommand extends SuperCommand {

	public static final int DEFAULT_X = 0;
	public static final int DEFAULT_Y = 0;
	
	public GoToCommand(CommandLine myLine, HistoryBox myHistory) {
		super(myLine, myHistory);
		myInstruction = "GOTO " + DEFAULT_X + " " + DEFAULT_Y;
		myLabel = "SET X Y";
		myButton.setText(myLabel);
	}

}
