import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Jere
 */
public class Employees {
    private final List<Person> personCollection;

    public Employees() {
        this.personCollection = new ArrayList<>();
    }
    
    public void add(Person personToAdd) {
        this.personCollection.add(personToAdd);
    }
    
    public void add(List<Person> peopleToAdd) {
        peopleToAdd.stream().forEach(person -> this.add(person));
    }
    
    public void print() {
        Iterator<Person> it = personCollection.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
    
    public void print(Education education) {
        Iterator<Person> it = personCollection.iterator();
        while (it.hasNext()) {
            Person personToFilter = it.next();
            if (personToFilter.getEducation().equals(education)) {
                System.out.println(personToFilter);
            }
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> it = personCollection.iterator();
        while (it.hasNext()) {
            if (it.next().getEducation().equals(education)) {
                it.remove();
            }
        }
    }
}
