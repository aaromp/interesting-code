import java.util.Random;

public class Quicksort  {
    public static void main (String[] args) {
    }

    private static final Random generator = new Random();

    public static void recSort(int[] array, int start, int end) {
        // base case: start is greater than or equal to the end so our range is already sorted
        if (start >= end) return;

        // recursive case: select a pivot and sort the two partitions
        int pivot = generator.nextInt((end - start) + 1) + start;

        // move the pivot to the beginning where it's easy to locate
        swap(array, start, pivot);

        // make a linear scan over the elements and partitian the elements
        int less = start + 1;
        for (int more = less; more < end; more++) {
            if (array[more] <= array[start]) {
                less++;
                swap(array, less, more);
            }
        }

        // move the pivot to its correct position
        swap(array, start, less - 1);

        recSort(array, start, less - 1);
        recSort(array, less + 1, end);
    }

    private static void swap(int[] array, int first, int second) {
        int temporary = array[first];
        array[first] = array[second];
        array[second] = temporary;
    }
}
