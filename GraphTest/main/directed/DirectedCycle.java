package directed;

import java.util.Stack;

public class DirectedCycle {

    private int[] edgeTo;
    private boolean[] marked;
    private boolean[] onStack;
    private Stack<Integer> cycle;
    
    public DirectedCycle(Digraph g){
        edgeTo = new int[g.V()];
        marked = new boolean[g.V()];
        onStack = new boolean[g.V()];
        for(int i = 0 ; i < g.V(); i++){
            if(!marked[i]){
                dfs(g,i);
            }
        }
    }
    
    private void dfs(Digraph g, int v){
        marked[v] = true;
        onStack[v] = true;
        for(int w : g.adj(v)){
            if(hasCycle()){
                return ;
            }else if(!marked[w]){
                edgeTo[w] = v;
                dfs(g,w);
            }else if(onStack[w]){
                cycle = new Stack<>();
                for(int x = v; x != w; x = edgeTo[x]){
                    cycle.push(x);
                }
            }
        }
        onStack[v] = false;
    }
    
    
    public boolean hasCycle(){
        return cycle != null;
    }
}
