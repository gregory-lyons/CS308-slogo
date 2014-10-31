package FrontEnd;

import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class VBar extends VBox {

	public VBar(Node... nodes) {
		super(ViewConstants.BOX_SPACING);
		this.setPadding(ViewConstants.PADDING);
		add(nodes);
	}
	
	public void add(Node...nodes) {
		this.getChildren().addAll(nodes);
	}

}
