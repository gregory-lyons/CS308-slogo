package FrontEnd;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class HistoryBox extends TextArea implements Observer {
        private List<String> myContent;
        private ComboBox myComboBox;
        
        public HistoryBox(ComboBox myCombo) {
            myContent = new ArrayList<String>();
            myComboBox = myCombo;
            
        }

	@Override
	public void update(Observable button, Object instruction) {  
	    this.appendText(instruction + "\n");
	    myComboBox.getItems().add((String) instruction);
	}
	
	

}
