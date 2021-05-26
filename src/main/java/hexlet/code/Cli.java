package hexlet.code;

public class Cli {

    public static void greetUser() {
        System.out.print("May I have your name? ");
        String name = UserInputScanner.getScanner().nextLine();
        System.out.println("Hello, " + name + "!");
    }
}
