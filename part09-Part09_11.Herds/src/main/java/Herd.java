
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jere
 */
public class Herd implements Movable {

    private List<Movable> herd;

    public Herd() {
        this.herd = new ArrayList<>();
    }

    public void addToHerd(Movable movable) {
        herd.add(movable);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String result = "";
        herd.stream().forEach(x -> builder.append(x).append("\n"));
        if (!builder.toString().isEmpty()) {
            result = builder.substring(0, builder.length() - 1);
        }
        return result;
    }

    @Override
    public void move(int dx, int dy) {
        herd.forEach((participant) -> {
            participant.move(dx, dy);
        });
    }
}
