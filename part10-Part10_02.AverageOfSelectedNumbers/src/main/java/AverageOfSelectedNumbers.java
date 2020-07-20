
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    static double avgNegativeNumbers(List<String> numbers) {
        return numbers.stream().mapToInt(num -> Integer.valueOf(num)).filter(num -> num < 0).average().getAsDouble();
    } 
    
    static double avgPositiveNumbers(List<String> numbers) {
        return numbers.stream().mapToInt(num -> Integer.valueOf(num)).filter(num -> num > 0).average().getAsDouble();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> numbers = new ArrayList<>();
        System.out.println("Input numbers, type \"end\" to stop.");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            numbers.add(input);
        }
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String inputCommand = scanner.nextLine();
        System.out.println(inputCommand.equals("n") ? avgNegativeNumbers(numbers): avgPositiveNumbers(numbers));
    }
}
