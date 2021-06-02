package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.UserInputScanner;

import java.util.Random;

public final class EvenGame extends Engine {

    private static final int MAX_RANDOM_NUMBER = 100;

    public EvenGame(String userName) {
        super(userName);
    }

    @Override
    protected void printGameRules() {
        System.out.println("Answer 'yes' if number even otherwise answer 'no'");
    }

    protected boolean playRound() {
        int number = chooseRandomNumber();
        System.out.println("Question: " + number);
        System.out.print("Your answer: ");
        String answer = UserInputScanner.getScanner().nextLine().trim().toLowerCase();
        return checkAnswer(answer, getCorrectAnswer(number));
    }

    private static int chooseRandomNumber() {
        return new Random().nextInt(MAX_RANDOM_NUMBER) + 1;
    }

    private String getCorrectAnswer(final int number) {
        return (number % 2 == 0) ? "yes" : "no";
    }
}
