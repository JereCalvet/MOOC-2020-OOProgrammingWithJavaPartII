package borderpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneApplication extends Application {


    public static void main(String[] args) {
        launch(BorderPaneApplication.class);
    }

    private BorderPane createComponents() {
        Label textNorth = new Label("NORTH"); 
        Label textEast = new Label("EAST"); 
        Label textSouth = new Label("SOUTH"); 
        BorderPane layout = new BorderPane();
        layout.setTop(textNorth);
        layout.setRight(textEast);
        layout.setBottom(textSouth);
        return layout;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Border Pane Example");
        stage.setScene(new Scene(createComponents()));
        stage.show();
    }
}
