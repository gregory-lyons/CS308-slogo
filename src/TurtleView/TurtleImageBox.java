package TurtleView;

import java.lang.reflect.Field;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class TurtleImageBox extends ComboBox<String> {
	
	public TurtleImageBox(TurtleWindow turtleWindow){
		super();
		this.setMaxWidth(200);
		this.setPromptText("Choose Turtle Image");
		this.getItems().addAll("turtle1", "turtle2", "turtle3");
		this.setOnAction(event -> handle(turtleWindow));	
	}
	
	private void handle(TurtleWindow tw){
		String s = (String)this.getValue();
		if (s.equals("turtle1") || s.equals("turtle2") || s.equals("turtle3")) {
		          System.out.println(s);
		          tw.changeTurtleImage(s);
		}
		// TODO Insert method here like what I added so that new images can be loaded
		else {
		    System.out.println("Chose new image");
		    //tw.changeTurtleLoadedImage(s);
		}

	}
	
	
}

