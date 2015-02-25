import org.junit.*;
import static org.junit.Assert.*;

import java.util.Random;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class QuickselectTest{
    @Test
    public void test_select() {
    	int[] expected;
        int[] actual;
        int order;
        for (int trial = 0; trial < 1000; trial++) {
            expected = generateShuffledValues(1000);
            actual = expected.clone();
            order = generator.nextInt(1000);

            Arrays.sort(expected);

            Assert.assertEquals("failure - select incorrectly selected order element", expected[order], Quickselect.select(actual, order));
        }
    }

    private final Random generator = new Random();

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
