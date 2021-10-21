package demo;

import java.util.Scanner;

public class UserInterface {

    private Scanner scanner = new Scanner(System.in);

    public String getIssueDescription() {
        System.out.print("Enter issue description : ");
        String description = scanner.nextLine();
        return description;
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printMainMenu() {
        System.out.println("1. Create issue (user)");
        System.out.println("2. Validate issue (admin)");
        System.out.println("3. Show all active issues (user)");
        System.out.println("4. Exit");
    }

    public int getChoice() {
        System.out.print("Choose: ");
        String description = scanner.nextLine();
        return Integer.parseInt(description);
    }
}
