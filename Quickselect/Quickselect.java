import java.util.Random;

public class Quickselect {
    public static void main (String[] args) {
    }

    private static final Random generator = new Random();

    private static int recSelect(int[] array, int order, int start, int end) {
        // base case: the interval only contains one item so we must be trying to select it
        if (end - start == 1) return array[start];

        int pivotIndex = generator.nextInt(end - start) + start; // pivot selected at random in an attempt to select a good pivot
        pivotIndex = partition(array, pivotIndex, start, end);

        // base case: if the index of the pivot matches the order, then we've selected our element
        if (order == pivotIndex) return array[pivotIndex];

        // recursive case: we select the element from the appropriate half
        else if (order < pivotIndex) return recSelect(array, order, start, pivotIndex);
        else return recSelect(array, order, pivotIndex+1, end);
    }

    private static int partition(int[] array, int pivot, int start, int end) {
        // move the pivot to a predictable place
        swap(array, pivot, start);

        // partition the array
        int firstLarger = start + 1;
        for (int current = firstLarger; current < end; current++) {
            // if the current element is less than the pivot we want to swap it at the less/more boundary
            if (array[current] < array[start]) {
                swap(array, current, firstLarger);
                firstLarger++;
            }
        }
        // swap the pivot into its correct index
        swap(array, start, firstLarger-1);

        return firstLarger-1;
    }

    private static void swap(int[] array, int first, int second) {
        int temporary = array[first];
        array[first] = array[second];
        array[second] = temporary;
    }

    public static int select(int[] array, int order) {
        // clone input to avoid altering the original ordering
        int[] input = array.clone();

        return recSelect(input, order, 0, input.length);
    }
}
