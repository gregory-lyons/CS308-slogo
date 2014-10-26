package Pen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import FrontEnd.DefaultStrings;
import javafx.scene.control.ComboBox;

public class PenTypeBox extends ComboBox<String> {
	
	private Map<String, List<Double>> myMap;	
	
	public PenTypeBox(){
		super();
		this.setMaxWidth(100);
		initMap();
		this.getItems().addAll(myMap.keySet());	
		this.setValue(DefaultStrings.SOLID_LABEL);
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
