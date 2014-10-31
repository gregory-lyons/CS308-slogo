package FrontEndCommands;

import javafx.scene.control.TextField;
import FrontEnd.CommandLine;
import FrontEnd.View;
import FrontEnd.ViewConstants;

public class SetXYCommand extends SuperCommand {
    TextField myAmount = new TextField();

    public SetXYCommand (CommandLine myLine, String label, String language) {
        super(myLine, label, language);
        myAmount.setText("0 0");
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
