package hexlet.code;

import java.util.Scanner;

public final class UserInputScanner {
    private static Scanner scanner;

    private UserInputScanner() { }

    public static Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
