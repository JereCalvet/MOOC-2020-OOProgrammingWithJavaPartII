package buttonandtextfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndTextFieldApplication extends Application {


    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }

    private FlowPane createComponents() {
        Button button = new Button("This is a button");
        TextField text = new TextField("This is a text field");
        FlowPane groupComponents = new FlowPane();
        groupComponents.getChildren().add(button);
        groupComponents.getChildren().add(text);
        return groupComponents;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Button and text field");
        stage.setScene(new Scene(createComponents()));
        stage.show();
    }
}
