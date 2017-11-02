package directed;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Digraph {

    private int[] v;
    private Set<Integer>[] adj;
    private int E;
    private int V;
    
    public Digraph(int n){
        this.V = n;
        this.E = 0;
        v = new int[n];
        adj = (Set<Integer>[]) new HashSet[n];
        for(int i = 0; i < n; i++){
            adj[i] = new HashSet<>();
        }
    }
    
    public void addEdge(int v, int w){
        if(!adj[v].contains(w)){
            E++;
        }
        adj[v].add(w);
    }
    
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
    
    public Digraph reverse(){
        Digraph d = new Digraph(V);
        for(int v = 0; v < V; v++){
            for(int w : adj[v]){
                d.addEdge(w, v);
            }
        }
        return d;
    }
    
    
    public int V(){
        return V;
    }
    
    public int E(){
        return E;
    }
}
