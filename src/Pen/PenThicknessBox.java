package Pen;

import javafx.scene.control.ComboBox;

public class PenThicknessBox extends ComboBox{
	
	public PenThicknessBox(){
		super();
		this.setMaxWidth(100);
		this.setPromptText("Choose Pen Thickness");
		this.getItems().addAll(1.0, 2.0, 3.0, 4.0);	
	}
	
	public double getThick(){
		return (double)this.getValue();
	}

}
