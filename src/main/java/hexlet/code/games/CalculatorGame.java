package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.UserInputScanner;

import java.util.Random;

public class CalculatorGame extends Engine {

    private static final int MAX_RANDOM_NUMBER = 100;

    private static final char[] OPERATORS = {'+', '-', '*'};

    public CalculatorGame(String name) {
        super(name);
    }

    @Override
    protected final void printGameRules() {
        System.out.println("What is the result of the expression?");
    }

    @Override
    protected final boolean playRound() {
        int number1 = GameHelper.getRandomNumber(MAX_RANDOM_NUMBER);
        int number2 = GameHelper.getRandomNumber(MAX_RANDOM_NUMBER);
        char operator = getMathOperator();
        System.out.printf("Question: %d %s %d\n", number1, operator, number2);
        System.out.print("Your answer: ");
        String answer = UserInputScanner.getScanner().nextLine();
        return checkAnswer(answer, Integer.toString(getCorrectAnswer(number1, number2, operator)));
    }

    private int getCorrectAnswer(int number1, int number2, char operator) {
        return switch (operator) {
            case '+' -> number1 + number2;
            case '-' -> number1 - number2;
            case '*' -> number1 * number2;
            default -> throw new IllegalStateException("Invalid operator: " + operator);
        };
    }

    private char getMathOperator() {
        int index = new Random().nextInt(OPERATORS.length);
        return OPERATORS[index];
    }

}
