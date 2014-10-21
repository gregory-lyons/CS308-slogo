package TurtleView;

import java.lang.reflect.Field;

import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;

public class TurtleImageBox extends ComboBox {
	
	public TurtleImageBox(TurtleWindow turtleWindow){
		super();
		this.setMaxWidth(200);
		this.setPromptText("Choose Turtle Image");
		this.getItems().addAll("turtle1", "turtle2", "turtle3");
		this.setOnAction(event -> handle(turtleWindow));	
	}
	
	private void handle(TurtleWindow tw){
		String s = (String)this.getValue();
		System.out.println(s);
		//tw.changeTurtleImage(s);
	}
	
	
}

