package FrontEnd;

import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class HBar extends HBox{

	public HBar(Node... nodes) {
		super(ViewConstants.BOX_SPACING);
		this.setPadding(ViewConstants.PADDING);
		add(nodes);
	}
	
	public void add(Node...nodes) {
		this.getChildren().addAll(nodes);
	}
}

