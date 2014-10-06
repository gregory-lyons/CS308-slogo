import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import FrontEnd.View;

/**
 * Dialog prompt for user to select a language for the turtle program.
 * @author Rica
 *
 */
public class LanguageSelector {
    private Scene scene;
    public LanguageSelector(Stage s, Stage dialog) {
        dialog.setTitle("Select Language for Turtles Program");
        //dialog.initStyle(StageStyle.UTILITY);
        BorderPane root = new BorderPane();
        VBox myVBox = new VBox();
        Label title = new Label("Select a Language");
        myVBox.getChildren().add(title);
        
        ObservableList<String> options = FXCollections.observableArrayList("English", "Chinese", "French", "Italian", "Portuguese", "Russian");
        ComboBox myLanguageSelect = new ComboBox(options);
        myLanguageSelect.setValue("English");
        myVBox.getChildren().add(myLanguageSelect);
        
        Button enterButton = new Button("Start Game");
        enterButton.setOnAction(new EventHandler<ActionEvent>() {                  
            public void handle (ActionEvent event) {
                View myTurtleWindow = new View((String)myLanguageSelect.getValue());
                s.setTitle("My Turtle Program!");
                s.setScene(myTurtleWindow.getScene());
                //s.setFullScreen(true);
                s.show();
                dialog.close();
            }
        });
        myVBox.getChildren().add(enterButton);
        Insets myPadding = new Insets(50, 150, 50, 150);
        myVBox.setPadding(myPadding);
        root.setCenter(myVBox);
        scene = new Scene(root, 400, 200);
    }
    
    public Scene getScene() {
        return scene;
    }

}
