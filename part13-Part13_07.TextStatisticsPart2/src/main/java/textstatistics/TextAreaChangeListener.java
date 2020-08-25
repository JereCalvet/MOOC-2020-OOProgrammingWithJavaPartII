package textstatistics;
//This class should be in a package called textstatistics.userinterface but server wont compile

import textstatistics.logic.TextStatisticsLogic;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;

/**
 *
 * @author Jere
 */

public class TextAreaChangeListener implements ChangeListener {
    private final TextStatisticsLogic logic;
    private final Label letters;
    private final Label words;
    private final Label longestWord;

    public TextAreaChangeListener(TextStatisticsLogic logic, Label labelLetters, Label labelWords, Label labelLongestWord) {
        this.logic = logic;
        this.letters = labelLetters;
        this.words = labelWords;
        this.longestWord = labelLongestWord;
    }
    
    @Override
    public void changed(ObservableValue changed, Object oldValue, Object newValue) {
        logic.setText(String.valueOf(newValue));
        letters.setText("Letters: " + logic.getAmountOfCharacters());
        words.setText("Words: " + logic.getAmountOfWords());
        longestWord.setText("The longest word is: " + logic.getLongestWord());
    }
}
