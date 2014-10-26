package TurtleView;

import Backend.Turtle;
import FrontEnd.DefaultStrings;
import FrontEnd.View;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;


public class TurtleImageBox extends ComboBox<String> {
	
	private Turtle myTurtle;
	
	public TurtleImageBox(Turtle turtle){
		super();
		changeTurtle(turtle);
		this.setMinWidth(View.SIDEBAR_COMBOBOX_WIDTH);
		this.setPromptText(DefaultStrings.TURTLE_IMAGE_PROMPT);
		this.getItems().addAll(DefaultStrings.TURTLE_IMAGE_1, DefaultStrings.TURTLE_IMAGE_2, DefaultStrings.TURTLE_IMAGE_3);
		this.setOnAction(event -> handle());	
	}
	
	private void handle() {
		String s = (String)this.getValue();
		myTurtle.changeImage(s);
	}
	
	public void changeTurtle(Turtle newTurtle) {
		myTurtle = newTurtle;
	}
	
	
}

