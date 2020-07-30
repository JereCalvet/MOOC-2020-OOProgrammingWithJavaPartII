
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Jere
 */
public class Hand implements Comparable<Hand> {
    private List<Card> cardsInHand;

    public Hand() {
        this.cardsInHand = new ArrayList<>();
    }
    
    public int getHandValue() {
        return cardsInHand.stream().mapToInt(Card::getValue).sum();
    }
    
    public void add(Card cardToAdd) {
        cardsInHand.add(cardToAdd);
    }
    
    public void sort() {
        Collections.sort(cardsInHand);
    }
    
    public void print() {
        cardsInHand.stream().forEach(System.out::println);
    }

    public void sortBySuit() {
        BySuitInValueOrder sort = new BySuitInValueOrder();
        Collections.sort(cardsInHand, sort);
    }
    
    @Override
    public int compareTo(Hand otherHand) {
        return this.getHandValue() - otherHand.getHandValue();
    }
}
