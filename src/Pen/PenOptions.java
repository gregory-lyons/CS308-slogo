package Pen;

import FrontEnd.DefaultStrings;
import FrontEnd.View;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PenOptions extends VBox {

	private Pen myPen;
	
	private PenColorBox myColorBox;
	private CheckBox myDownBox;
	private PenThicknessBox myThickBox;
	private PenTypeBox myTypeBox;
	
	public PenOptions(Pen p) {
	        super(View.BOX_SPACING);
		myPen = p;
		setUpBoxes();
	}
	
	private void setUpBoxes(){
		VBox thickness = new VBox();
		myThickBox = new PenThicknessBox();
		myThickBox.setOnAction(event -> myPen.changeThick(myThickBox.getThick()));
		thickness.getChildren().addAll(new Text(DefaultStrings.THICKNESS_LABEL), myThickBox);
		
		VBox color = new VBox();
		myColorBox = new PenColorBox();
		myColorBox.setOnAction(event -> myPen.changeColor(myColorBox.getColor()));
		color.getChildren().addAll(new Text(DefaultStrings.COLOR_LABEL), myColorBox);
		
		HBox penDown = new HBox(View.BOX_SPACING);
		myDownBox = new CheckBox();
		myDownBox.setSelected(true);
		myDownBox.setOnAction(event -> updatePen());
		penDown.getChildren().addAll(myDownBox, new Text(DefaultStrings.PENDOWN_LABEL));
		
		VBox lineType = new VBox();
		myTypeBox = new PenTypeBox();
		myTypeBox.setOnAction(event -> myPen.changeType(myTypeBox.getType()));
		lineType.getChildren().addAll(new Text(DefaultStrings.TYPEBOX_LABEL), myTypeBox);
		this.getChildren().addAll(thickness, color, lineType, penDown);		
	}
	
	private void updatePen(){
		if (myDownBox.isSelected()) myPen.setPenDown();
		else myPen.setPenUp();
	}
	
	public void changePen(Pen p){
		myPen = p;
	}

}
