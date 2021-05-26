package hexlet.code;

import java.util.Scanner;

public class UserInputScanner {
    private static Scanner scanner;

    private UserInputScanner() {}

    static public Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
