import org.junit.*;
import static org.junit.Assert.*;

public class ClosestPairTest {

    @Test
    public void test_find_closest_pair() {
        double[][] coordinates1 = {{0, 0}, {0, 1}, {100, 45}, {2, 3}, {9, 9}};
        Point[] points = convertCoordinatesToPoints(coordinates1);

        Pair closestPair = ClosestPair.findClosestPair(points);
        Assert.assertEquals("failure - found incorrect pair", 1.0, closestPair.distance, 0.0);

        double[][]  coordinates2 = {{0, 0}, {-4, 1}, {-7, -2}, {4, 5}, {1, 1}};
        points = convertCoordinatesToPoints(coordinates2);

        closestPair = ClosestPair.findClosestPair(points);
        Assert.assertEquals("failure - found incorrect pair", 1.414214, closestPair.distance, 0.000001);
    }

    public Point[] convertCoordinatesToPoints(double[][] coordinates) {
        Point[] points = new Point[coordinates.length];

        for (int index = 0; index < coordinates.length; index++) {
            points[index] = new Point(coordinates[index][0], coordinates[index][1]);
        }

        return points;
    }
}

