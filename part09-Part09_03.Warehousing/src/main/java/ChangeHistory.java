
import java.util.ArrayList;

/**
 *
 * @author Jere
 */
public class ChangeHistory {
    private final ArrayList<Double> priceHistory;

    public ChangeHistory() {
        this.priceHistory = new ArrayList<>();
    }
    
    public void add(double status) {
        priceHistory.add(status);
    }
    
    public void clear() {
        priceHistory.clear();
    }
    
    public double maxValue() {
        return priceHistory.stream().mapToDouble(x -> x).max().orElse(0.0);
    }
    
    public double minValue() {
        return priceHistory.stream().mapToDouble(x -> x).min().orElse(0.0);
    }
    
    public double average() {
        return priceHistory.stream().mapToDouble(x -> x).average().orElse(0.0);
    }
    
    @Override
    public String toString() {
        return priceHistory.toString();
    }
}
