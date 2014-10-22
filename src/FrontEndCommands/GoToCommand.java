package FrontEndCommands;

import FrontEnd.CommandLine;
import FrontEnd.HistoryBox;

public class GoToCommand extends SuperCommand {

	public static final int DEFAULT_X = 0;
	public static final int DEFAULT_Y = 0;
	
	public GoToCommand(CommandLine myLine, HistoryBox myHistory, String label, String language) {
		super(myLine, myHistory, label, language);
		myInstruction = myLabel.toUpperCase() + DEFAULT_X + " " + DEFAULT_Y;
	}

}
