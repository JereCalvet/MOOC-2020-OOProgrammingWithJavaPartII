
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jere
 */
public class Box implements Packable {

    private final List<Packable> boxItems;
    private final double capacity;

    public Box(double capacity) {
        this.capacity = capacity;
        this.boxItems = new ArrayList<>();
    }

    public void add(Packable item) {
        if (capacity >= item.weight() + this.weight()) {
            boxItems.add(item);
        }
    }

    @Override
    public String toString() {
        return "Box: " + boxItems.size() + " items, total weight " + weight() + " kg";
    }

    @Override
    public double weight() {
        return boxItems.stream().mapToDouble(item -> item.weight()).sum();
    }
}
