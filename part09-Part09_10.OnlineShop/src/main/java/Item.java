
/**
 *
 * @author Jere
 */
public class Item {

    private final String name;
    private int quantity;
    private final int unitPrice;

    public Item(String product, int qty, int unitPrice) {
        this.name = product;
        this.quantity = qty;
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public int price() {
        return unitPrice * quantity;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public void increaseQuantity() {
        quantity++;
    }

    @Override
    public String toString() {
        return name + ": " + quantity;
    }   
}
