package notifier;

import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.Event;
//import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

    private VBox createComponents() {
        VBox layout = new VBox();
        TextField textInputTextField = new TextField();
        Button updateButton = new Button("Update");
        Label textOutputLabel = new Label();

//        updateButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                textOutputLabel.setText(textInputTextField.getText());
//            }
//        });

        updateButton.setOnAction(event -> {textOutputLabel.setText(textInputTextField.getText());});
        layout.getChildren().add(textInputTextField);
        layout.getChildren().add(updateButton);
        layout.getChildren().add(textOutputLabel);
        return layout;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Notifier application");
        stage.setScene(new Scene(createComponents()));
        stage.show();
    }
}
