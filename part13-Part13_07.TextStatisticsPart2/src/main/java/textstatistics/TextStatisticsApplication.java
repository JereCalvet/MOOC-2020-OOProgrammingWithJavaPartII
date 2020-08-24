package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    private TextStatisticsLogic logic;

    public TextStatisticsApplication() {
        this.logic = new TextStatisticsLogic();
    }
    
    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }
   
    private void updateGUILabels(String textToProcess, Label labelLetters, Label labelWords, Label labelLongestWord) {
        logic.setText(textToProcess);
        labelLetters.setText("Letters: " + logic.getAmountOfCharacters());
        labelWords.setText("Words: " + logic.getAmountOfWords());
        labelLongestWord.setText("The longest word is: " + logic.getLongestWord());
    }

    @Override
    public void start(Stage stage) throws Exception {
        HBox boxLayout = new HBox();
        Label labelLetters = new Label("Letters: " + logic.getAmountOfCharacters());
        Label labelWords = new Label("Words: " + logic.getAmountOfWords());
        Label labelLongestWord = new Label("The longest word is: " + logic.getLongestWord());
        boxLayout.getChildren().add(labelLetters);
        boxLayout.getChildren().add(labelWords);
        boxLayout.getChildren().add(labelLongestWord);
        boxLayout.setSpacing(10);
               
        BorderPane layout = new BorderPane();
        TextArea inputText = new TextArea();
        inputText.textProperty().addListener((change, oldValue, NewValue) -> {
            updateGUILabels(NewValue, labelLetters, labelWords, labelLongestWord);
        });
        
        /*
        Respuesta propuesta:
        textBox.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
 
            lettersLabel.setText("Letters: " + characters);
            wordsLabel.setText("Words: " + words);
            longestWordLabel.setText("The longest word is: " + longest);
        });
        */
        
        layout.setCenter(inputText);
        layout.setBottom(boxLayout);
         
        stage.setTitle("Text statistics application");
        stage.setScene(new Scene(layout));
        stage.show();
    }
}
