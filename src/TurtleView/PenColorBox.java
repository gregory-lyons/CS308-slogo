package TurtleView;

import java.lang.reflect.Field;

import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;

public class PenColorBox extends ComboBox {
	
	public static final Color DEFAULT_COLOR = Color.BLACK;
	
	public PenColorBox(TurtleWindow turtleWindow){
		super();
		this.setMaxWidth(100);
		this.setPromptText("Choose Pen Color");
		this.getItems().addAll("BLACK", "BLUE", "GREEN", "RED");
		this.setOnAction(event -> handle(turtleWindow));	
	}
	
	private void handle(TurtleWindow tw){
		String s = (String)this.getValue();
		System.out.println(s);
		Color c = DEFAULT_COLOR;
		try{
		Field field = Class.forName("javafx.scene.paint.Color").getField(s);
	    c = (Color)field.get(null);
		}
		catch (Exception e){
			
		}
		System.out.println(c.toString());
		tw.choosePenColor(c);
	}
	
}
