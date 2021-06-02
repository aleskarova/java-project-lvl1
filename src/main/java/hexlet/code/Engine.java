package hexlet.code;

public abstract class Engine {

    protected static final int ROUNDS_NUMBER = 3;

    private final String userName;

    private int rightAnswersCount = 0;

    public Engine(String name) {
        this.userName = name;
    }

    /**
     * Main method to run the game.
     */
    public void play() {
        printGameRules();
        playGame();
        endGame();
    }

    protected abstract void printGameRules();

    protected abstract boolean playRound();

    /**
     * Plays all rounds of the game.
     */
    protected void playGame() {
        while (rightAnswersCount < ROUNDS_NUMBER) {
            boolean roundResult = playRound();
            if (!roundResult) {
                break;
            }
        }
    }

    /**
     * @param userAnswer answer from user
     * @param expectedAnswer correct answer
     * @return true if userAnswer is correct
     */
    protected boolean checkAnswer(String userAnswer, String expectedAnswer) {
        if (userAnswer != null && userAnswer.equals(expectedAnswer)) {
            rightAnswersCount++;
            System.out.println("Correct!");
            return true;
        } else {
            String message = "'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                    + expectedAnswer + "'.\n" + "Let's try again, " + userName + "!";
            System.out.println(message);
            return false;
        }
    }


    /**
     * Prints congratulations if user wins the game.
     */
    protected void endGame() {
        if (rightAnswersCount == ROUNDS_NUMBER) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
}
