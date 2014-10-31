package FrontEndCommands;

import javafx.scene.control.Button;
import FrontEnd.DefaultStrings;
import FrontEnd.StringChooser;
import FrontEnd.View;
import FrontEnd.ViewConstants;
import TurtleView.TurtleWindow;

public class MakeTurtleCommand extends Button {

	public MakeTurtleCommand(TurtleWindow tw) {
		this.setText(StringChooser.getWordInLang(ViewConstants.DEFAULT_LANGUAGE, DefaultStrings.TURTLEBUTTON));
		this.setPrefSize(ViewConstants.SIDEBAR_BUTTON_WIDTH, ViewConstants.SHORT_BUTTON_HEIGHT);
		this.setOnAction(event -> tw.makeTurtle());
	}

}
