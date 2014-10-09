package TurtleView;

import java.lang.reflect.Field;

import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;

public class BackgroundColorBox extends ComboBox {

	public static final Color DEFAULT_COLOR = Color.WHITE;
	
	public BackgroundColorBox(TurtleWindow turtleWindow){
		super();
		this.setMaxWidth(100);
		this.setPromptText("Choose Background Color");
		this.getItems().addAll("WHITE", "GRAY", "BLACK", "RED", "GREEN", "YELLOW");
		this.setOnAction(event -> handle(turtleWindow));	
	}
	
	private void handle(TurtleWindow tw){
		String s = (String)this.getValue();
		s.toLowerCase();
		tw.changeBackgroundColor(s);
	}
	
	
}
