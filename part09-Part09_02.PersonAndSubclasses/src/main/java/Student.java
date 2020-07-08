
/**
 *
 * @author Jere
 */
public class Student extends Person {
    private int credits;

    public Student(String name, String street) {
        super(name, street);
        this.credits = 0;
    }
    
    public void study() {
        credits++;
    }
    
    public int credits() {
        return credits;
    }

    @Override
    public String toString() {
        return super.toString() +  "\n  Study credits " + credits; 
    }
}
