
/**
 *
 * @author Jere
 */
public class Hideout<T> {

    private T element;

    public void putIntoHideout(T toHide) {
        if (element != null) {
            element = null;
        }
        element = toHide;
    }
    
    public T takeFromHideout() {
        if (isInHideout()) {
            T result = element;
            element = null;
            return result;
        }
        return element;
    }
    
    public boolean isInHideout() {
        return element != null;
    }
}
