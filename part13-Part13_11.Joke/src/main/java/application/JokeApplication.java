package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {


    public static void main(String[] args) {
        Application.launch(JokeApplication.class);
    }
    
    private StackPane createView(String text) {

        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);

        return layout;
    }

    @Override
    public void start(Stage window) throws Exception {
        // 1. Create main layout
        BorderPane mainLayout = new BorderPane();

        // 1.1. Create menu for main layout
        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);

        // 1.2. Create buttons for menu
        Button jokeButton = new Button("Joke");
        Button answerButton = new Button("Answer");
        Button explanationButton = new Button("Explanation");
        

        // 1.3. Add buttons to menu
        menu.getChildren().addAll(jokeButton, answerButton, explanationButton);

        mainLayout.setTop(menu);
        
        // 2. Add subviews and add them to the menu buttons
        // 2.1. Create subview layout 
        StackPane jokeLayout = createView("What do you call a bear with no teeth?");
        StackPane answerLayout = createView("A gummy bear.");
        StackPane explanationLayout = createView("lol dont you get it?");

        // 2.2. Add subviews to button. Pressing the buttons will change the view
        jokeButton.setOnAction(event -> mainLayout.setCenter(jokeLayout));
        answerButton.setOnAction(event -> mainLayout.setCenter(answerLayout));
        explanationButton.setOnAction(event -> mainLayout.setCenter(explanationLayout));

        // 2.3. Set initial view
        mainLayout.setCenter(jokeLayout);


        // 3. Create main scene with layout 
        Scene scene = new Scene(mainLayout);


        // 4. Show the main scene
        window.setTitle("Joke application");
        window.setScene(scene);
        window.show();
    }
}
