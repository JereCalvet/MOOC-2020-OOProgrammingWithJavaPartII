package FlightControl.domain;

/**
 *
 * @author Jere
 */
public class Airplane {
    private final String ID;
    private final int capacity;

    public Airplane(String ID, int capacity) {
        this.ID = ID;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return ID + " (" + capacity + " capacity)";
    }
}
