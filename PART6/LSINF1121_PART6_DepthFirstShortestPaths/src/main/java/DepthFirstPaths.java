//TODO import

import java.util.*;

public class DepthFirstPaths {
    private boolean[] marked; // marked[v] = is there an s-v path?
    private int[] edgeTo;     // edgeTo[v] = last edge on s-v path
    private final int s;

    /**
     * Computes a path between s and every other vertex in graph G
     * @param G the graph
     * @param s the source vertex
     */
    public DepthFirstPaths(Graph G, int s) {
        this.s = s;
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    // Depth first search from v
    private void dfs(Graph G, int v) {
        //TODO question 2
        if(marked[v])
            return;
        if(v == s)
            edgeTo[v] = v;

        marked[v] = true;
        for(int curr : G.adj(v)){
            if(!marked[curr]) {
                edgeTo[curr] = v;
                dfs(G, curr);
            }
        }

    }

    /**
     * Is there a path between the source s and vertex v?
     * @param v the vertex
     * @return true if there is a path, false otherwise
     */
    public boolean hasPathTo(int v) {
        //TODO question 3
        return marked[v];
    }

    /**
     * Returns a path between the source vertex s and vertex v, or
     * null if no such path
     * @param v the vertex
     * @return the sequence of vertices on a path between the source vertex
     *         s and vertex v, as an Iterable
     */
    public Iterable<Integer> pathTo(int v) {
        //TODO question 4
        List<Integer> path = new ArrayList<>();
        for(int i = v; i != s; i = edgeTo[i]){
            path.add(i);
        }
        path.add(s);
        Collections.reverse(path);
        return path;
    }
}
