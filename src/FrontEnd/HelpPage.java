package FrontEnd;

import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.text.TextFlow;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class HelpPage extends TextFlow{

	public static final String DEFAULT_ADDRESS = "http://www.cs.duke.edu/courses/fall14/compsci308/assign/03_slogo/commands.php";
	
	public HelpPage(Hyperlink h) {
		super(h);
		h.setOnAction(event -> loadPage());
	}
	
	private void loadPage() {
		WebView webView = new WebView();
		webView.getEngine().load(DEFAULT_ADDRESS);                
		Stage myHelpStage = new Stage();
		myHelpStage.setScene(new Scene(webView));
		myHelpStage.show();
	}

}
