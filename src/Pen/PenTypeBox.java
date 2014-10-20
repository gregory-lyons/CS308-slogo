package Pen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.control.ComboBox;

public class PenTypeBox extends ComboBox<String> {
	
	private Map<String, List<Double>> myMap;
	public static final String PROMPT = "Line type";
	
	
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
		myMap.put(Pen.SOLID_LABEL, Pen.SOLID);
		myMap.put(Pen.DASHED_LABEL, Pen.DASHED);
		myMap.put(Pen.DOTTED_LABEL, Pen.DOTTED);
	}
}
