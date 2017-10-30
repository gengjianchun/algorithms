package cc;

import graph.Graph;

public class CC {

    private boolean[] marked;
    
    private int[] id;
    
    private int count;
    
    public CC(Graph g){
        marked = new boolean[g.v()];
        id = new int[g.v()];
        for(int n = 0; n < g.v(); n++){
            if(!marked[n]){
                dfs(g,n);
                count++;
            }
        }
    }
    
    
    private void dfs(Graph g, int v){
        marked[v] = true;
        for(int w : g.adj(v)){
            if(!marked[w]){
                id[w] = count;
                dfs(g,w);
            }
        }
    }
    
    
    public boolean connected(int v, int w){
        return id[v] == id[w];
    }
    
    
}
