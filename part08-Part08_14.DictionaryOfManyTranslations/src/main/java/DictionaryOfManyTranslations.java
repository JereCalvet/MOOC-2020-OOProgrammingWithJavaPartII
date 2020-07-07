
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Jere
 */
public class DictionaryOfManyTranslations {

    private final HashMap<String, ArrayList<String>> dictionary;

    public DictionaryOfManyTranslations() {
        this.dictionary = new HashMap<>();
    }

    public void add(String word, String translation) {
        dictionary.putIfAbsent(word, new ArrayList<>());
        dictionary.get(word).add(translation);
    }

    public ArrayList<String> translate(String word) {
        return dictionary.getOrDefault(word, new ArrayList<>());
    }

    public void remove(String word) {
        dictionary.remove(word);
    }
}
