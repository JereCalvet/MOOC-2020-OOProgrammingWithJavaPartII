
import java.util.Objects;


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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
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
