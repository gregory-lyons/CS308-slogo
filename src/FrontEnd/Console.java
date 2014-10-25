package FrontEnd;

import java.awt.Dimension;

import javafx.scene.control.TextArea;

public class Console extends TextArea {

	private static final Dimension SIZE = new Dimension(400, 150);
	
	public Console(String promptText) {
        this.setPrefSize(SIZE.width, SIZE.height);
        this.setWrapText(true);
        this.setPromptText(promptText);
        this.setEditable(false);
	}

	public void addEntry(String value) {
		this.appendText(value + "\n\n");
	}

}
