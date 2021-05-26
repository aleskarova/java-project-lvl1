package hexlet.code;

public class App {
    public static void main(String[] args) {
        String gameNumber = getGameNumber();
        if ("1".equals(gameNumber.trim())) {
            System.out.println("Welcome to the Brain Games!");
            Cli.greetUser();
        }
    }

    private static String getGameNumber() {
        System.out.println("Please enter the game number and press Enter");
        System.out.println("1 - Greet");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        return UserInputScanner.getScanner().nextLine();
    }
}
