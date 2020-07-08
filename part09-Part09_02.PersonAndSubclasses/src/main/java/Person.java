
/**
 *
 * @author Jere
 */
public class Person {

    private final String name;
    private final String street;

    public Person(String name, String street) {
        this.name = name;
        this.street = street;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }
    
    @Override
    public String toString() {
        return name + "\n  " + street;
    }
}
