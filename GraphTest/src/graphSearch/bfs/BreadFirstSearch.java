package graphSearch.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import graph.Graph;

/**
 * 
     
    * @ClassName: BreadFirstSearch
     
    * @Description: 广度优先搜索
     
    * @author geng
     
    * @date 2017年10月29日 上午8:28:28
     
    *
 */
public class BreadFirstSearch {

    private boolean marked[];
    
    private int[] edgeTo;
    
    private  final int s;
    
    public BreadFirstSearch(Graph g, int s){
        marked = new boolean[g.v()];
        edgeTo = new int[g.v()];
        this.s = s;
        bfs(g,s);
    }
    
    private void bfs(Graph g, int s){
        marked[s] = true;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        while(!queue.isEmpty()){
            Integer w = queue.poll();
            for(int v : g.adj(w)){
                if(!marked[v]){
                    queue.add(v);
                    marked[v] = true;
                    edgeTo[v] = w;
                }
                
            }
        }
    }
    
    public boolean marked(int v){
        return marked[v];
    }
    
    public int mount(int s){
        int mount = 0;
        for(int i = 0; i < s; i++){
            if(marked(i)){
                mount++;
            }
        }
        return mount;
    }
    
    
    public Iterable<Integer> pathTo(int v){
        if(!marked[v]){
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        for(int x = v; x != s; x = edgeTo[v]){
            stack.add(x);
        }
        stack.add(s);
        return stack;
    }
}
