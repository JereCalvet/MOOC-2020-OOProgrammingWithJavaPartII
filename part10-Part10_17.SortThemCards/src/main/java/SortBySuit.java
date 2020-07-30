
import java.util.Comparator;

/**
 *
 * @author Jere
 */
public class SortBySuit implements Comparator<Card> {

    @Override
    public int compare(Card firstCard, Card secondCard) {
        return firstCard.getSuit().ordinal() - secondCard.getSuit().ordinal();
    }
}
