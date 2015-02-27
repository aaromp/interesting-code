import java.util.Arrays;

public class CountingInversions {
    public static void main (String[] args) {
        int[] test = {1, 3, 5, 2, 4, 6};
        long count = sortAndCount(test);

        System.out.println("Counting Inversions...");
        System.out.println(Arrays.toString(test) + " should be sorted and have " + count + " inversions.");
    }

    public static long sortAndCount(int[] array) {
        long count = 0;

        if (array.length == 1) return count;

        int[] left = Arrays.copyOfRange(array, 0, array.length/2);
        int[] right = Arrays.copyOfRange(array, array.length/2, array.length);
        count += sortAndCount(left);
        count += sortAndCount(right);
        count += mergeAndCount(left, right, array);

        return count;
    }

    private static long mergeAndCount(int[] left, int[] right, int[] result) {
        long count = 0;

        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (resultIndex < result.length) {
            if (rightIndex >= right.length || (leftIndex < left.length && left[leftIndex] <= right[rightIndex])) {
                result[resultIndex] = left[leftIndex];
                leftIndex++;
            } else {
                if (leftIndex < left.length) {
                    count += left.length-leftIndex;
                }

                result[resultIndex] = right[rightIndex];
                rightIndex++;
            }

            resultIndex++;
        }

        return count;
    }
}
