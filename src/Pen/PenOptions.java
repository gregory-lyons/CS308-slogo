package Pen;

import TurtleView.BackgroundColorBox;
import TurtleView.GridCheckBox;
import TurtleView.TurtleImageBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PenOptions extends VBox {

	private Pen myPen;
	
	private PenColorBox myColorBox;
	private CheckBox myDownBox;
	private PenThicknessBox myThickBox;
	//private PenTypeBox myTypeBox;
	
	public static final String THICKNESS_LABEL = "   Pen Thickness";
	public static final String COLOR_LABEL = "   Pen Color";
	public static final String PENDOWN_LABEL = "   Pen down?";
	public static final String TYPEBOX_LABEL = "   Line type?";
	
	public PenOptions(Pen p) {
		myPen = p;
		setUpBoxes();
	}
	
	private void setUpBoxes(){
		HBox thickness = new HBox();
		myThickBox = new PenThicknessBox();
		myThickBox.setOnAction(event -> myPen.changeThick(myThickBox.getThick()));
		thickness.getChildren().addAll(myThickBox, new Text(THICKNESS_LABEL));
		
		HBox color = new HBox();
		myColorBox = new PenColorBox();
		myColorBox.setOnAction(event -> myPen.changeColor(myColorBox.getColor()));
		color.getChildren().addAll(myColorBox, new Text(COLOR_LABEL));
		
		HBox penDown = new HBox();
		myDownBox = new CheckBox();
		myDownBox.setSelected(true);
		myDownBox.setOnAction(event -> myPen.setPenDown(myDownBox.isSelected()));
		penDown.getChildren().addAll(myDownBox, new Text(PENDOWN_LABEL));
		
		HBox lineType = new HBox();
		//myTypeBox = new PenTypeBox();
		//myTypeBox.setOnAction(event -> myPen.changeType(myTypeBox.getType()));
		//lineType.getChildren().addAll(myTypeBox, new Text(TYPEBOX_LABEL));
		this.getChildren().addAll(thickness, color, lineType, penDown);		
	}

}
