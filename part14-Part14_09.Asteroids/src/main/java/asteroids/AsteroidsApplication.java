package asteroids;

import asteroids.logic.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AsteroidsApplication extends Application {

    public static int WIDTH = 300;
    public static int HEIGHT = 200;

    public static void main(String[] args) {
        launch(AsteroidsApplication.class);
    }

    public static int partsCompleted() {
        // State how many parts you have completed using the return value of this method
        return 4;
    }
    
    private List<Asteroid> createListAsteroids() {
        List<Asteroid> asteroids = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Random rnd = new Random();
            asteroids.add(new Asteroid(rnd.nextInt(WIDTH / 3), rnd.nextInt(HEIGHT / 3)));
        }
        return asteroids;
    }

    @Override
    public void start(Stage window) throws Exception {
        Pane space = new Pane();
        space.setPrefSize(WIDTH, HEIGHT);
        Scene mainWindow = new Scene(space);

        //score board
        Text scoreBoardtext = new Text(10, 20, "Points: 0");
        space.getChildren().add(scoreBoardtext);
        AtomicInteger points = new AtomicInteger();

        //create characters
        Ship ship = new Ship(WIDTH / 2, HEIGHT / 2);
        List<Projectile> projectiles = new ArrayList<>();
        List<Asteroid> asteroids = createListAsteroids();
        
        //add characters
        asteroids.forEach(asteroid -> space.getChildren().add(asteroid.getCharacter()));
        space.getChildren().add(ship.getCharacter());

        //capture pressed keys
        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();

        mainWindow.setOnKeyPressed(event -> {
            pressedKeys.put(event.getCode(), Boolean.TRUE);
        });

        mainWindow.setOnKeyReleased(event -> {
            pressedKeys.put(event.getCode(), Boolean.FALSE);
        });

        //game animations
        new AnimationTimer() {

            private void removeMarkedAsteroids() {
                asteroids.stream()
                        .filter(asteroid -> !asteroid.isAlive())
                        .forEach(asteroid -> space.getChildren().remove(asteroid.getCharacter()));
                asteroids.removeAll(asteroids.stream()
                        .filter(asteroid -> !asteroid.isAlive())
                        .collect(Collectors.toList()));
            }

            private void removeMarkedProjectiles() {
                projectiles.stream()
                        .filter(projectile -> !projectile.isAlive())
                        .forEach(projectile -> space.getChildren().remove(projectile.getCharacter()));
                projectiles.removeAll(projectiles.stream()
                        .filter(projectile -> !projectile.isAlive())
                        .collect(Collectors.toList()));
            }

            private void checkAsteroidsAndProjectilesCollidingAndMarkThemToBeRemoved() {
                projectiles.forEach(projectile -> {
                    asteroids.forEach(asteroid -> {
                        if (projectile.collide(asteroid)) {
                            projectile.setAlive(false);
                            asteroid.setAlive(false);
                        }
                    });
                    if (!projectile.isAlive()) {
                        scoreBoardtext.setText("Points: " + points.addAndGet(1000));
                    }
                });
            }

            private void occasionallyInsertNewAsteroids() {
                if (Math.random() < 0.005) {
                    Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);
                    if (!asteroid.collide(ship)) {
                        asteroids.add(asteroid);
                        space.getChildren().add(asteroid.getCharacter());
                    }
                }
            }

            private void checkAsteroidCollidingShipAndEndGame() {
                asteroids.forEach(asteroid -> {
                    if (ship.collide(asteroid)) {
                        stop();
                    }
                });
            }

            private void moveCharacters() {
                ship.move();
                asteroids.forEach(asteroid -> asteroid.move());
                projectiles.forEach(projectile -> projectile.move());
            }

            private void addProjectilesWithSpaceBar() {
                if (pressedKeys.getOrDefault(KeyCode.SPACE, false) && projectiles.size() < 3) {
                    Projectile projectile = new Projectile((int) ship.getCharacter().getTranslateX(), (int) ship.getCharacter().getTranslateY());
                    projectile.getCharacter().setRotate(ship.getCharacter().getRotate());
                    projectiles.add(projectile);

                    projectile.accelerate();
                    projectile.setMovement(projectile.getMovement().normalize().multiply(3));

                    space.getChildren().add(projectile.getCharacter());
                }
            }

            private void moveShipWithArrowsKey() {
                if (pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                }

                if (pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }

                if (pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }
            }

            @Override
            public void handle(long now) {
                moveShipWithArrowsKey();
                addProjectilesWithSpaceBar();
                moveCharacters();

                //asteroids hitten by projectiles are marked as dead
                checkAsteroidsAndProjectilesCollidingAndMarkThemToBeRemoved();
                removeMarkedProjectiles();
                removeMarkedAsteroids();

                occasionallyInsertNewAsteroids();
                checkAsteroidCollidingShipAndEndGame();
            }
        }.start();

        window.setScene(mainWindow);
        window.setTitle("Asteroids");
        window.show();
    }
}
