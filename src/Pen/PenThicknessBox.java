package Pen;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import FrontEnd.View;
import javafx.scene.control.ComboBox;

public class PenThicknessBox extends ComboBox<Double>{
	
	public static final List<Double> myList = new ArrayList<Double>(Arrays.asList(1.0, 2.0, 3.0, 4.0));
	public static final int DEFAULT_VALUE_INDEX = 0;
	
	public PenThicknessBox(){
		super();
		this.setMaxWidth(View.SIDEBAR_COMBOBOX_WIDTH);
		this.getItems().addAll(myList);	
		this.setValue(myList.get(DEFAULT_VALUE_INDEX));
	}
	
	public double getThick(){
		return (double)this.getValue();
	}

}
