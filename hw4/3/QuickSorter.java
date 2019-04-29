public class QuickSorter {
    private int[] input;

    public QuickSorter(int[] input) {
        this.input = input;
        this.quicksort(0, this.input.length - 1);
    }

    private int partition(int p, int r) {
        int pivot = this.input[r];

        while (p < r) {
            while (this.input[p] < pivot) {
                p++;
            }

            while (this.input[r] > pivot) {
                r--;
            }

            if (this.input[p] == this.input[r]) {
                p++;
            } else if (p < r) {
                int tmp = this.input[p];
                this.input[p] = this.input[r];
                this.input[r] = tmp;
            }
        }

        return r;
    }

    private void quicksort(int p, int r) {
        if (p < r) {
            int j = this.partition(p, r);
            this.quicksort(p, j - 1);
            this.quicksort(j + 1, r);
        }
    }
}