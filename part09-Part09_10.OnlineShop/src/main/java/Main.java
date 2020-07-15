
public class Main {

    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();
        cart.add("milk", 3);
        cart.add("buttermilk", 2);
        cart.add("cheese", 5);
        cart.add("computer", 899);

        cart.print();
    }
}
