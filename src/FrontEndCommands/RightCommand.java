package FrontEndCommands;

import FrontEnd.CommandLine;
import FrontEnd.HistoryBox;

public class RightCommand extends SuperCommand{

	public static final double DEFAULT_RIGHT = 90.0;
	
	public RightCommand(CommandLine myLine, HistoryBox myHistory, String label, String language) {
		super(myLine, myHistory, label, language);
		myInstruction = myLabel.toUpperCase() + DEFAULT_RIGHT;
	}

}
