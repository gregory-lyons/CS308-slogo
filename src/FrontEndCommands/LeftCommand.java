package FrontEndCommands;

import FrontEnd.CommandLine;
import FrontEnd.HistoryBox;

public class LeftCommand extends SuperCommand {

	public static final double DEFAULT_LEFT = 270.0;
	
	public LeftCommand(CommandLine myLine, HistoryBox myHistory, String label, String language) {
		super(myLine, myHistory, label, language);
		myInstruction = myLabel.toUpperCase();
	}

}
