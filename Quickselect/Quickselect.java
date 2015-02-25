import java.util.Random;

public class Quickselect {
    public static void main (String[] args) {
    }

    private static final Random generator = new Random();

    private static int recSelect(int[] array, int order, int start, int end) {
        // base case: the interval only contains one item so we must be trying to select it
        if (start >= end) return array[end-start-1];

        int pivot = generator.nextInt(end - start) + start; // pivot selected at random in an attempt to select a good pivot

        // move the pivot to a predictable place
        swap(array, pivot, start);

        // partition the array
        int less = start + 1;
        for (int more = less; more < end; more++) {
            // if the current element is less than the pivot we want to swap it at the less/more boundary
            if (array[more] < array[start]) {
                swap(array, more, less);
                less++;
            }
        }
        // swap the pivot into its correct index
        swap(array, start, less-1);

        // base case: if the index of the pivot matches the order, then we've selected our element
        if (order == less-1) return array[less-1];

        // recursive case: we select the element from the appropriate half
        if (order < less-1) return recSelect(array, order, start, less-1);
        else return recSelect(array, order-less-1, less, end);
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
