
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
                    //.sorted((x, y) -> x[5].compareTo(y[5])) this works but is bad
                    .sorted((x, y) -> { return Double.valueOf(x[5]) < Double.valueOf(y[5]) ? -1 : 1;})
                    .forEach(row -> System.out.println(row[3] + " (" + row[4] + "), " + row[2].replaceAll("[^a-zA-Z]", "") + ", " + row[5]));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
