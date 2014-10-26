package FrontEndCommands;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import FrontEnd.CommandLine;
import FrontEnd.View;

public class AmountCommand extends SuperCommand {
    TextField myAmount = new TextField();

    public AmountCommand (CommandLine myLine, String label, String language) {
        super(myLine, label, language);
        myAmount.setText("50");
        myAmount.setPrefSize(View.SIDEBAR_AMOUNT_WIDTH, View.SHORT_BUTTON_HEIGHT);
        myHBox.getChildren().add(myAmount);
        //myHBox.getChildren().add(myButton);
    }
    
    @Override
    protected void handle() {
        this.setChanged();
        this.notifyObservers(myButton.getText() + " " + myAmount.getText());
    }
}
