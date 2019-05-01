import java.util.Arrays;

class SortedList {
    private int array[];

    /**
     * Creates a SortedList with dummy values.
     */
    public SortedList() {
        // call the other constructor
        this(new int[] {1, 4, 6, 8, 10});
    }

    /**
     * Creates a SortedList with a given array.
     * 
     * @param array Input array
     */
    public SortedList(int array[]) {
        this.array = array;
        this.quickSort();
    }

    /**
     * Creates a SortedList with a given array and size.
     * Size isn't necessary as we can just use array.length, but the
     * instructions say to make a constructor with an initialized array and size
     * 
     * @param array Input array
     * @param size  Size of array, or anything really, it's not used
     */
    public SortedList(int array[], int size) {
        this(array);
    }

    /**
     * Returns string representation of the inner array data structure.
     * Allows for direct use of `System.out.println(SortedList);`
     */
    @Override
    public String toString() {
        return Arrays.toString(this.array);
    }

    /**
     * Inserts a single value in it's sorted position. Searches for the
     * insertion point using binary search, then shifts the elements afterwards
     * over by one.
     * 
     * O(log n) for search, O(n) for shift, so is the binary
     * search necessary? We can just use a partial sequential loop to find the 
     * insertion position then iterate the rest of the array to shift which
     * would result in O(n) which is technically better than O(log n) + O(n)
     * but both are equivalent to O(n). This may perform better in worst case
     * situations (eg inserting at the end of the array).
     * 
     * @param value Integer to insert
     */

    public void insert_(int value) {
        // insertion point for the new value using binary search
        int ip = (- this.search(value)) - 1;

        // copy array to new array + 1 allocated size
        this.array = Arrays.copyOf(this.array, this.array.length + 1);

        // shift everything after over to the "right" one position to give room
        // for the new value to be inserted
        for (int i = this.array.length - 1; i > ip; i--) {
            this.array[i] = this.array[i - 1];
        }

        // insert the value in it's insertion point
        this.array[ip] = value;
    }

    /**
     * Inserts a single value in it's sorted position. Uses an O(n) single pass
     * loop (split into 2 for loops) to find the position of the value to be
     * inserted and shift the elements afterwards. A more simple method compared
     * to the one above which uses binary search.
     * 
     * @param value Integer to insert
     */
    public void insert(int value) {
        // copy array to a new array + 1 allocated size
        this.array = Arrays.copyOf(this.array, this.array.length + 1);

        // get position for new value
        int i = 0;
        for(i = 0; i < this.array.length; i++) {
            if (this.array[i] > value) {
                break;
            }
        }
        
        // shift everything after the new value position one over to the "right"
        for (int j = this.array.length - 2; j >= i; j--) {
            this.array[j + 1] = this.array[j];
        }

        // insert the new value
        this.array[i] = value;
    }

    /**
     * Sorts the inner list with quicksort.
     */
    private void quickSort() {
        // run quicksort
        new QuickSorter(this.array);
    }

    /**
     * Performs binary search on the SortedList
     * 
     * @param  target element to search for
     * @return        index of the searched element. -(ip) - 1 if not found.
     */
    public int search(int target) {
        int first  = 0;
        int last   = this.array.length - 1;
        int middle = (first + last) / 2;
    
        while (first <= last) {
            if (array[middle] < target) {
                first = middle + 1;
            } else if (array[middle] > target) {
                last = middle - 1;
            } else {
                return middle + 1;
            }

            middle = (first + last) / 2;
        }

        return - first - 1;
    }

    /**
     * Helper method to verify if the array is sorted.
     * 
     * @return True if the array is sorted
     */
    public boolean is_sorted() {
        for (int i = 0; i < this.array.length - 1; i++) { 
            if (this.array[i] > this.array[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
