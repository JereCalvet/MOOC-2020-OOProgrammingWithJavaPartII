
import java.util.Comparator;

/**
 *
 * @author Jere
 */
public class BySuitInValueOrder implements Comparator<Card>{

    @Override
    public int compare(Card firstCard, Card secondCard) {
        if (firstCard.getSuit() == secondCard.getSuit()) {
            return firstCard.getValue() - secondCard.getValue();
        }
        
        return firstCard.getSuit().compareTo(secondCard.getSuit());
    }
}
