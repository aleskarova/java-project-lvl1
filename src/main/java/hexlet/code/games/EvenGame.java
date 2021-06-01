package hexlet.code.games;

import hexlet.code.UserInputScanner;

import java.util.Random;

public final class EvenGame {

    private static final int ROUNDS_NUMBER = 3;

    private static final int MAX_RANDOM_NUMBER = 100;

    private static final String GAME_RULES = "Answer 'yes' if number even otherwise answer 'no'";

    private int rightAnswersCount = 0;

    private final String userName;

    public EvenGame(String name) {
        this.userName = name;
    }

    public void play() {
        System.out.println(GAME_RULES);
        playGame();
        endGame();
    }

    private void playGame() {
        while (rightAnswersCount < ROUNDS_NUMBER) {
            int number = chooseRandomNumber();
            boolean roundResult = playRound(number);
            if (!roundResult) {
                break;
            }
        }
    }

    private void endGame() {
        if (rightAnswersCount == ROUNDS_NUMBER) {
            printSuccessMessage();
        }
    }

    private void printSuccessMessage() {
        System.out.println("Congratulations, " + userName + '!');
    }

    private static int chooseRandomNumber() {
        return new Random().nextInt(MAX_RANDOM_NUMBER) + 1;
    }

    private boolean playRound(final int number) {
        System.out.println("Question: " + number);
        System.out.print("Your answer: ");
        String answer = UserInputScanner.getScanner().nextLine().trim().toLowerCase();
        if (isRightAnswer(answer, number)) {
            rightAnswersCount++;
            System.out.println("Correct!");
            return true;
        } else {
            String message = "'" + answer + "' is wrong answer ;(. Correct answer was '"
                    + getCorrectAnswer(number) + "'.\n" + "Let's try again, " + userName + "!";
            System.out.println(message);
            return false;
        }
    }

    private boolean isRightAnswer(final String answer, final int number) {
        return answer.equals(getCorrectAnswer(number));
    }

    private String getCorrectAnswer(final int number) {
        return (number % 2 == 0) ? "yes" : "no";
    }
}
