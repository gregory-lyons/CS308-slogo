package FrontEndCommands;

import FrontEnd.CommandLine;
import FrontEnd.HistoryBox;
import FrontEnd.StringChooser;

public class BackCommand extends SuperCommand{
	
	public static final int DEFAULT_BACK = 5;

	public BackCommand(CommandLine myLine, HistoryBox myHistory, String label, String language) {
		super(myLine, myHistory, label, language);
	        myInstruction = myLabel.toUpperCase() + " " + DEFAULT_BACK;
	}

}
