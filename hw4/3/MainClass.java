import java.util.Scanner;

public class MainClass {
    public static void main(String args[]) {
        /*
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = in.nextInt();

        int[] array = new int[n];
        System.out.println("Enter " + n + " integers in ascending order");
    
        for (int c = 0; c < n; c++) {
            array[c] = in.nextInt();
        }
    
        System.out.println("Enter value to find");
        int search = in.nextInt();
        in.close();
        */

        int[] array = new int[] {
            38, 86, 31, 60,   2,
            37, 91, 25, 96,  23,
            4,  18, 53, 92,  54,
            3,  61, 73,  1, 100,
            65,  6, 30, 74,  56,
        };
        
        SortedList list = new SortedList(array);

        System.out.println(list);

        int pos_exists   = list.search(96);
        int pos_nonexist = list.search(70);
        System.out.println("96 @ " + pos_exists + ", 70 @ " + pos_nonexist);

        list.insert(70);

        System.out.println(list);
        pos_nonexist = list.search(70);
        System.out.println("70 @ " + pos_nonexist);


        /*
        if (pos < 0) {
            System.out.println("Couldn't find " + search + " in list");
            return;
        }

        System.out.println(search + " found at location " + pos);
        */
    }
}