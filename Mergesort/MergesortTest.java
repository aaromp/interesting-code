import org.junit.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MergesortTest {
    @Test
    public void test_sort() {
        int[] expected;
        int[] actual;
        for (int trial = 0; trial < 10000; trial++) {
            expected = generateShuffledValues(1000);
            actual = Mergesort.sort(expected.clone());
            Arrays.sort(expected);
            Assert.assertArrayEquals("failure - mergesort incorrectly sorted shuffled array", expected, actual);
        }
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
