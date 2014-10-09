package TurtleView;

import javafx.scene.control.CheckBox;

public class GridCheckBox extends CheckBox {
	
	public GridCheckBox(TurtleWindow tw) {
		super();
		this.setSelected(true);
		this.setOnAction(event -> handle(tw));
	}

	private void handle(TurtleWindow tw) {
		tw.gridLines(this.isSelected());
	}

}
