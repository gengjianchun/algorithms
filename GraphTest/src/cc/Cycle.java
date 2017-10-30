package cc;

import graph.Graph;

/**
 * 
     
    * @ClassName: Cycle
     
    * @Description: 判断一个图是否有环
     
    * @author geng
     
    * @date 2017年10月30日 下午9:21:22
     
    *
 */
public class Cycle {

    private boolean[] marked;
    private boolean hasCycle;
    
    public Cycle (Graph g){
        marked = new boolean[g.v()];
        for(int s = 0; s < g.v(); s++){
            if(!marked[s]){
               dfs(g,s,s) ;
            }
        }
    }
    
    /**
     * u即为每次深度遍历的起点，如果w的邻接顶点被标记过，并且它不是遍历的起点，则说明有环。
     * 即从起点出发，可以经过v到达w，同时还存在一条路径，从起点不经过v到达w，所以，起点、v、w可以成环
     */
    
    private void dfs(Graph g, int v, int u){
        marked[v] = true;
        for(int w : g.adj(v)){
            if(!marked[w]){
                dfs(g,w,v);
            }else if(w != u){
                hasCycle = true;
            }
        }
    }
    
    public boolean hasCycle(){
        return hasCycle;
    }
}
