// This entire file is part of my masterpiece.
// RICA ZHANG
package FrontEndCommands;

import javafx.scene.control.TextField;
import FrontEnd.DefaultStrings;
import FrontEnd.View;

public class AmountCommand extends SuperCommand {
    TextField myAmount = new TextField();

    public AmountCommand (String label, String language) {
        super(label);
        myAmount.setText(DefaultStrings.DEFAULT_BUTTON_AMOUNT);
        myAmount.setPrefSize(View.SIDEBAR_AMOUNT_WIDTH, View.SHORT_BUTTON_HEIGHT);
        myHBox.getChildren().add(myAmount);
    }
    
    @Override
    protected void handle() {
        this.setChanged();
        this.notifyObservers(myButton.getText() + " " + myAmount.getText());
    }
}
