package CommandButtons;

import FrontEnd.CommandLine;

public class ForwardCommand extends SuperCommand{

	public static final int DEFAULT_FORWARD = 5;
	
	public ForwardCommand(CommandLine myLine) {
		super(myLine, null);
		myInstruction = "FD " + DEFAULT_FORWARD;
		myLabel = "FORWARD";
	}

}
