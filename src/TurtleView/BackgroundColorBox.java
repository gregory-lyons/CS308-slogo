package TurtleView;

import FrontEnd.DefaultStrings;
import FrontEnd.View;
import FrontEnd.ViewConstants;
import javafx.scene.control.ComboBox;

public class BackgroundColorBox extends ComboBox<String> {	
	public BackgroundColorBox(TurtleWindow turtleWindow){
		super();
		this.setMinWidth(ViewConstants.SIDEBAR_COMBOBOX_WIDTH);
		this.getItems().addAll(DefaultStrings.BACKGROUND_COLOR_DEFAULTS);
		this.setValue(DefaultStrings.WHITE);
		this.setOnAction(event -> handle(turtleWindow));	
	}
	
	private void handle(TurtleWindow tw){
		String s = (String)this.getValue();
		s.toLowerCase();
		tw.changeBackgroundColor(s);
	}
	
	
}
