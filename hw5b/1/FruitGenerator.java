import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class FruitGenerator {
    // default fruit count
    long fCount = 10L;
    // default min timestamp
    long min    = 100L;
    // default max timestamp
    long max    = 1600000000000L;

    // fruit strings for Fruit()
    String fruits[] = {
        "guava",
        "pomegranate",
        "grapefruit",
        "pineapple",
        "peach",
        "blueberry",
        "strawberry"
    };

    public FruitGenerator() {}

    /**
     * Sets the number of fruit to generate
     * 
     * @param count Number of fruit.
     */
    public FruitGenerator count(long count) {
        this.fCount = count;
        return this;
    }

    /**
     * Sets the minimum date in ms to generate random dates
     * 
     * @param min Minimum timestamp in ms
     */
    public FruitGenerator minDate(long min) {
        this.min = min;
        return this;
    }

    /**
     * Sets the maximum date in ms to generate random dates
     * 
     * @param max Maximum timestamp in ms
     */
    public FruitGenerator maxDate(long max) {
        this.max = max;
        return this;
    }

    /**
     * Generates a random fruit with a random ripe time
     * 
     * @return Fruit, Apple, or Orange with a random ripe time
     */
    private Fruit randomFruit() {
        long fruitNum = this.randNum(0, 3);
        Date randDate = this.randDate(this.min, this.max);
        if (fruitNum == 0) {
            return new Apple(randDate);
        } else if (fruitNum == 1) {
            return new Orange(randDate);
        }

        // dont check fruitNum here just in case randNum is inclusive
        int index = new Random().nextInt(this.fruits.length);
        return new Fruit(randDate, this.fruits[index]);
    }

    /**
     * Generate the ArrayList of Fruit
     * 
     * @return ArrayList<Fruit> of random fruits
     */
    public ArrayList<Fruit> generate() {
        ArrayList<Fruit> fruits = new ArrayList<Fruit>();

        for (int i = 0; i < this.fCount; i++) {
            fruits.add(this.randomFruit());
        }

        return fruits;
    }

    /**
     * Generates a random date between a range
     * 
     * @param min Minimum value
     * @param max Maximum value
     * @return    Random date between min and max
     */
    private Date randDate(long min, long max) {
        return new Date(this.randNum(min, max));
    }

    /**
     * Generate a random number between a range
     * 
     * @param min Minimum value
     * @param max Maximum value
     * @return    Random value between min and max
     */
    private long randNum(long min, long max) {
        return min + (long) (Math.random() * (max - min));
    }
}