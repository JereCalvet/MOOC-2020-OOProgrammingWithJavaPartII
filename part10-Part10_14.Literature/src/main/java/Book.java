/**
 *
 * @author Jere
 */
public class Book {
    private final String name;
    private int ageRecommended;

    public Book(String name, int ageRecommended) {
        this.name = name;
        this.ageRecommended = ageRecommended;
    }

    public int getAgeRecommended() {
        return ageRecommended;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (recommended for " + ageRecommended + " year-olds or older)";
    }
}
