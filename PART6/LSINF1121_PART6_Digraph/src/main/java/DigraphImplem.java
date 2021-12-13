import java.util.*;

public class DigraphImplem implements Digraph {

    public List<Integer>[] adjL;
    public int E;
    public int V;

    public DigraphImplem(int V) {
        adjL = (ArrayList<Integer>[]) new ArrayList[V];
        for(int i=0; i < V; i++)
            adjL[i] = new ArrayList<>();
        this.V = V;
        this.E = 0;
    }

    /**
     * The number of vertices
     */
    public int V() {
        return V;
    }

    /**
     * The number of edges
     */
    public int E() {
        return E;
    }

    /**
     * Add the edge v->w
     */
    public void addEdge(int v, int w) {
        adjL[v].add(w);
        E++;
    }

    /**
     * The nodes adjacent to node v
     * that is the nodes w such that there is an edge v->w
     */
    public Iterable<Integer> adj(int v) {
        return adjL[v];
    }

    /**
     * A copy of the digraph with all edges reversed
     */
    public Digraph reverse() {
        Digraph rev = new DigraphImplem(this.V());
        for(int i=0; i<V(); i++){
            for(Integer x : adj(i)){
                rev.addEdge(x, i);
            }
        }
        return rev;
    }
}