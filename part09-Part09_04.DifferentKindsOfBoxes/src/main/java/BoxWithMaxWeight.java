
import java.util.ArrayList;


/**
 *
 * @author Jere
 */
public class BoxWithMaxWeight extends Box {
    
    private final ArrayList<Item> items;
    private int capacity;

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }
    
    private int currentWeight() {
        return items.stream().mapToInt(item -> item.getWeight()).sum();
    }
    
    @Override
    public void add(Item item) {
        if (capacity >= item.getWeight() + currentWeight()) {
            items.add(item);
        }   
    }

    @Override
    public boolean isInBox(Item item) {
        return items.stream().anyMatch(isItem -> isItem.equals(item));
    }    
}
