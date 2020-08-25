package title;

import java.util.Scanner;
import javafx.application.Application;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert your name:");
        String name = sc.nextLine();
        System.out.println("Insert a title:");
        String title = sc.nextLine();
        Application.launch(UserTitle.class,"--User=" + name,"--Title="+title);
    }
}
