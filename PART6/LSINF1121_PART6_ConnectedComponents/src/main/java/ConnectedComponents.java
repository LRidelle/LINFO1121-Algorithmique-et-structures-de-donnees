public class ConnectedComponents {

    private static boolean[] marked;
    public static int comp = 0;

    /**
     * @return the number of connected components in g
     */
    public static int numberOfConnectedComponents(Graph g) {
        marked = new boolean[g.V()];

        for(int i = 0; i <= g.V() && !marked[i]; i++){
            dfs(g, i);
            comp++;
        }

        return comp;
    }

    public static void dfs(Graph g, int v){
        if(marked[v])
            return;

        marked[v] = true;
        for(int i : g.adj(v)){
            if(!marked[i])
                dfs(g, i);
        }
    }
}