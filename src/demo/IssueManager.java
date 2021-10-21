package demo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class IssueManager {
    private FileHandler fileHandler = new FileHandler();
    private UserInterface ui = new UserInterface();
    private static final String FILE_PATH = "data/pending.txt";
    private static final String FILE_PATH_ACCEPTED = "data/accepted.txt";

    public void run() throws FileNotFoundException {
        boolean stop = false;

        while (!stop) {
            ui.printMainMenu();
            int answer = ui.getChoice();
            switch (answer) {
                case 1:
                    createNewIssue();
                    break;
                case 2:
                    validatePendingIssues();
                    break;
                case 3:
                    fileHandler.viewIssues(FILE_PATH_ACCEPTED);
                    break;
                case 4:
                    stop = true;
                    break;
                default:
                    ui.printErrorMessage("Invalid choice.");
                    stop = true;
                    break;
            }
        }
    }

    public void createNewIssue() {
        String text = ui.getIssueDescription();
        //text = "Type conversion problem: How to convert a String to integer";
        Issue issue = new Issue(text);
        try {
            fileHandler.saveNewIssue(FILE_PATH, issue);
        } catch (FileNotFoundException e) {
            ui.printErrorMessage(e.getMessage());
        }
        System.out.println("'" + text + "' has been sent for approval to admin");
        System.out.println();
    }

    public void validatePendingIssues() throws FileNotFoundException {
        ArrayList<Issue> saved = null;
        try {
            saved = fileHandler.readPendingIssues(FILE_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        listIssues(saved);
        System.out.print("Type the number left to the issue that you want to accept: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        fileHandler.acceptIssue(choice, FILE_PATH, FILE_PATH_ACCEPTED);

    }

    public void listIssues(ArrayList<Issue> issues) {
        String issue = "";
        System.out.println("List of pending issues:");
        for (int i = 0; i < issues.size(); i++) {
            issue = issues.get(i).toString();
            System.out.println(i + 1 + " " + issue);
        }
        System.out.println();
    }

}
