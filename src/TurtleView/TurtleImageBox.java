package TurtleView;

import java.lang.reflect.Field;
import FrontEnd.DefaultStrings;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class TurtleImageBox extends ComboBox<String> {
	
	public TurtleImageBox(TurtleWindow turtleWindow){
		super();
		this.setMaxWidth(200);
		this.setPromptText(DefaultStrings.TURTLE_IMAGE_PROMPT);
		this.getItems().addAll(DefaultStrings.TURTLE_IMAGE_1, DefaultStrings.TURTLE_IMAGE_2, DefaultStrings.TURTLE_IMAGE_3);
		this.setOnAction(event -> handle(turtleWindow));	
	}
	
	private void handle(TurtleWindow tw){
		String s = (String)this.getValue();
		if (s.equals(DefaultStrings.TURTLE_IMAGE_1) 
		        || s.equals(DefaultStrings.TURTLE_IMAGE_2) 
		        || s.equals(DefaultStrings.TURTLE_IMAGE_3)) {
		          System.out.println(s);
		          tw.changeTurtleImage(s);
		}
		// TODO Insert method here like what I added so that new images can be loaded
		else {
		    //tw.changeTurtleLoadedImage(s);
		}

	}
	
	
}

