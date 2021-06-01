package hexlet.code;

public class Cli {

    public static String greetUser() {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = UserInputScanner.getScanner().nextLine();
        System.out.println("Hello, " + name + "!");
        return name;
    }
}
