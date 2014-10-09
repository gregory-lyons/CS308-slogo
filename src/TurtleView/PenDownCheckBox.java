package TurtleView;

import javafx.scene.control.CheckBox;

public class PenDownCheckBox extends CheckBox {

	public PenDownCheckBox(TurtleWindow tw) {
		super();
		this.setSelected(true);
		this.setOnAction(event -> handle(tw));
	}

	private void handle(TurtleWindow tw) {
		tw.updatePen(this.isSelected());
	}

}
