package Pen;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;

/**
 * Changes color of turtle pen
 * @author Greg, Rica
 *
 */
public class PenColorBox extends ComboBox<String> {
	
	private Map<String, Color> myMap;
	
	public static final String BLACK_LABEL = "BLACK";
	public static final String BLUE_LABEL = "BLUE";
	public static final String GREEN_LABEL = "GREEN";
	public static final String RED_LABEL = "RED";
	public static final String PROMPT = "Pen Color";
	
	public PenColorBox(){
		super();
		this.setMaxWidth(100);
		this.setPromptText(PROMPT);
		initMap();
		this.getItems().addAll(myMap.keySet());
	}
	
	private void initMap(){
		myMap = new HashMap<String, Color>();
		myMap.put(BLACK_LABEL, Color.BLACK);
		myMap.put(BLUE_LABEL, Color.ROYALBLUE);
		myMap.put(GREEN_LABEL, Color.LAWNGREEN);
		myMap.put(RED_LABEL, Color.RED);
	}
	
	public Color getColor(){
		return (Color) myMap.get(this.getValue());
	}
	
}
