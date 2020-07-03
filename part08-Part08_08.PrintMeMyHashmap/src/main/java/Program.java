
import java.util.HashMap;
import java.util.stream.Collectors;

public class Program {

    public static void printKeys(HashMap<String, String> hashmap) {
        for (String key : hashmap.keySet()) {
            System.out.println(key);
        }
    }

    public static void printKeysWhere(HashMap<String, String> hashmap, String text) {
        for (String key : hashmap.keySet()) {
            if (key.contains(text)) {
                System.out.println(key);
            }
        }
//        hashmap.keySet().stream().filter(key -> key.contains(text)).findFirst().ifPresent(System.out::println);

    }

    public static void printValuesOfKeysWhere(HashMap<String, String> hashmap, String text) {
        for (String key : hashmap.keySet()) {
            if (key.contains(text)) {
                System.out.println(hashmap.get(key));
            }
        }
//        hashmap.entrySet().stream().filter(value -> value.getKey().contains(text)).findFirst().map(keySet -> keySet.getValue()).ifPresent(System.out::println);
    }

    public static void main(String[] args) {
    }
}
