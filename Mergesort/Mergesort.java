import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Mergesort {
    public static void main (String[] args) {
        System.out.println("sorting...");

        int[] first;
        int[] second;
        int failures = 0;
        for (int trial = 0; trial < 10000; trial++) {
            first = generateShuffledValues(1000);
            second = sort(first.clone());
            Arrays.sort(first);
            if (!Arrays.equals(first, second)) failures++;
        }

        System.out.println(failures + " failures out of " + 10000 + " trials sorting 1000 shuffled values.");
    }

    public static int[] sort(int[] array) {
        if (array.length <= 1) return array;

        int[] first = Arrays.copyOfRange(array, 0, array.length/2);
        int[] second = Arrays.copyOfRange(array, array.length/2, array.length);

        return merge(sort(first), sort(second));
    }

    private static int[] merge(int[] first, int[] second) {
        int size = first.length + second.length;
        int[] result = new int[size];

        int left = 0;
        int right = 0;
        int index = 0;

        while (index < size) {
            if (right >= second.length || (left < first.length && first[left] < second[right])) {
                result[index] = first[left];
                left++;
            } else {
                result[index] = second[right];
                right++;
            }

            index++;
        }

        return result;
    }

    private static int[] generateShuffledValues(int n) {
        List<Integer> values = new ArrayList<Integer>();

        for (int value = 1; value <= n; value++) {
            values.add(value);
        }
        Collections.shuffle(values);

        int[] result = new int[values.size()];
        for (int index = 0; index < n; index++) {
            result[index] = values.get(index);
        }

        return result;
    }
}

