
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {

    private ArrayList<Integer> numbers;

    public LotteryRow() {
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return numbers;
    }

//    private int getRandomNumber() {
//        Random random = new Random();
//        int randomNumber = random.nextInt(40) + 1;
//        if (numbers.contains(randomNumber)) {
//            getRandomNumber();
//        }
//        return randomNumber;
//    }
//    private void withdrawSeverNumbers() {
//        for (int i = 0; i < 7; i++) {
//            numbers.add(getRandomNumber());
//        }
//    }
    public void randomizeNumbers() {
        //this test can't handle recursion. If you like bad code, I give you bad code.
        //the commented code was the original version.
        numbers = new ArrayList<>();
//        withdrawSeverNumbers();
        int counter = 0;
        while (counter++ < 7) {
            Random random = new Random();
            int numToAdd = random.nextInt(40) + 1;
            while (numbers.contains(numToAdd)) {
                numToAdd = random.nextInt(40) + 1;
            }
            numbers.add(numToAdd);
        }
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }
}
