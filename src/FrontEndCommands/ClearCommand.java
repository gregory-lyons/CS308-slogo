package FrontEndCommands;

import FrontEnd.CommandLine;
import FrontEnd.HistoryBox;

public class ClearCommand extends SuperCommand {

	public ClearCommand(CommandLine myLine, HistoryBox myHistory, String label, String language) {
		super(myLine, myHistory, label, language);
		myInstruction = myLabel.toUpperCase();
	}

}
