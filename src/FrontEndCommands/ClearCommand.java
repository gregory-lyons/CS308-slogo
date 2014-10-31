package FrontEndCommands;

import FrontEnd.CommandLine;
import FrontEnd.DefaultStrings;
import FrontEnd.StringChooser;
import FrontEnd.View;
import FrontEnd.ViewConstants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ClearCommand extends Button {

	public ClearCommand(CommandLine myCL) {
		this.setText(StringChooser.getWordInLang(ViewConstants.DEFAULT_LANGUAGE, DefaultStrings.CLEAR));
		this.setMinSize(ViewConstants.ENTERCLEAR_BUTTON_WIDTH, ViewConstants.PUFFY_BUTTON_HEIGHT);
		this.setOnAction(new EventHandler<ActionEvent>() {                  
			public void handle (ActionEvent event) {
				myCL.clear();
			}
		});
	}

}
