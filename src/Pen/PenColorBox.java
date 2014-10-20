package Pen;

import java.lang.reflect.Field;

import TurtleView.TurtleWindow;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;

public class PenColorBox extends ComboBox {
	
	
	public PenColorBox(){
		super();
		this.setMaxWidth(100);
		this.setPromptText("Choose Pen Color");
		this.getItems().addAll("BLACK", "BLUE", "GREEN", "RED");
	}
	
	public Color getColor(){
		String s = (String)this.getValue();
		try{
			Field field = Class.forName("javafx.scene.paint.Color").getField(s);
		    Color c = (Color)field.get(null);
		    return c;
		}
		catch (Exception e){
			return null;
		}
	}
	
}
