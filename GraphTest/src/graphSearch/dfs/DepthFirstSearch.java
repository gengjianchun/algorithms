package graphSearch.dfs;

import java.util.Stack;

import graph.Graph;

/**
 * 
     
    * @ClassName: DepthFirstSearch
     
    * @Description: 深度优先算法 
     
    * @author geng
     
    * @date 2017年10月23日 下午9:29:00
     
    *
 */
public class DepthFirstSearch {

    private boolean[] marked;
    
    private int count;
    
    public DepthFirstSearch(Graph g, int s){
        marked = new boolean[g.v()];
        dfs(g,s);
    }
    
    private void dfs(Graph g, int s){
        marked[s] = true;
        count++;
        for(int w : g.adj(s)){
            dfs(g,w);
        }
    }
    
    public boolean marked(int v){
        return marked[v];
    }
    
    public int count(){
        return count;
    }
    
    public boolean hasPathTo(int v){
        return marked[v];
    }
    
}
