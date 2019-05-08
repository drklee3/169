import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.stream.Collectors;

public class MainClass {
    /**
     * Converts an integer timestamp to a date or "now" to the current Date
     * 
     * @param date String or integer to create a date from
     * @return     Date object
     * @throws IllegalArgumentException if date is not "now" or an integer
     */
    public static Date getDate(Object date) {
        if (date == "now") {
            return new Date();
        }
        
        if (date instanceof Integer) {
            return new Date((long) date);
        }

        throw new IllegalArgumentException("Invalid date type! Found "
            + date + ", " + date.getClass() + ".");
    }

    /**
     * Parses an ArrayList<Object> of the class name, followed by parameters.
     * Assumes input is correctly formatted, throws Exceptions if there are
     * problems with input
     * 
     * @param list ArrayList<Object> of strings and integers
     * @return     ArrayList<Food> of parsed foods
     * @throws IllegalArgumentException if input list is not formatted correctly
     */
    public static ArrayList<Food> parseFoodsList(ArrayList<Object> list) {
        // create a new ArrayList<Food> for parsed Food objects
        ArrayList<Food> foods = new ArrayList<Food>();

        Iterator<Object> iter = list.iterator();
        // iterate over the ArrayList<Object>
        while (iter.hasNext()) {
            Object next = iter.next();
            
            // verify if it's a string.  First item **should** be a class name.
            if (!(next instanceof String)) {
                throw new IllegalArgumentException("Invalid type! Found "
                    + next.getClass() + ".");
            }

            // get type of next object and get arguments
            switch (next.toString()) {
                case "Food":
                    // arguments: name
                    foods.add(new Food(iter
                        .next()
                        .toString()
                    ));
                    break;
                case "Fruit":  // Fruit(ripe, name)
                    // name is given first in ArrayList but is second parameter
                    String name = iter.next().toString();
                    foods.add(new Fruit(
                        getDate(iter.next()),
                        name
                    ));
                    break;
                case "Apple":  // Apple(ripe)
                    foods.add(new Apple(getDate(iter.next())));
                    break;
                case "Orange": // Orange(ripe)
                    foods.add(new Orange(getDate(iter.next())));
                    break;
                default:
                    throw new IllegalArgumentException("Unhandled type! Found "
                        + next.getClass() + ".");
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
        // assuming Orange is the parameter to Food(String name)
        // "name of the type of the next object, followed by parameter(s) that
        // should be sent as input to the class’ constructor"
        // If Orange is treated as a new Object then there would be no valid
        // constructor parameter for Orange ("Fruit" but requires a Date)
        foods.add("Orange");
        foods.add("Fruit");
        foods.add("Papaya");
        foods.add(3932728); // Integer(int value) is deprecated
        foods.add("Apple");
        foods.add("now");
        foods.add("Food");
        foods.add("sandwich");

        try {
            // results in Food, Fruit, Apple, Food
            ArrayList<Food> foods_parsed = parseFoodsList(foods);
            System.out.println(foodsToString(foods_parsed));
        } catch (Exception e) {
            // will error if input ArrayList is an invalid format
            System.out.println("ERROR: " + e + " Exiting.");
            System.exit(1);
        }
    }
}