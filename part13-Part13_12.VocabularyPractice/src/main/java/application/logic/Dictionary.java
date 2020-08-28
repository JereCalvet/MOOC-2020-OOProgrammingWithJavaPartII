package application.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Jere
 */
public class Dictionary {
    private final List<String> words;
    private final Map<String, String> dictionary;

    public Dictionary() {
        this.words = new ArrayList<>();
        this.dictionary = new HashMap<>();
        
        add("sana", "word");
    }
    
    public String get(String word) {
        return this.dictionary.get(word);
    }

    public void add(String word, String translation) {
        if (!this.dictionary.containsKey(word)) {
            this.words.add(word);
        }

        this.dictionary.put(word, translation);
    }
    
      public String getRandomWord() {
        Random random = new Random();
        return this.words.get(random.nextInt(this.words.size()));
    }
}
