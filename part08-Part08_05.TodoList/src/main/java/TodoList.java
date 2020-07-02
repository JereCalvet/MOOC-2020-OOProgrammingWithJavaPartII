
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jere
 */
public class TodoList {
    private List<String> todoList;

    public TodoList() {
        this.todoList = new ArrayList<>();
    }
    
    public void add(String task) {
        todoList.add(task);
    }
    
    public void print() {
        for (String string : todoList) {
            System.out.println((todoList.indexOf(string) + 1) + ": " + string);
        }
    }
    
    public void remove (int number) {
        todoList.remove(todoList.get(number - 1));
    }
}
