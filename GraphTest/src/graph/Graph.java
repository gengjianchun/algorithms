package graph;

import java.util.HashSet;
import java.util.Set;

public class Graph {

    private int v;
    
    private int e;
    
    private Set<Integer>[] adj;
    
    public Graph(int v){
        this.v = v;
        this.e = 0;
        adj = (Set<Integer>[])new Object[v];
        for(int i = 0; i < v; i++){
            adj[i] = new HashSet<>();
        }
    }
    
    public int e(){
        return e;
    }
    
    public int v(){
        return v;
    }
    
    public void addEdge(int v, int w){
        if(!adj[v].contains(w)){
            adj[v].add(w);
            adj[w].add(v);
            e++;
        }
    }
    
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
    
}
