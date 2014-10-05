package CommandButtons;

import FrontEnd.CommandLine;

public class EnterCommand extends SuperCommand {

	public EnterCommand(CommandLine myLine) {
		super(myLine, null);
		myInstruction = myLine.getText();
		myLabel = "ENTER";
	}

}
