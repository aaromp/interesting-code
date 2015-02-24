public class Pair {
    public final Point p;
    public final Point q;
    public double distance;

    public Pair(Point p, Point q) {
        this.p = p;
        this.q = q;
        this.distance = calculateEuclideanDistance(p, q);
    }

    public static double calculateEuclideanDistance(Point p, Point q) {
        double xDifference = p.x - q.x;
        double yDifference = p.y - q.y;
        return Math.sqrt((xDifference * xDifference) + (yDifference * yDifference));
    }
}
