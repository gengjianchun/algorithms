package graph;

public class GraphUtils {

    /**
     * 计算顶点v的度数
     * @param g
     * @param v
     * @return
     */
    public static int degree(Graph g, int v){
        int degree = 0;
        for(int w : g.adj(v)){
            degree++;
        }
        return degree;
    }
    
    /**
     * 图中所有顶点的最大度数
     * @param g
     * @return
     */
    public static int maxDegree(Graph g){
        int max = 0;
        for(int v = 0; v < g.v(); v++){
            int degree = degree(g, v);
            if(max < degree){
                max = degree;
            }
        }
        return max;
    }
    
    /**
     * 计算图中顶点的平均度数
     * @param g
     * @return
     */
    public static double avaDegree(Graph g){
        return 2d * g.e() / g.v();
    }
    
    /**
     * 计算图中自环的个数
     * @param g
     * @return
     */
    public static int numOfSelfLoop(Graph g){
        int amount = 0;
        for(int v = 0; v < g.v(); v++){
            for(int w : g.adj(v)){
                if(w == v){
                    amount++;
                }
            }
        }
        return amount;
    }
}
