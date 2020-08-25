package textstatistics.logic;

import java.util.Arrays;

/**
 *
 * @author Jere
 */
public class TextStatisticsLogic {

    private String text;

    public TextStatisticsLogic() {
        this.text = "";
    }

    public TextStatisticsLogic(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String[] splitText() {
        return text.split(" ");
    }

    public int getAmountOfWords() {
        if (text.isEmpty()) {
            return 0;
        }
        return splitText().length;
    }

    public String getLongestWord() {
        return Arrays.stream(splitText()).sorted((w1, w2) -> w2.length() - w1.length()).findFirst().orElse("");
    }

    public int getAmountOfCharacters() {
        return text.length();
    }
}
