import java.util.Scanner;

public class MainClass {
    /**
     * Helper function to insert values into a SortedList and print information
     * 
     * @param list  SortedList to insert into
     * @param value Integer value to insert.
     */
    public static void insert_array(SortedList list, int value) {
        System.out.println("Pre-insert list:");
        System.out.println(list);

        int pos = list.search(value);
        if (pos >= 0) {
            System.out.println(value + " was found at " + pos);
        } else {
            System.out.println(value +
                " was not found, insertion point at " + (-pos));
        }

        list.insert(value);

        System.out.println("Post-insert list:");
        System.out.println(list);
        pos = list.search(value);
        if (pos < 0) {
            System.out.println("ERROR: Failed to insert value! Insertion point at "
            + (-pos));
            return;
        }

        System.out.println(value + " was found at " + pos);

        if (!list.is_sorted()) {
            System.out.println("ERROR: List is not sorted!");
            System.exit(1);
        }
    }

    public static void main(String args[]) {
        // starting values
        int[] array = new int[] {
            38, 86, 31, 60,   2,
            37, 91, 25, 96,  23,
            4,  18, 53, 92,  54,
            3,  61, 73,  1, 100,
            65,  6, 30, 74,  56,
        };
        
        SortedList list = new SortedList(array);
        System.out.println("Initial array:");
        System.out.println(list);

        // numbers to insert
        int[] to_insert = new int[] {8, 27, 31, 87, 96, 99};

        for (int i = 0; i < to_insert.length; i++) {
            insert_array(list, to_insert[i]);
        }
    }
}