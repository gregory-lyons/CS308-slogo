package Pen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import FrontEnd.DefaultStrings;
import javafx.scene.control.ComboBox;

public class PenTypeBox extends ComboBox<String> {
	
	private Map<String, List<Double>> myMap;
	public static final String PROMPT = DefaultStrings.PEN_TYPE_PROMPT;
	
	
	public PenTypeBox(){
		super();
		this.setMaxWidth(100);
		this.setPromptText(PROMPT);
		initMap();
		this.getItems().addAll(myMap.keySet());	
	}
	
	public List<Double> getType(){
		return (List<Double>) myMap.get(this.getValue());
	}
	
	private void initMap(){
		myMap = new HashMap<String, List<Double>>();
		myMap.put(DefaultStrings.SOLID_LABEL, Pen.SOLID);
		myMap.put(DefaultStrings.DASHED_LABEL, Pen.DASHED);
		myMap.put(DefaultStrings.DOTTED_LABEL, Pen.DOTTED);
	}
}
