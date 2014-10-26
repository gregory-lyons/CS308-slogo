package Pen;

import java.util.HashMap;
import java.util.Map;
import FrontEnd.DefaultStrings;
import FrontEnd.View;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;

/**
 * Changes color of turtle pen
 * @author Greg, Rica
 *
 */
public class PenColorBox extends ComboBox<String> {	
	private Map<String, Color> myMap;
	
	public PenColorBox(){
		super();
		this.setMaxWidth(View.SIDEBAR_COMBOBOX_WIDTH);
		initMap();
		this.getItems().addAll(myMap.keySet());
		this.setValue(DefaultStrings.BLACK);
	}
	
	private void initMap(){
		myMap = new HashMap<String, Color>();
		myMap.put(DefaultStrings.BLACK, Color.BLACK);
		myMap.put(DefaultStrings.BLUE, Color.ROYALBLUE);
		myMap.put(DefaultStrings.GREEN, Color.LAWNGREEN);
		myMap.put(DefaultStrings.RED, Color.RED);
	}
	
	public Color getColor(){
		return (Color) myMap.get(this.getValue());
	}
	
}
