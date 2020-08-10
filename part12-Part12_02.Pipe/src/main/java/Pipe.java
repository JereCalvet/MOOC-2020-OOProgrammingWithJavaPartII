
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jere
 */
public class Pipe<T> {

    private List<T> elementCollection;

    public Pipe() {
        this.elementCollection = new ArrayList<>();
    }

    public void putIntoPipe(T value) {
        elementCollection.add(value);
    }

    public T takeFromPipe() {
        if (isInPipe()) {
            T element = elementCollection.get(0);
            elementCollection.remove(element);
            return element;
        }

        return null;
    }

    public boolean isInPipe() {
        return !elementCollection.isEmpty();
    }
}
