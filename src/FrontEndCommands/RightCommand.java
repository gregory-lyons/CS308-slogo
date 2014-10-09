package FrontEndCommands;

import FrontEnd.CommandLine;
import FrontEnd.HistoryBox;

public class RightCommand extends SuperCommand{

	public static final double DEFAULT_RIGHT = 90.0;
	
	public RightCommand(CommandLine myLine, HistoryBox myHistory, String label) {
		super(myLine, myHistory);
		myInstruction = "RT " + DEFAULT_RIGHT;
		myLabel = label;
		myButton.setText(myLabel);
	}

}
