package CommandButtons;

import FrontEnd.CommandLine;
import FrontEnd.HistoryBox;

public class EnterCommand extends SuperCommand {

	private CommandLine myCommandLine;
	
	public EnterCommand(CommandLine myLine, HistoryBox myHistory) {
		super(myLine, myHistory);
		myCommandLine = myLine;
		myInstruction = myLine.getText();
		myLabel = "ENTER";
		myButton.setText(myLabel);
	}
	
	@Override
	protected void handle() {
		super.handle();
		myCommandLine.clear();
	}
	
	

}
