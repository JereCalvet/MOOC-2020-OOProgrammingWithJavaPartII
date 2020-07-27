
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        try {
            //row input format: 
            //Adult literacy rate, population 15+ years, male (%),Angola,2014,82.15105
            //row desired output format:
            //Niger (2015), female, 11.01572
            Files.lines(Paths.get("literacy.csv")).map(x -> x.split(","))
                    .sorted((x, y) -> x[5].compareTo(y[5]))
                    .forEach(row -> System.out.println(row[3] + " (" + row[4] + "), " + row[2].split(" ")[1].trim() + ", " + row[5]));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
