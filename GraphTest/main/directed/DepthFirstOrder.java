package directed;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstOrder {

    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;
    
    private boolean[] marked; 
    
    public DepthFirstOrder(Digraph g){
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new Stack<>();
        marked = new boolean[g.V()];
        for(int v = 0; v < g.V(); v++){
            if(!marked[v]){
                dfs(g,v);
            }
        }
    }
    
    private void dfs(Digraph g, int v){
        marked[v] = true;
        pre.add(v);
        for(int w : g.adj(v)){
            if(!marked[w]){
                dfs(g,w);
            }
        }
        post.add(v);
        reversePost.add(v);
    }

    public Queue<Integer> getPre() {
        return pre;
    }

    public Queue<Integer> getPost() {
        return post;
    }

    public Stack<Integer> getReversePost() {
        return reversePost;
    }
    
    
}
