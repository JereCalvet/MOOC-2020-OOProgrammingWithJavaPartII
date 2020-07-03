
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Jere
 */
public class Abbreviations {
    private final Map<String, String> dictionary;

    public Abbreviations() {
        this.dictionary = new HashMap<>();
    }
    
    public void addAbbreviation(String abbreviation, String explanation) {
        dictionary.put(abbreviation, explanation);
    }
    
    public boolean hasAbbreviation(String abbreviation) {
        return dictionary.containsKey(abbreviation);
    }
    
    public String findExplanationFor(String abbreviation) {
        return dictionary.get(abbreviation);
    }
}
