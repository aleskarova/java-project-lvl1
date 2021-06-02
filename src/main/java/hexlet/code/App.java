package hexlet.code;

import hexlet.code.games.CalculatorGame;
import hexlet.code.games.EvenGame;

public class App {

    private static final int EXIT_COMMAND = 0;
    private static final int GREET_COMMAND = 1;
    private static final int EVEN_GAME_COMMAND = 2;
    private static final int CALCULATOR_GAME_COMMAND = 3;


    public static void main(String[] args) {
        try {
            int gameNumber = Integer.parseInt(getGameNumber());
            switch (gameNumber) {
                case GREET_COMMAND:
                    Cli.greetUser();
                    break;
                case EVEN_GAME_COMMAND:
                    new EvenGame(Cli.greetUser()).play();
                    break;
                case CALCULATOR_GAME_COMMAND:
                    new CalculatorGame(Cli.greetUser()).play();
                case EXIT_COMMAND:
                    break;
                default:
                    System.out.println("There is no such game number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid game number.");
        }

    }

    private static String getGameNumber() {
        System.out.println("Please enter the game number and press Enter");
        System.out.println(GREET_COMMAND + " - Greet");
        System.out.println(EVEN_GAME_COMMAND + " - Even");
        System.out.println(CALCULATOR_GAME_COMMAND + " - Calculator");
        System.out.println(EXIT_COMMAND + " - Exit");
        System.out.print("Your choice: ");
        return UserInputScanner.getScanner().nextLine();
    }
}
