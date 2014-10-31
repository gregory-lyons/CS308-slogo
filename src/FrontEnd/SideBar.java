// This entire file is part of my masterpiece.
// GREG LYONS

package FrontEnd;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;

public class SideBar extends ScrollPane {
	
	VBar myVBar;

	public SideBar(Node... nodes) {
		myVBar = new VBar(nodes);
		this.setHbarPolicy(ScrollBarPolicy.NEVER);
		this.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		this.setContent(myVBar);
		this.setMinWidth(ViewConstants.SIDEBAR_WIDTH);
	}
	
	public void add(Node...nodes) {
		myVBar.getChildren().addAll(nodes);
	}

}
