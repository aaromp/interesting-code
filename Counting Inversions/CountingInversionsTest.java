import org.junit.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountingInversionsTest {

    @Test
    public void test_count_inversions() {
        int[] expected = {1, 3, 5, 2, 4, 6};
        int[] actual = expected.clone();
        Arrays.sort(expected);

        long count = CountingInversions.sortAndCount(actual);
        Assert.assertEquals("failure - incorrectly counted test inversions", 3, count);
        Assert.assertArrayEquals("failure - mergesort incorrectly sorted input array", expected, actual);

        count = CountingInversions.sortAndCount(expected);
        Assert.assertEquals("failure - incorrectly counted inversions of sorted array", 0, count);

        expected = new int[] {1, 20, 6, 4, 5};
        count = CountingInversions.sortAndCount(expected);
        Assert.assertEquals("failure - incorrectly counted 5 inversions", 5, count);

        expected = new int[] {7, 7, 7};
        count = CountingInversions.sortAndCount(expected);
        Assert.assertEquals("failure - incorrectly counted inversions of flat array", 0, count);

        try (BufferedReader reader = new BufferedReader(new FileReader("./IntegerArray.txt"))) {
            String currentLine;
            List<Integer> values = new ArrayList<Integer>();

            while ((currentLine = reader.readLine()) != null) {
                values.add(Integer.parseInt(currentLine));
            }

            expected  = new int[values.size()];
            for (int index = 0; index < values.size(); index++) {
                expected[index] = values.get(index);
            }

            count = CountingInversions.sortAndCount(expected);

            Assert.assertEquals("failure - incorrectly counted inversions of large array", 2407905288L, count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
