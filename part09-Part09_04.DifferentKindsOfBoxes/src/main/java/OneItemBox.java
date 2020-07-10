
/**
 *
 * @author Jere
 */
public class OneItemBox extends Box {

    private Item itemInTheBox;

    public OneItemBox() {
        this.itemInTheBox = null;
    }
    
    @Override
    public void add(Item item) {
        if (itemInTheBox == null) {
            itemInTheBox = item;
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return item.equals(itemInTheBox);
    }
}
