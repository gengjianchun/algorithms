package cc;

import graph.Graph;

/**
 * 
     
    * @ClassName: TwoColor
     
    * @Description: 判断是否是二分图
     
    * @author geng
     
    * @date 2017年10月30日 下午9:29:56
     
    *
 */
public class TwoColor {

    private boolean[] marked;
    
    private boolean[] color;
    
    private boolean isTwoColorable = true;
    
    public TwoColor(Graph g){
        marked = new boolean[g.v()];
        color = new boolean[g.v()];
        for(int s = 0; s < g.v(); s++){
            if(!marked[s]){
                dfs(g,s);
            }
        }
    }

    private void dfs(Graph g, int s) {
        marked[s] = true;
        for(int v : g.adj(s)){
            if(!marked[v]){
                color[v] = !color[s];
                dfs(g,v);
            }else if(color[v] == color[s]){
                isTwoColorable = false;
            }
        }
    }
    
    public boolean isBipartite(){
        return isTwoColorable;
    }
}
