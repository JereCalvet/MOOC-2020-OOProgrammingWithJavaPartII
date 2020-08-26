package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    public static void main(String[] args) {
        Application.launch(GreeterApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        //name scene
        GridPane nameLayout = new GridPane();
        TextField nameTextField = new TextField();
        Button startButton = new Button("Start");
        nameLayout.add(new Label("Enter your name and start"), 0, 0);
        nameLayout.add(nameTextField, 0, 1);
        nameLayout.add(startButton, 0, 2);

        //styling the layout
        nameLayout.setPrefSize(300, 180);
        nameLayout.setAlignment(Pos.CENTER);
        nameLayout.setVgap(10);
        nameLayout.setHgap(10);
        nameLayout.setPadding(new Insets(20, 20, 20, 20));

        //main scene
        BorderPane mainLayout = new BorderPane();
        Label welcomeLabel = new Label("Welcome");
        mainLayout.setCenter(welcomeLabel);

        //styling the layout
        mainLayout.setPrefSize(300, 180);
        
        Scene passwordScene = new Scene(nameLayout);
        Scene mainScene = new Scene(mainLayout);

        //button name "login" action
        startButton.setOnAction(event -> {
            welcomeLabel.setText("Welcome " + nameTextField.getText() + "!");
            window.setScene(mainScene);
        });

        window.setTitle("Greeter");
        window.setScene(passwordScene);
        window.show();
    }
}
