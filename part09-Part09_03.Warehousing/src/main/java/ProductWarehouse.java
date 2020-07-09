/**
 *
 * @author Jere
 */
public class ProductWarehouse extends Warehouse {
    
    private String product;

    public ProductWarehouse(String productName, double capacity) {
        super(capacity);
        this.product = productName;
    }

    public String getName() {
        return product;
    }

    public void setName(String product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return product + ": " + super.toString(); 
    }
}


