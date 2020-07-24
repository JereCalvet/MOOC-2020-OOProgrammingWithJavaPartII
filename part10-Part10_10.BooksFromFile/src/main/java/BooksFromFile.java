
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BooksFromFile {

    public static List<Book> readBooks(String file) {
        List<Book> booksCollection = new ArrayList<>();
        try {
            booksCollection = Files.lines(Paths.get(file))
                    .map(row -> row.split(",")) //file format: name,publishing year,page count,author
                    .map(bookInfo -> new Book(bookInfo[0], Integer.valueOf(bookInfo[1]), Integer.valueOf(bookInfo[2]), bookInfo[3]))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return booksCollection;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here
    }
}
