package hexlet.code.games;

import hexlet.code.UserInputScanner;

import java.util.Random;

public class EvenGame extends Game {

    private static final int ROUNDS_NUMBER = 3;

    private static final String gameRules = "Answer 'yes' if number even otherwise answer 'no'";

    private int rightAnswersCount = 0;

    private final String userName;

    public EvenGame(String userName) {
        this.userName = userName;
    }

    @Override
    public void play() {
        System.out.println(gameRules);
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
        return new Random().nextInt(1000) + 1;
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
            String message = "'" + answer + "' is wrong answer ;(. Correct answer was '" +
                    getCorrectAnswer(number) + "'.\n" +
                    "Let's try again, " + userName + "!";
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
