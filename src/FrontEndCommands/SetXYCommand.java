package FrontEndCommands;

import javafx.scene.control.TextField;
import FrontEnd.CommandLine;
import FrontEnd.View;

public class SetXYCommand extends SuperCommand {
    TextField myAmount = new TextField();

    public SetXYCommand (CommandLine myLine, String label, String language) {
        super(myLine, label, language);
        myAmount.setText("0 0");
        myAmount.setPrefSize(View.SIDEBAR_AMOUNT_WIDTH, View.SHORT_BUTTON_HEIGHT);
        myHBox.getChildren().add(myAmount);
        //myHBox.getChildren().add(myButton);
    }
    
    @Override
    protected void handle() {
        this.setChanged();
        this.notifyObservers(myInstruction + " " + myAmount.getText());
    }


}
