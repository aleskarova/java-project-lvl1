package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.UserInputScanner;

public final class EvenGame extends Engine {

    private static final int MAX_RANDOM_NUMBER = 100;

    public EvenGame(String name) {
        super(name);
    }

    @Override
    protected void printGameRules() {
        System.out.println("Answer 'yes' if number even otherwise answer 'no'");
    }

    protected boolean playRound() {
        int number = GameHelper.getRandomNumber(MAX_RANDOM_NUMBER);
        System.out.println("Question: " + number);
        System.out.print("Your answer: ");
        String answer = UserInputScanner.getScanner().nextLine().trim().toLowerCase();
        return checkAnswer(answer, getCorrectAnswer(number));
    }

    private String getCorrectAnswer(final int number) {
        return (number % 2 == 0) ? "yes" : "no";
    }
}
