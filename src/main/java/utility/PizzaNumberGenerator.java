package utility;

import java.util.Random;

public class PizzaNumberGenerator {

    private final int MIN = 90000;
    private final int RANGE = 10000;

    private static volatile PizzaNumberGenerator instance;
    private Random rand;

    private PizzaNumberGenerator() {
        rand = new Random();
    }

    public static PizzaNumberGenerator getInstance() {
        PizzaNumberGenerator localInstance = instance;
        if (localInstance == null) {
            synchronized (PizzaNumberGenerator.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new PizzaNumberGenerator();
                }
            }
        }
        return localInstance;
    }

    public int getPizzaNumber(){
        return rand.nextInt(MIN) + RANGE;
    }
}
