import java.util.*;

public class Maze {
    public static Iterable<Integer> shortestPath(int [][] maze,  int x1, int y1, int x2, int y2) {
        //TODO
        LinkedList<Integer> l = new LinkedList<>();
        if(maze[x1][y1] == 1 || maze[x2][y2] == 1)
            return l;

        int xtot = maze.length;
        int ytot = maze[0].length;

        // Begin BFS
        Deque<Integer> q = new ArrayDeque<>();
        int[][] distTo = new int[xtot][ytot];
        int[][] edgeTo = new int[xtot][ytot];
        boolean[][] marked = new boolean[xtot][ytot];

        q.add(ind(x1, y1, ytot));
        distTo[x1][y1] = 0;
        edgeTo[x1][y1] = ind(x1, y1, ytot);
        marked[x1][y1] = true;

        while(!q.isEmpty()){
            int i = q.poll();
            int xI = Maze.row(i, ytot);
            int yI = Maze.col(i, ytot);
            // Check left
            if(yI != 0 && maze[xI][yI-1] != 1 && !marked[xI][yI-1]){
                q.add(ind(xI, yI-1, ytot));
                distTo[xI][yI-1] = distTo[xI][yI] + 1;
                edgeTo[xI][yI-1] = ind(xI, yI, ytot);
                marked[xI][yI-1] = true;
            }
            //Check right
            if(yI < ytot-1 && maze[xI][yI+1] != 1 && !marked[xI][yI+1]){
                q.add(ind(xI, yI+1, ytot));
                distTo[xI][yI+1] = distTo[xI][yI] + 1;
                edgeTo[xI][yI+1] = ind(xI, yI, ytot);
                marked[xI][yI+1] = true;
            }
            //Check above
            if(xI != 0 && maze[xI-1][yI] != 1 && !marked[xI-1][yI]){
                q.add(ind(xI-1, yI, ytot));
                distTo[xI-1][yI] = distTo[xI][yI] + 1;
                edgeTo[xI-1][yI] = ind(xI, yI, ytot);
                marked[xI-1][yI] = true;
            }
            //CHeck below
            if(xI < xtot-1 && maze[xI+1][yI] != 1 && !marked[xI+1][yI]){
                q.add(ind(xI+1, yI, ytot));
                distTo[xI+1][yI] = distTo[xI][yI] + 1;
                edgeTo[xI+1][yI] = ind(xI, yI, ytot);
                marked[xI+1][yI] = true;
            }
        }

        if(!marked[x2][y2])
            return l;

        if(x1==x2 && y1==y2) {
            l.add(ind(x1, y1, ytot));
            return l;
        }

        l.add(ind(x2, y2, ytot));
        for(int i=edgeTo[x2][y2]; i!=edgeTo[Maze.row(i, ytot)][Maze.col(i, ytot)]; i=edgeTo[Maze.row(i, ytot)][Maze.col(i, ytot)])
            l.add(i);
        l.add(Maze.ind(x1, y1, ytot));

        Collections.reverse(l);
        return l;
    }

    public static int ind(int x,int y, int lg) {return x*lg + y;}

    public static int col(int pos, int mCols) { return pos % mCols; }

    public static int row(int pos, int mCols) { return pos / mCols; }
}
