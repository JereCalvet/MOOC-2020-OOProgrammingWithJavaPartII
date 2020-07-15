
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jere
 */
public class ShoppingCart {

    private final List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void add(String product, int price) {
        Item tempItem = new Item(product, price, 1);
        if (items.contains(tempItem)) {
            tempItem.increaseQuantity();
        } else {
            items.add(tempItem);
        }
    }

    public int price() {
        return items.stream().mapToInt(item -> item.price()).sum();
    }

    public void print() {
        items.stream().forEach(System.out::println);
    }
}
