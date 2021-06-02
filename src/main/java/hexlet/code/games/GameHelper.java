package hexlet.code.games;

import java.util.Random;

public class GameHelper {

    public static int getRandomNumber(int bound) {
        return new Random().nextInt(bound);
    }
}
