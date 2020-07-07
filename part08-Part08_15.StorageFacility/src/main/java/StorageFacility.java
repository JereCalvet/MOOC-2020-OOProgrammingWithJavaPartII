
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 *
 * @author Jere
 */
public class StorageFacility {

    private final HashMap<String, ArrayList<String>> storeUnit;

    public StorageFacility() {
        this.storeUnit = new HashMap<>();
    }

    public void add(String unit, String item) {
        storeUnit.putIfAbsent(unit, new ArrayList<>());
        storeUnit.get(unit).add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        return storeUnit.getOrDefault(storageUnit, new ArrayList<>());
    }

    public void remove(String storageUnit, String item) {
        ArrayList<String> unit = contents(storageUnit);
        if (!unit.isEmpty()) {
            unit.remove(item);
            if (unit.isEmpty()) {
                storeUnit.remove(storageUnit);
            }
        }
    }

    public ArrayList<String> storageUnits() {
        ArrayList<String> result = new ArrayList<>();
        for (String key : storeUnit.keySet()) {
            if (!storeUnit.get(key).isEmpty()) {
                result.add(key);
            }
        }
        return result;
    }
}
