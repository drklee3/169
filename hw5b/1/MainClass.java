import java.util.ArrayList;
import java.util.Collections;

public class MainClass {
    
    public static void main(String args[]) {
        // generate a random list of 20 different fruit
        ArrayList<Fruit> fruits = new FruitGenerator()
            .count(20)
            .generate();
        
        System.out.println("Before sorting:");
        // print individually so they're on separate lines
        fruits.forEach(System.out::println);

        Collections.sort(fruits);
        
        System.out.println("=".repeat(43) + "\n");
        System.out.println("After sorting:");
        fruits.forEach(System.out::println);
    }
}

