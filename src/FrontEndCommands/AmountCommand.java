package FrontEndCommands;

import javafx.scene.control.TextField;
import FrontEnd.CommandLine;
import FrontEnd.View;
import FrontEnd.ViewConstants;

public class AmountCommand extends SuperCommand {
    TextField myAmount = new TextField();

    public AmountCommand (CommandLine myLine, String label, String language) {
        super(myLine, label, language);
        myAmount.setText("50");
        myAmount.setPrefSize(ViewConstants.SIDEBAR_AMOUNT_WIDTH, ViewConstants.SHORT_BUTTON_HEIGHT);
        myHBox.getChildren().add(myAmount);
        //myHBox.getChildren().add(myButton);
    }
    
    @Override
    protected void handle() {
        this.setChanged();
        this.notifyObservers(myButton.getText() + " " + myAmount.getText());
    }
}
