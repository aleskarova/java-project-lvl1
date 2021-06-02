package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.UserInputScanner;

public class GcdGame extends Engine {

    private static final int MAX_RANDOM_NUMBER = 1000;

    public GcdGame(String name) {
        super(name);
    }

    @Override
    protected final void printGameRules() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    @Override
    protected final boolean playRound() {
        int number1 = GameHelper.getRandomNumber(MAX_RANDOM_NUMBER);
        int number2 = GameHelper.getRandomNumber(MAX_RANDOM_NUMBER);
        System.out.printf("Question: %d %d\n", number1, number2);
        System.out.print("Your answer: ");
        String answer = UserInputScanner.getScanner().nextLine();
        return checkAnswer(answer, Integer.toString(getGCD(number1, number2)));
    }

    private static int getGCD(int n1, int n2) {
        while (n1 != n2) {
            if (n1 > n2) {
                n1 -= n2;
            } else {
                n2 -= n1;
            }
        }
        return n1;
    }
}
