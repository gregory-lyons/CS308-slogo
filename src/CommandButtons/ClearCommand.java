package CommandButtons;

import FrontEnd.CommandLine;

public class ClearCommand extends SuperCommand {

	public ClearCommand(CommandLine myLine) {
		super(myLine, null);
		myInstruction = "CS";
		myLabel = "CLEARSCREEN";
	}

}
