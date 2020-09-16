package asteroids;

import asteroids.logic.*;
import java.util.HashMap;
import java.util.Map;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AsteroidsApplication extends Application {

    public static void main(String[] args) {
        launch(AsteroidsApplication.class);
    }

    public static int partsCompleted() {
        // State how many parts you have completed using the return value of this method
        return 0;
    }

    @Override
    public void start(Stage window) throws Exception {
        Pane space = new Pane();
        space.setPrefSize(300, 200);

        Ship ship = new Ship(150, 100);
        Asteroid asteroid = new Asteroid(50, 50);

        space.getChildren().add(ship.getCharacter());
        space.getChildren().add(asteroid.getCharacter());

        asteroid.turnRight();
        asteroid.turnRight();
        asteroid.accelerate();
        asteroid.accelerate();

        Scene mainWindow = new Scene(space);
        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();

        space.setOnKeyPressed(event -> {
            pressedKeys.put(event.getCode(), Boolean.TRUE);
        });

        space.setOnKeyReleased(event -> {
            pressedKeys.put(event.getCode(), Boolean.FALSE);
        });

        AnimationTimer timer = timer -> {
            if (pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                ship.turnLeft();
            }

            if (pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                ship.turnRight();
            }

            if (pressedKeys.getOrDefault(KeyCode.UP, false)) {
                ship.accelerate();
            }

            ship.move();
            asteroid.move();
        };
        
        timer.start();
        
        window.setScene(mainWindow);
        window.setTitle("Asteroids");
        window.show();
    }
}
