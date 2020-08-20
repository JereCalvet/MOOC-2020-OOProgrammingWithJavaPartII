package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

public class ButtonAndLabelApplication extends Application {

    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

    private FlowPane createComponents() {
        Button buttonComponent = new Button("Button click");
        Label labelComponent = new Label("Press the button");
        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(buttonComponent);
        componentGroup.getChildren().add(labelComponent);
        return componentGroup;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Button and label app");
        stage.setScene(new Scene(createComponents()));
        stage.show();
    }
}
