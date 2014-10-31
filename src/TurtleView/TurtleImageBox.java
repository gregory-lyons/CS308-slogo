package TurtleView;

import Backend.Turtle;
import FrontEnd.DefaultStrings;
import FrontEnd.View;
import FrontEnd.ViewConstants;
import javafx.scene.control.ComboBox;

public class TurtleImageBox extends ComboBox<String> {	
	private Turtle myTurtle;
	
	public TurtleImageBox(Turtle turtle){
		super();
		changeTurtle(turtle);
		this.setMinWidth(ViewConstants.SIDEBAR_COMBOBOX_WIDTH);
		this.getItems().addAll(DefaultStrings.TURTLE_IMAGE_1, DefaultStrings.TURTLE_IMAGE_2, DefaultStrings.TURTLE_IMAGE_3);
		this.setValue(DefaultStrings.TURTLE_IMAGE_1);
		this.setOnAction(event -> handle());	
	}
	
	private void handle() {
		String s = this.getValue();
		if (s.equals(DefaultStrings.TURTLE_IMAGE_1) || s.equals(DefaultStrings.TURTLE_IMAGE_2) || 
		        s.equals(DefaultStrings.TURTLE_IMAGE_3)) {
		          myTurtle.changeToDefaultImage(s);
		}
		else {
		    myTurtle.changeToLoadedImage(s);
		}
	}
	
	public void changeTurtle(Turtle newTurtle) {
		myTurtle = newTurtle;
	}
	
	
}

