package FrontEndCommands;

import FrontEnd.CommandLine;
import FrontEnd.Console;
import FrontEnd.HistoryBox;

public class ClearCommand extends SuperCommand {

	public ClearCommand(CommandLine myLine, String label, String language) {
		super(myLine, label, language);
		myInstruction = myLabel.toUpperCase();
	}

}
