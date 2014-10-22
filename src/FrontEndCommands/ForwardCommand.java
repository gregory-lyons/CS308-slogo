package FrontEndCommands;

import FrontEnd.CommandLine;
import FrontEnd.HistoryBox;

public class ForwardCommand extends SuperCommand{

	public static final int DEFAULT_FORWARD = 5;
	
	public ForwardCommand(CommandLine myLine, HistoryBox myHistory, String label, String language) {
		super(myLine, myHistory, label, language);
		//System.out.println("Forward label: " + myLabel);
		myInstruction = myLabel.toUpperCase() + DEFAULT_FORWARD;
	}
}
