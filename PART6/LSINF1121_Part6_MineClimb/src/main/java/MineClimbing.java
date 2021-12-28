//feel free to import anything here

import org.junit.Assert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MineClimbing {
    /**
    * Returns the minimum distance between (startX, startY) and (endX, endY), knowing that
    * you can climb from one mine block (a,b) to the other (c,d) with a cost Math.abs(map[a][b] - map[c][d])
    *
    * Do not forget that the world is round: the position (map.length,i) is the same as (0, i), etc.
    *
    * map is a matrix of size n times m, with n,m > 0.
    *
    * 0 <= startX, endX < n
    * 0 <= startY, endY < m
    */
    public static int best_distance(int[][] map, int startX, int startY, int endX, int endY) {
        //TODO Student
        int[][] distTo = new int[map.length][map[0].length];
        for(int[] l : distTo)
            Arrays.fill(l, Integer.MAX_VALUE);

        PriorityQueue<posAndDist> q = new PriorityQueue<>();
        q.add(new posAndDist(startX, startY, 0));
        distTo[startX][startY] = 0;

        while(!q.isEmpty()){
            posAndDist curr = q.poll();
            if(curr.x == endX && curr.y==endY)
                return distTo[endX][endY];

            for(posAndDist neigh : adj(map, curr)){
                if(distTo[neigh.x][neigh.y] > distTo[curr.x][curr.y] + neigh.dist){
                    distTo[neigh.x][neigh.y] = distTo[curr.x][curr.y] + neigh.dist;
                    q.add(neigh);
                }
            }
        }
        return distTo[endX][endY];
    }

    // you may need to add additional things below.
    static class posAndDist implements Comparable<posAndDist> {
        public int x;
        public int y;
        public int dist;

        public posAndDist(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(posAndDist o) { return this.dist - o.dist; }
    }

    static Iterable<posAndDist> adj(int[][] map, posAndDist curr){//int Xindex, int Yindex){
        List<posAndDist> adj=new LinkedList<>();
        //Add above
        if(curr.x==0)
            adj.add(new posAndDist(map.length-1, curr.y, Math.abs(map[curr.x][curr.y] - map[map.length-1][curr.y])));
        else
            adj.add(new posAndDist(curr.x-1, curr.y, Math.abs(map[curr.x][curr.y] - map[curr.x-1][curr.y])));
        //Add below
        if(curr.x==map.length-1)
            adj.add(new posAndDist(0, curr.y, Math.abs(map[curr.x][curr.y] - map[0][curr.y])));
        else
            adj.add(new posAndDist(curr.x+1, curr.y, Math.abs(map[curr.x][curr.y] - map[curr.x+1][curr.y])));
        //Add left
        if(curr.y==0)
            adj.add(new posAndDist(curr.x, map[0].length-1, Math.abs(map[curr.x][curr.y] - map[curr.x][map[0].length-1])));
        else
            adj.add(new posAndDist(curr.x, curr.y-1, Math.abs(map[curr.x][curr.y] - map[curr.x][curr.y-1])));
        //Add right
        if(curr.y==map[curr.x].length-1)
            adj.add(new posAndDist(curr.x, 0, Math.abs(map[curr.x][curr.y] - map[curr.x][0])));
        else
            adj.add(new posAndDist(curr.x, curr.y+1, Math.abs(map[curr.x][curr.y] - map[curr.x][curr.y+1])));

        return adj;
    }
}