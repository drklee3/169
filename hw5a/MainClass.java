import com.sun.jdi.InvalidTypeException;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.stream.Collectors;

public class MainClass {
    public static ArrayList<Food> parseFoodsList(ArrayList<Object> list) throws Exception {
        // create a new ArrayList<Food> for parsed Food objects
        ArrayList<Food> foods = new ArrayList<Food>();

        Iterator<Object> iter = list.iterator();
        // iterate over the ArrayList<Object>
        while (iter.hasNext()) {
            Object next = iter.next();
            
            // verify if it's a string.  First item **should** be a class name.
            if (!(next instanceof String)) {
                throw new InvalidTypeException("Invalid type! Found "
                    + next.getClass() + ".");
            }

            String name = null;
            Object ripe;
            Date ripe_date;

            // get type of next object and get arguments
            switch (next.toString()) {
                case "Food":
                    // arguments: name
                    foods.add(new Food(iter.next().toString()));
                    // move to next in ArrayList
                    continue;
                case "Fruit":  // Fruit(ripe, name)
                    name = iter.next().toString();
                case "Apple":  // Apple(ripe)
                case "Orange": // Orange(ripe)
                    // could be an int or string
                    ripe = iter.next();
                    break;
                default:
                    throw new IllegalArgumentException("Unhandled type! Found "
                        + next.getClass() + ".");
            }

            // ripe should never be null, if it's Food then this is unreachable
            if (ripe == null) {
                throw new IllegalArgumentException("Missing ripe time.");
            }

            // create the date class
            if (ripe == "now") {
                ripe_date = new Date();
            } else if (ripe instanceof Integer) {
                ripe_date = new Date((int) ripe);
            } else {
                throw new InvalidTypeException("Invalid date type! Found "
                    + ripe.getClass() + ".");
            }

            // create the class
            switch (next.toString()) {
                case "Fruit":
                    // should be never null if "Fruit" was matched in the
                    // previous switch statement
                    foods.add(new Fruit(ripe_date, name));
                    break;
                case "Apple":
                    foods.add(new Apple(ripe_date));
                    break;
                case "Orange":
                    foods.add(new Orange(ripe_date));
                    break;
                default:
                    throw new IllegalArgumentException("Unhandled type! Found "
                        + next.getClass()
                        + ". This case should be unreachable.");
            }
        }

        return foods;
    }

    /**
     * Returns string representation of class types in an ArrayList<Food>.
     * 
     * Printing out the ArrayList<Food> directly with
     * `System.out.println(list)` would result in the object addresses being
     * printed out as well. It still shows the class name but just not ideal:
     * [Food@7b1d7fff, Fruit@299a06ac, Apple@383534aa, Food@6bc168e5]
     * 
     * @param  list ArrayList<Foods> to print
     * @return      Arraylist in string form
     */
    public static String foodsToString(ArrayList<Food> list) {
        return list
            .stream()
            .map(f -> f
                .getClass()
                .getSimpleName()
            )
            .collect(Collectors
                .joining(", ")
            );
    }

    public static void main(String args[]) {
        // mixed type ArrayList :(
        ArrayList<Object> foods = new ArrayList<Object>();
        foods.add("Food");
        foods.add("Orange");
        foods.add("Fruit");
        foods.add("Papaya");
        foods.add(3932728);
        foods.add("Apple");
        foods.add("now");
        foods.add("Food");
        foods.add("sandwich");

        try {
            // results in Food, Orange, Fruit, Apple, Food
            ArrayList<Food> foods_parsed = parseFoodsList(foods);
            System.out.println(foodsToString(foods_parsed));
        } catch (Exception e) {
            // will error if input ArrayList is an invalid format
            System.out.println("ERROR: " + e + " Exiting.");
            System.exit(1);
        }
    }
}