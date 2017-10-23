package graphSearch.dfs;

import java.util.Stack;

import graph.Graph;

/**
 * 
     
    * @ClassName: dfsPath
     
    * @Description: 深度优先算法寻找路径
     
    * @author geng
     
    * @date 2017年10月23日 下午9:53:15
     
    *
 */
public class dfsPath {

    private boolean[] marked;
    
    private int[] edge;
    
    private final int  s;
    
    public dfsPath(Graph g, int s){
        this.s = s;
        marked = new boolean[g.v()];
        edge = new int[g.v()];
        dfs(g,s);
    }
    
    private void dfs(Graph g, int s){
        marked[s] = true;
        for(int w : g.adj(s)){
            if(!marked[w]){
                dfs(g, w);
                edge[w] = s;
            }
        }
    }
    
    public boolean hasPathTo(int v){
        return marked[v];
    }
    
    public Iterable<Integer> pathTo(int v){
        if(!marked[v]){
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        while(edge[v] != s){
            stack.push(edge[v]);
            v = edge[v];
        }
        stack.push(s);
        return stack;
    }
}
