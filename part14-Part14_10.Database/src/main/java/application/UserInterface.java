package application;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    private void list() {
        System.out.println("Listing the database contents \n");
        try {
            database.list().stream().forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void add() {
        System.out.println("Adding a new todo \n");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        try {
            database.add(new Todo(name, description, false));
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void markAsDone() {
        System.out.println("Which todo should be marked as done (give the id)?");
        int id = Integer.valueOf(scanner.nextLine());

        try {
            database.markAsDone(id);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void remove() {
        System.out.println("Which todo should be removed (give the id)?");
        int id = Integer.valueOf(scanner.nextLine());

        try {
            database.remove(id);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            System.out.println("");
            if (command.equals("x")) {
                break;
            }

            switch (command) {
                case "1":
                    list();
                    break;
                case "2":
                    add();
                    break;
                case "3":
                    markAsDone();
                    break;
                case "4":
                    remove();
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
        System.out.println("Thank you!");
    }
}
