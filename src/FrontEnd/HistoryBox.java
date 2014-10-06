package FrontEnd;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class HistoryBox extends TextArea implements Observer {
        private List<String> myContent;
        
        public HistoryBox() {
            myContent = new ArrayList<String>();
        }

	@Override
	public void update(Observable button, Object instruction) {
	    this.appendText(instruction + "\n");
	        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle (MouseEvent event) {
	                System.out.println("Blah");
	            }
	        });    
	}
	
	

}
