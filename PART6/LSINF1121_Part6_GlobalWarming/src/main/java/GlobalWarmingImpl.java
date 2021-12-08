import java.util.*;

public class GlobalWarmingImpl extends GlobalWarming {

    /**
     * In the following, we assume that the points are connected to
     * horizontal or vertical neighbors but not to the diagonal ones
     * @param altitude is a n x n matrix of int values representing altitudes (positive or negative)
     * @param waterLevel is the water level, every entry <= waterLevel is flooded
     */
    public GlobalWarmingImpl(int[][] altitude, int waterLevel) {
        super(altitude,waterLevel);
        // TODO
    }

    /**
     *
     * @param p1 a safe point with valid coordinates on altitude matrix
     * @param p2 a safe point (different from p1) with valid coordinates on altitude matrix
     * @return the shortest simple path (vertical/horizontal moves) if any between from p1 to p2 using only vertical/horizontal moves on safe points.
     *         an empty list if not path exists (i.e. p1 and p2 are not on the same island).
     */
    public List<Point> shortestPath(Point p1, Point p2) {
        // TODO
        // expected time complexity O(n^2)
        return new ArrayList<Point>();
    }

    public List<Point> adjSafe(Point p){
        List<Point> l = new ArrayList<Point>();
    }
}