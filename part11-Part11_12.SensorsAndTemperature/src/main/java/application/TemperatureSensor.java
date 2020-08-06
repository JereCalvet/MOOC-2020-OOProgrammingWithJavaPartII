package application;

import java.util.Random;

/**
 *
 * @author Jere
 */
public class TemperatureSensor implements Sensor {
    
    private int value;
    private boolean status;

    public TemperatureSensor() {
        this.status = false;
    }
    
    @Override
    public boolean isOn() {
        return status;
    }

    @Override
    public void setOn() {
        status = true;
    }

    @Override
    public void setOff() {
        status = false;
    }

    @Override
    public int read() {
        if (!this.isOn()) {
            throw new IllegalStateException("sensor is off");
        }
        Random random = new Random();
        int max = 30;
        int min = -30;
        value = random.nextInt((max - min) + 1) + min;
        return value;
    }
}
