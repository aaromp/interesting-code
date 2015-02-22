import org.junit.*;
import static org.junit.Assert.*;

public class StrassenTest {

    @Test
    public void test_multiplication() {
        int[][] x = new int[][] {{0, 0}, {0, 0}};
        int[][] y = new int[][] {{0, 0}, {0, 0}};

        int[][] result = Strassen.multiply(x, y);

        Assert.assertArrayEquals("failure - matrix product is incorrect", new int[] {0, 0}, result[0]);
        Assert.assertArrayEquals("failure - matrix product is incorrect", new int[] {0, 0}, result[1]);

        x = new int[][] {{3, 3}, {3, 3}};
        y = new int[][] {{3, 3}, {3, 3}};

        result = Strassen.multiply(x, y);

        Assert.assertArrayEquals("failure - matrix product is incorrect", new int[] {18, 18}, result[0]);
        Assert.assertArrayEquals("failure - matrix product is incorrect", new int[] {18, 18}, result[1]);

        x = new int[][] {{1, 2}, {3, 4}};
        y = new int[][] {{5, 6}, {7, 9}};

        result = Strassen.multiply(x, y);

        Assert.assertArrayEquals("failure - matrix product is incorrect", new int[] {19, 24}, result[0]);
        Assert.assertArrayEquals("failure - matrix product is incorrect", new int[] {43, 54}, result[1]);
    }
}
