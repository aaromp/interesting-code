import org.junit.*;
import static org.junit.Assert.*;

import java.util.Arrays;

public class CountingInversionsTest {

    @Test
    public void test_count_inversions() {
        int[] expected = {1, 3, 5, 2, 4, 6};
        int[] actual = expected.clone();
        Arrays.sort(expected);

        int count = CountingInversions.sortAndCount(actual);
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
    }
}
