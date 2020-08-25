package title;

import javafx.application.Application;
import javafx.stage.Stage;

public class UserTitle extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parameters params = getParameters();
        String userName = params.getNamed().get("User");
        String usertitle = params.getNamed().get("Title");
        
        stage.setTitle(userName + ": " + usertitle);
        stage.show();
    }
}
