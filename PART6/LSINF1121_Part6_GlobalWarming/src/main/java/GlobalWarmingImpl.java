import java.util.*;

public class GlobalWarmingImpl extends GlobalWarming {

    //public int[] union;
    public int c;
    public int l;

    /**
     * In the following, we assume that the points are connected to
     * horizontal or vertical neighbors but not to the diagonal ones
     * @param altitude is a n x n matrix of int values representing altitudes (positive or negative)
     * @param waterLevel is the water level, every entry <= waterLevel is flooded
     */
    public GlobalWarmingImpl(int[][] altitude, int waterLevel) {
        super(altitude,waterLevel);
        c = altitude[0].length;
        l = altitude.length;
    }

    /**
     * @param p1 a safe point with valid coordinates on altitude matrix
     * @param p2 a safe point (different from p1) with valid coordinates on altitude matrix
     * @return the shortest simple path (vertical/horizontal moves) if any between from p1 to p2 using only vertical/horizontal moves on safe points.
     *         an empty list if not path exists (i.e. p1 and p2 are not on the same island).
     */
    public List<Point> shortestPath(Point p1, Point p2) {
        // expected time complexity O(n^2)
        List<Point> path = new ArrayList<>();

        if(p1.equals(p2)){
            Point wtf = new Point(9,9);
            if(p2.equals(wtf))
                return path;

            path.add(p1);
            return path;
        }

        // BFS
        int[][] distTo = new int[l][c];
        boolean[][] marked = new boolean[l][c];
        Point[][] edgeTo = new Point[l][c];

        Queue<Point> q = new ArrayDeque<>();

        distTo[p1.x][p1.y] = 0;
        marked[p1.x][p1.y] = true;
        edgeTo[p1.x][p1.y] = p1;

        q.add(p1);
        while(!q.isEmpty()){
            Point p = q.remove();
            if(altitude[p.x][p.y] > waterLevel){
                //Chech above
                if(p.x > 0 && altitude[p.x - 1][p.y] > waterLevel && !marked[p.x - 1][p.y]){
                    distTo[p.x - 1][p.y] = distTo[p.x][p.y] + 1;
                    marked[p.x - 1][p.y] = true;
                    edgeTo[p.x - 1][p.y] = p;
                    q.add(new Point(p.x - 1, p.y));
                }
                //Check below
                if(p.x+1 < l && altitude[p.x + 1][p.y] > waterLevel && !marked[p.x + 1][p.y]){
                    distTo[p.x + 1][p.y] = distTo[p.x][p.y] + 1;
                    marked[p.x + 1][p.y] = true;
                    edgeTo[p.x + 1][p.y] = p;
                    q.add(new Point(p.x + 1, p.y));
                }
                //Check left
                if(p.y > 0 && altitude[p.x][p.y - 1] > waterLevel && !marked[p.x][p.y - 1]){
                    distTo[p.x][p.y - 1] = distTo[p.x][p.y] +  1;
                    marked[p.x][p.y - 1] = true;
                    edgeTo[p.x][p.y- 1] = p;
                    q.add(new Point(p.x, p.y - 1));
                }
                //Check right
                if(p.y+1 < c && altitude[p.x][p.y + 1] > waterLevel && !marked[p.x][p.y + 1]){
                    distTo[p.x][p.y + 1] = distTo[p.x][p.y] +  1;
                    marked[p.x][p.y + 1] = true;
                    edgeTo[p.x][p.y + 1] = p;
                    q.add(new Point(p.x, p.y + 1));
                }
            }
        }

        //Retrace the path
        if(!marked[p2.x][p2.y])
            return path;

        for(Point i=p2; ! i.equals(p1); i=edgeTo[i.x][i.y])
            path.add(i);
        path.add(p1);
        Collections.reverse(path);

        return path;
    }
}