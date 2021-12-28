//feel free to import anything here

import java.util.*;

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
    //Combiner l'algo de Kruskal avec un tableau pour dire quelles composantes est connexe
    public static int best_distance(int[][] map, int startX, int startY, int endX, int endY) {
        //TODO Student
        int nCol=map[0].length;

        int[] dist=new int[map.length * nCol];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[index(startX, startY, nCol)]=0;

        boolean[] visited=new boolean[map.length * nCol];
        visited[index(startX, startY, nCol)]=true;

        // MAUVAIS CAR IL VA PAS COMPARER AVEC LE XCURR ET YCURR => POBLEME AVEC LA PQ
        Comparator<Integer> myComp=new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return Math.abs(map[x(i1, nCol)][y(i1, nCol)]-map[x(i2, nCol)][y(i2, nCol)]);
            }
        };
        PriorityQueue<Integer> queueHight=new PriorityQueue<Integer>(myComp);
        queueHight.add(index(startX, startY, nCol));

        int currIndex, currX, currY;
        while(!queueHight.isEmpty()){
            currIndex=queueHight.poll();
            currX=x(currIndex, nCol); currY=y(currIndex, nCol);
            for(int adj : adjIndex(map, currX, currY)){
                if(!visited[adj])
                    queueHight.add(adj);

            }
        }

        return 0;
    }

    // you may need to add additional things below.
    public static int index(int x, int y, int nCol){
        return x*nCol + y;
    }

    public static int x(int index, int nCol){
        return index/nCol;
    }

    public static int y(int index, int nCol){
        return index%nCol;
    }

    public static int distance(int mapFrom, int mapTo){
        return Math.abs(mapFrom-mapTo);
    }

    public static Iterable<Integer> adjIndex(int[][] map, int Xindex, int Yindex){
        int nCol=map[0].length;
        List<Integer> adj=new LinkedList<>();
        if(Xindex==0)
            adj.add(index(map.length-1, Yindex, nCol));
        else
            adj.add(index(Xindex-1, Yindex, nCol));

        if(Xindex==map.length-1)
            adj.add(index(0, Yindex, nCol));
        else
            adj.add(index(Xindex+1, Yindex, nCol));

        if(Yindex==0)
            adj.add(index(Xindex, map[Xindex].length-1, nCol));
        else
            adj.add(index(Xindex, Yindex-1, nCol));

        if(Yindex==map[Xindex].length-1)
            adj.add(index(Xindex, 0, nCol));
        else
            adj.add(index(Xindex, Yindex+1, nCol));

        return adj;
    }
}