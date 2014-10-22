package FrontEndCommands;

import FrontEnd.CommandLine;
import FrontEnd.HistoryBox;

public class HomeCommand extends SuperCommand {

	public HomeCommand(CommandLine myLine, HistoryBox myHistory, String label, String language) {
		super(myLine, myHistory, label, language);
		myInstruction = myLabel.toUpperCase();
	}

}
