
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();
        while (true) {
            System.out.print("Input the name of the book, empty stops: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }
            System.out.print("Input the age recommendation: ");
            String age = scanner.nextLine();
            books.add(new Book(name, Integer.valueOf(age)));
            System.out.println("");
        }
        System.out.println("\n"+books.size() + " books in total.\n\nBooks:");
        Comparator<Book> compareAgeThenName = Comparator.comparing(Book::getAgeRecommended).thenComparing(Book::getName);
        Collections.sort(books, compareAgeThenName);
        books.stream().forEach(System.out::println);
    }
}
