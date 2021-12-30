public class ConnectedComponents {

    private static boolean[] marked;
    public static int comp;

    /**
     * @return the number of connected components in g
     */
    public static int numberOfConnectedComponents(Graph g) {
        marked = new boolean[g.V()];
        comp = 0;

        for(int i = 0; i < g.V(); i++) {
            if(!marked[i]){
                dfs(g, i);
                comp++;
            }
        }

        return comp;
    }

    public static void dfs(Graph g, int v){
        marked[v] = true;
        for(int i : g.adj(v)){
            if(!marked[i])
                dfs(g, i);
        }
    }
}