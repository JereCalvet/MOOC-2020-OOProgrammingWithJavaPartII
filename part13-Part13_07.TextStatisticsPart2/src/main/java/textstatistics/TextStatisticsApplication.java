package textstatistics;
//This class should be in a package called textstatistics.userinterface but server wont compile

import textstatistics.logic.TextStatisticsLogic;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    private final TextStatisticsLogic logic;

    public TextStatisticsApplication() {
        this.logic = new TextStatisticsLogic();
    }
    
    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }
    
    private HBox createBottonPane() {
        HBox boxLayout = new HBox();
        boxLayout.getChildren().add(new Label("Letters: " + logic.getAmountOfCharacters()));
        boxLayout.getChildren().add(new Label("Words: " + logic.getAmountOfWords()));
        boxLayout.getChildren().add(new Label("The longest word is: " + logic.getLongestWord()));
        boxLayout.setSpacing(10);
        
        return boxLayout;
    }
    
    private Label getLabelLettersReference (HBox boxLayout) {
        return (Label) boxLayout.getChildren().get(0);
    }
    
    private Label getLabelWordsReference (HBox boxLayout) {
        return (Label) boxLayout.getChildren().get(1);
    }
    
    private Label getLabelLongestWordReference (HBox boxLayout) {
        return (Label) boxLayout.getChildren().get(2);
    }
    
    private TextArea createTextAreaWithEvent(HBox bottonPane) {
        TextArea inputText = new TextArea();
        inputText.textProperty().addListener(new TextAreaChangeListener(logic, getLabelLettersReference(bottonPane), getLabelWordsReference(bottonPane), getLabelLongestWordReference(bottonPane)));
        
        return inputText;
    }
    
    private BorderPane createComponents() {
        HBox boxLayout = createBottonPane();   
        BorderPane layout = new BorderPane();
        layout.setCenter(createTextAreaWithEvent(boxLayout));
        layout.setBottom(boxLayout);
        
        return layout;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Text statistics application");
        stage.setScene(new Scene(createComponents()));
        stage.show();
    }
}
