
public class Program {

    public static int sum(int[] array, int fromWhere, int toWhere, int smallest, int largest) {
        if (fromWhere < 0) fromWhere = 0;
        if (toWhere > array.length) toWhere = array.length;
        int sum = 0;
        for (; fromWhere < toWhere; fromWhere++) {
            if (array[fromWhere] >= smallest && array[fromWhere] <= largest) {
                sum += array[fromWhere];
            }
        }
        return sum;
    }
    
    public static void main(String[] args) {
    }
}
