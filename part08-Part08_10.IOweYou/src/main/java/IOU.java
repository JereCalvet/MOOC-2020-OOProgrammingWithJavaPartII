
import java.util.HashMap;

/**
 *
 * @author Jere
 */
public class IOU {
    private final HashMap<String, Double> iou;

    public IOU() {
        this.iou = new HashMap<String, Double>();
    }
    
    public void setSum(String toWhom, double amount) {
        double currentAmount = howMuchDoIOweTo(toWhom);
        currentAmount += amount;
        iou.put(toWhom, currentAmount);
    }
    
    public double howMuchDoIOweTo(String toWhom) {
        return iou.getOrDefault(toWhom, 0.0);
    }
}
