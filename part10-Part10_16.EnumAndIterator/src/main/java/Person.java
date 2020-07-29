/**
 *
 * @author Jere
 */
public class Person {
    private final String name;
    private final Education education;

    public Person(String name, Education education) {
        this.name = name;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public Education getEducation() {
        return education;
    }

    @Override
    public String toString() {
        return name + ", " + education;
    }
}
