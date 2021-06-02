package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.UserInputScanner;

import java.util.Random;

public class CalculatorGame extends Engine {

    private static final int MAX_RANDOM_NUMBER = 100;

    private static final char[] OPERATORS = {'+', '-', '*'};

    public CalculatorGame(String userName) {
        super(userName);
    }

    @Override
    protected final void printGameRules() {
        System.out.println("What is the result of the expression?");
    }

    @Override
    protected final boolean playRound() {
        int number1 = chooseRandomNumber();
        int number2 = chooseRandomNumber();
        char operator = chooseMathOperator();
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

    private int chooseRandomNumber() {
        return new Random().nextInt(MAX_RANDOM_NUMBER);
    }

    private char chooseMathOperator() {
        int index = new Random().nextInt(OPERATORS.length);
        return OPERATORS[index];
    }

}
