import java.util.LinkedList;

public class Maze {
    public static Iterable<Integer> shortestPath(int [][] maze,  int x1, int y1, int x2, int y2) {
        //TODO
        return new LinkedList<>();
    }

    public static int ind(int x,int y, int lg) {return x*lg + y;}

    public static int row(int pos, int mCols) { return pos / mCols; }

    public static int col(int pos, int mCols) { return pos % mCols; }
}
