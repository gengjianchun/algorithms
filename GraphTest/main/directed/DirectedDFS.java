package directed;

public class DirectedDFS {

    private boolean[] marked;
    
    public DirectedDFS(Digraph g, int s){
        marked = new boolean[g.V()];
        dfs(g,s);
    }
    
    private void dfs(Digraph g, int s){
        marked[s] = true;
        for(int v : g.adj(s)){
            if(!marked[v]){
                dfs(g,v);
            }
        }
    }
}
