package Pen;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import javafx.scene.control.ComboBox;

public class PenThicknessBox extends ComboBox<Double>{
	
	public static final List<Double> myList = new ArrayList(Arrays.asList(1.0, 2.0, 3.0, 4.0));
	public static final String PROMPT = "Pen Thickness";
	
	public PenThicknessBox(){
		super();
		this.setMaxWidth(100);
		this.setPromptText(PROMPT);
		this.getItems().addAll(1.0, 2.0, 3.0, 4.0);	
	}
	
	public double getThick(){
		return (double)this.getValue();
	}

}
