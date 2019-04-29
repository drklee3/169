import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int input[] = new int[] {500, 700, 800, 100, 300, 200, 900, 400, 1000, 600};
        System.out.print("Input: ");
        System.out.println(Arrays.toString(input));
        QuickSorter q = new QuickSorter(input);
        
        System.out.print("Output: ");
        System.out.println(Arrays.toString(input));
    }

}