package FrontEndCommands;

import javafx.scene.control.TextField;
import FrontEnd.DefaultStrings;
import FrontEnd.View;

public class CoordinateCommand extends SuperCommand {
    TextField myAmount = new TextField();

    public CoordinateCommand (String label) {
        super(label);
        myAmount.setText(DefaultStrings.DEFAULT_BUTTON_COORDINATE);
        myAmount.setPrefSize(View.SIDEBAR_AMOUNT_WIDTH, View.SHORT_BUTTON_HEIGHT);
        myHBox.getChildren().add(myAmount);
    }
    
    @Override
    protected void handle() {
        this.setChanged();
        this.notifyObservers(myButton.getText() + " " + myAmount.getText());
    }
}