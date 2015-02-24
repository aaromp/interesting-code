import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ClosestPair {
    public static void main (String[] args) {
    }

    private static Pair findClosestSplitPair(Point[] px, Point[] py, double delta) {
        double x = px[px.length/2].x;
        // filter out the points in py that are not contained within the interval [x-delta, x+delta]
        List<Point> sy = new ArrayList<Point>();
        for (int index = 0; index < py.length; index++) {
            if (py[index].x > (x-delta) && py[index].x < (x+delta)) sy.add(py[index]);
        }

        double bestDistance = delta;
        Pair bestPair = null;

        for (int i = 0; i < sy.size(); i++) {
            for (int j = 1; j < Math.min(sy.size()-i-1, 7); j++) {
                Pair pij = new Pair(sy.get(i), sy.get(i+j));
                if (pij.distance < bestDistance) {
                    bestDistance = pij.distance;
                    bestPair = pij;
                }
            }
        }

        return bestPair;
    }

    private static Pair recFindClosestPair(Point[] px, Point[] py) {
        Pair closestPair = null;

        // base case: when there are fewer than 4 points remaining return the smallest among them
        if (px.length < 2) return closestPair;
        if (px.length < 4) {
            Pair p12 = new Pair(px[0], px[1]);
            if (px.length == 2) return p12;

            Pair p13 = new Pair(px[0], px[2]);
            Pair p23 = new Pair(px[1], px[2]);

            closestPair = p12.distance < p13.distance ? p12 : p13;
            closestPair = closestPair.distance < p23.distance ? closestPair : p23;

            return closestPair;
        }

        // recursive case: partitian the remaining points and find the closes point between the three
        Point[] qx = Arrays.copyOfRange(px, 0, px.length/2);
        Point[] rx = Arrays.copyOfRange(px, px.length/2, px.length);
        Point[] qy = Arrays.copyOfRange(py, 0, py.length/2);
        Point[] ry = Arrays.copyOfRange(py, py.length/2, py.length);

        Pair closestPairLeft = recFindClosestPair(qx, qy);
        Pair closestPairRight = recFindClosestPair(rx, ry);
        closestPair = closestPairLeft.distance < closestPairRight.distance ? closestPairLeft : closestPairRight;

        Pair closestSplitPair = findClosestSplitPair(px, py, closestPair.distance);
        if (closestSplitPair != null) closestPair = closestPair.distance < closestSplitPair.distance ? closestPair : closestSplitPair;

        // return the best of the three calculated pairs
        return closestPair;
    }

    public static Pair findClosestPair(Point[] points) {
        // preprocessing step:
        // create a new Point[] of size n and sort it by x coordinate
        XComparator xComparator = new XComparator();
        Point[] px = points.clone();
        Arrays.sort(px, xComparator);

        // create a new Point[] of size n and sort it by y coordinate
        YComparator yComparator = new YComparator();
        Point[] py = points.clone();
        Arrays.sort(py, yComparator);

        return recFindClosestPair(px, py);
    }

    private static class XComparator implements Comparator<Point> {
        @Override
        public int compare(Point p, Point q) {
            return (int) (p.x - q.x);
        }
    }

    private static class YComparator implements Comparator<Point> {
        @Override
        public int compare(Point p, Point q) {
            return (int) (p.y - q.y);
        }
    }
}

