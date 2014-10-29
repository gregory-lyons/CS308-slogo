package FrontEnd;

import java.awt.Dimension;
import javafx.scene.control.TextArea;

public class Console extends TextArea {

	private static final Dimension SIZE = new Dimension(400, 150);
	
	public Console() {
        this.setPrefSize(SIZE.width, SIZE.height);
        this.setWrapText(true);
        this.setPromptText(Translator.translateWithKey(DefaultStrings.CONSOLEDEFAULT, View.DEFAULT_LANGUAGE));
        this.setEditable(false);
	}
}
