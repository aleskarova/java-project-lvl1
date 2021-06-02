package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.UserInputScanner;

public class ProgressionGame extends Engine {

    private static final int MAX_START_PROGRESSION = 100;

    private static final int MAX_PROGRESSION_STEP = 50;

    private static final int PROGRESSION_LENGTH = 10;

    private final int[] progression = new int[PROGRESSION_LENGTH];

    public ProgressionGame(String name) {
        super(name);
    }

    @Override
    protected final void printGameRules() {
        System.out.println("What number is missing in the progression?");
    }

    @Override
    protected final boolean playRound() {
        generateProgression();
        int index = GameHelper.getRandomNumber(PROGRESSION_LENGTH);
        System.out.println("Question: " + hideProgressionNumber(index));
        System.out.print("Your answer: ");
        String answer = UserInputScanner.getScanner().nextLine();
        return checkAnswer(answer, Integer.toString(progression[index]));
    }

    private void generateProgression() {
        int startNumber = GameHelper.getRandomNumber(MAX_START_PROGRESSION);
        int step = GameHelper.getRandomNumber(MAX_PROGRESSION_STEP);
        int currentNumber = startNumber;
        for (int i = 0; i < progression.length; i++) {
            progression[i] = currentNumber;
            currentNumber += step;
        }
    }

    private String hideProgressionNumber(int index) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
            if (i == index) {
                builder.append("..");
            } else {
                builder.append(progression[i]);
            }
            builder.append(" ");
        }
        return builder.toString();
    }
}
