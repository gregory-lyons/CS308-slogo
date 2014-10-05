package CommandButtons;

import FrontEnd.CommandLine;

public class BackCommand extends SuperCommand{
	
	public static final int DEFAULT_BACK = 5;

	public BackCommand(CommandLine myLine) {
		super(myLine, null);
		myInstruction = "BK " + DEFAULT_BACK;
		myLabel = "BACK";
	}

}
