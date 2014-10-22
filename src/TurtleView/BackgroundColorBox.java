package TurtleView;

import java.lang.reflect.Field;
import FrontEnd.DefaultStrings;
import FrontEnd.View;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;

public class BackgroundColorBox extends ComboBox<String> {

	public static final Color DEFAULT_COLOR = Color.WHITE;
	
	public BackgroundColorBox(TurtleWindow turtleWindow){
		super();
		this.setMinWidth(View.SIDEBAR_COMBOBOX_WIDTH);
		this.setPromptText(DefaultStrings.BACKGROUND_COLOR_PROMPT);
		this.getItems().addAll(DefaultStrings.BACKGROUND_COLOR_DEFAULTS);
		this.setOnAction(event -> handle(turtleWindow));	
	}
	
	private void handle(TurtleWindow tw){
		String s = (String)this.getValue();
		s.toLowerCase();
		tw.changeBackgroundColor(s);
	}
	
	
}
