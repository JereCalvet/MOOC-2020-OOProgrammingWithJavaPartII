package asteroids.logic;

import java.util.Random;

/**
 *
 * @author Jere
 */
public class Asteroid extends Character {

    private double rotationalMovement;

    public Asteroid(int x, int y) {
        super(new PolygonFactory().createPolygon(), x, y);

        Random rnd = new Random();

        super.getCharacter().setRotate(rnd.nextInt(360));

        int accelerationAmount = 1 + rnd.nextInt(10);
        for (int i = 0; i < accelerationAmount; i++) {
            accelerate();
        }

        this.rotationalMovement = 0.5 - rnd.nextDouble();
    }

    @Override
    public void move() {
        super.move();
        super.getCharacter().setRotate(super.getCharacter().getRotate() + rotationalMovement);
    }
}
