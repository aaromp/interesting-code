import org.junit.*;
import static org.junit.Assert.*;

public class ClosestPairTest {

    @Test
    public void test_find_closest_pair() {
        double[][] coordinates = {{0, 0}, {0, 1}, {100, 45}, {2, 3}, {9, 9}};
        Point[] points = convertCoordinatesToPoints(coordinates);

        Pair closestPair = ClosestPair.findClosestPair(points);

        Assert.assertEquals("failure - found incorrect pair", 1.0, closestPair.distance);
    }

    public Point[] convertCoordinatesToPoints(double[][] coordinates) {
        Point[] points = new Point[coordinates.length];

        for (int index = 0; index < coordinates.length; index++) {
            points[index] = new Point(coordinates[index][0], coordinates[index][1]);
        }

        return points;
    }
}

