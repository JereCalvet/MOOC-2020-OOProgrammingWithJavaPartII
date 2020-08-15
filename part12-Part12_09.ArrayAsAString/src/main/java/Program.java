
public class Program {

    public static String arrayAsString(int[][] array) {
        StringBuilder arrayValuesAsString = new StringBuilder();
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                arrayValuesAsString.append(array[row][col]);
            }
            arrayValuesAsString.append("\n");
        }
        return arrayValuesAsString.toString();
    }

    public static void main(String[] args) {
    }
}
