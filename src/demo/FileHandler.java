package demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    public void saveNewIssue(String FILE_PATH, Issue issue) throws FileNotFoundException {
        File file = new File(FILE_PATH);
        PrintStream ps = new PrintStream(new FileOutputStream(file, true));
        ps.println(issue.toString());
        ps.close();
    }

    public ArrayList<Issue> readPendingIssues(String FILE_PATH) throws FileNotFoundException {
        File file = new File(FILE_PATH);
        Scanner scanner = new Scanner(file);
        ArrayList<Issue> issues = new ArrayList<>();
        Issue issue = null;
        while (scanner.hasNext()) {
            String description = scanner.nextLine();
            issues.add(new Issue(description));
        }

        return issues;
    }

    public void deleteContents(String fileName) throws FileNotFoundException {
        new PrintStream(fileName).close();
    }

    public void acceptIssue(int n, String FILE_PATH, String FILE_PATH_ACCEPTED) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(FILE_PATH));
        for (int i = 0; i < n - 1; i++) {
            scanner.nextLine();
        }
        String issue = scanner.nextLine();
        File file = new File(FILE_PATH_ACCEPTED);
        PrintStream ps = new PrintStream(new FileOutputStream(file, true));
        ps.println(issue);
    }

    public void viewIssues(String FILE_PATH_ACCEPTED) throws FileNotFoundException {
        File file = new File(FILE_PATH_ACCEPTED);
        Scanner scanner = new Scanner(file);

        System.out.println("List of active issues:");
        while (scanner.hasNextLine()) {
            String issue = scanner.nextLine();
            System.out.println(issue);
        }
        System.out.println();
    }
}
