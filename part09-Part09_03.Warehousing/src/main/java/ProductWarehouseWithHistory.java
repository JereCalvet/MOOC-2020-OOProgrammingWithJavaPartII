
/**
 *
 * @author Jere
 */
public class ProductWarehouseWithHistory extends ProductWarehouse {

    private final ChangeHistory priceHistory;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        this.priceHistory = new ChangeHistory();
        setInitialBalance(initialBalance);
    }

    private void setInitialBalance(double initialBalance) {
        priceHistory.add(initialBalance);
        super.addToWarehouse(initialBalance);
    }

    public String history() {
        return priceHistory.toString();
    }

    public void printAnalysis() {
        System.out.println("Product: " + super.getName() + "\n" +
                           "History: " + priceHistory + "\n" +
                           "Largest amount of product: " + priceHistory.maxValue() + "\n" +
                           "Smallest amount of product:" + priceHistory.minValue() + "\n" +
                           "Average: " + priceHistory.average());
    }
    
    @Override
    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        priceHistory.add(super.getBalance());
    }
    
    @Override
    public double takeFromWarehouse(double amount) {
        double amountTaken = super.takeFromWarehouse(amount);
        priceHistory.add(super.getBalance());
        return amountTaken;
    }
    
    @Override
    public String toString() {
        return priceHistory.toString();
    }
}
