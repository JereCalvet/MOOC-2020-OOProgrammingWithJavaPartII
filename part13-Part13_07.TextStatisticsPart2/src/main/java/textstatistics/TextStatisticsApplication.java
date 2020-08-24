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
    
    private HBox statisticsOutputLayout() {
        HBox boxLayout = new HBox();
        boxLayout.getChildren().add(new Label("Letters: 0"));
        boxLayout.getChildren().add(new Label("Words: 0"));
        boxLayout.getChildren().add(new Label("The longest word is:"));
        boxLayout.setSpacing(10);
        
        return boxLayout;
    }
    
    private TextArea addChangeListener(TextArea textAreaComponentToChange) {
        textAreaComponentToChange.textProperty().addListener((change, oldValue, NewValue) -> {
            updateGUILabels(NewValue);
        });
        return textAreaComponentToChange;
    }
    
    private BorderPane createComponents() {
        BorderPane layout = new BorderPane();
        TextArea inputText = new TextArea();
        addChangeListener(inputText);
        layout.setCenter(inputText);
        layout.setBottom(statisticsOutputLayout());
        
        return layout;
    }
    
    private void updateGUILabels(String textToProcess) {
        logic.setText(textToProcess);
        
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Text statistics application");
        stage.setScene(new Scene(createComponents()));
        stage.show();
    }
}
