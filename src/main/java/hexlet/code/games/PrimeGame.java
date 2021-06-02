package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.UserInputScanner;

public final class PrimeGame extends Engine {

    private static final int MAX_RANDOM_NUMBER = 1000;

    public PrimeGame(String name) {
        super(name);
    }

    @Override
    protected void printGameRules() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    @Override
    protected boolean playRound() {
        int number = GameHelper.getRandomNumber(MAX_RANDOM_NUMBER);
        System.out.println("Question: " + number);
        System.out.print("Your answer: ");
        String answer = UserInputScanner.getScanner().nextLine();
        return checkAnswer(answer, getCorrectAnswer(number));
    }

    private String getCorrectAnswer(int number) {
        return (isPrimeNumber(number)) ? "yes" : "no";
    }

    private static boolean isPrimeNumber(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
