package application;

/**
 *
 * @author Jere
 */
public class StandardSensor implements Sensor {

    private int value;

    public StandardSensor(int value) {
        this.value = value;
    }
      
    public boolean isOn() {
        return true;
    }

    @Override
    public void setOn() {
    }

    @Override
    public void setOff() {
    }

    @Override
    public int read() {
        return value;
    }
}
