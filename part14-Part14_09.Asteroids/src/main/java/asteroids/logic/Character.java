package asteroids.logic;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;

/**
 *
 * @author Jere
 */
public abstract class Character {

    private Polygon character;
    private Point2D movement;

    public Character(Polygon character, int x, int y) {
        this.character = character;
        this.character.setTranslateX(x);
        this.character.setTranslateY(y);
        movement = new Point2D(0, 0);
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
        character.setTranslateX(character.getTranslateX() + movement.getX());
        character.setTranslateY(character.getTranslateY() + movement.getY());
    }
    
    public void accelerate() {
        double changeX = Math.cos(Math.toRadians(character.getRotate()));
        double changeY = Math.sin(Math.toRadians(character.getRotate()));
        
        changeX *= 0.05; 
        changeY *= 0.05; 
        
        movement = movement.add(changeX, changeY);
    }
}
