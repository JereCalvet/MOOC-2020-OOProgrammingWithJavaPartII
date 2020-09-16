package asteroids.logic;

import asteroids.AsteroidsApplication;
import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

/**
 *
 * @author Jere
 */
public abstract class Character {

    private Polygon character;
    private Point2D movement;
    private boolean alive;

    public Character(Polygon character, int x, int y) {
        this.character = character;
        this.character.setTranslateX(x);
        this.character.setTranslateY(y);
        movement = new Point2D(0, 0);
        alive = true;
    }

    public void setAlive(boolean live) {
        this.alive = live;
    }

    public boolean isAlive() {
        return alive;
    }
 
    public Point2D getMovement() {
        return movement;
    }

    public void setMovement(Point2D movement) {
        this.movement = movement;
    }

    public Polygon getCharacter() {
        return character;
    }

    public void turnLeft() {
        character.setRotate(character.getRotate() - 5);
    }

    public void turnRight() {
        character.setRotate(character.getRotate() + 5);
    }

    public void move() {
        this.character.setTranslateX(this.character.getTranslateX() + this.movement.getX());
        this.character.setTranslateY(this.character.getTranslateY() + this.movement.getY());

        if (this.character.getTranslateX() < 0) {
            this.character.setTranslateX(this.character.getTranslateX() + AsteroidsApplication.WIDTH);
        }

        if (this.character.getTranslateX() > AsteroidsApplication.WIDTH) {
            this.character.setTranslateX(this.character.getTranslateX() % AsteroidsApplication.WIDTH);
        }

        if (this.character.getTranslateY() < 0) {
            this.character.setTranslateY(this.character.getTranslateY() + AsteroidsApplication.HEIGHT);
        }

        if (this.character.getTranslateY() > AsteroidsApplication.HEIGHT) {
            this.character.setTranslateY(this.character.getTranslateY() % AsteroidsApplication.HEIGHT);
        }
    }

    public void accelerate() {
        double changeX = Math.cos(Math.toRadians(character.getRotate()));
        double changeY = Math.sin(Math.toRadians(character.getRotate()));

        changeX *= 0.05;
        changeY *= 0.05;

        movement = movement.add(changeX, changeY);
    }

    public boolean collide(Character other) {
        Shape collisionArea = Shape.intersect(this.character, other.getCharacter());
        return collisionArea.getBoundsInLocal().getWidth() != -1;
    }
}
