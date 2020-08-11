
public class Program {

    public static void main(String[] args) {
        CustomList<Integer> myList = new CustomList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        
        myList.remove(3);
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
    }

}
