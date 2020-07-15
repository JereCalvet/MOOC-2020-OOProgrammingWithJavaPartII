
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Jere
 */
public class Warehouse {

    private final Map<String, Integer> productPrice;
    private final Map<String, Integer> productStock;

    public Warehouse() {
        this.productPrice = new HashMap<>();
        this.productStock = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock) {
        productStock.put(product, stock);
        productPrice.put(product, price);
    }
    
    public int price(String product) {
        return productPrice.getOrDefault(product, -99);
    }
    
    public int stock(String product) {
        return productStock.getOrDefault(product, 0);
    }
    
    public boolean take(String product) {
        int currentStock = stock(product);
        if (currentStock > 0 ) {
            productStock.put(product, currentStock - 1);
            return true;
        }
        return false;
    }
    
    public Set<String> products() {
        return new HashSet<>(productStock.keySet());
    }
}
