package directed;

public class Toplogical {

    private Iterable<Integer> order;
    
    public Toplogical(Digraph g){
        DirectedCycle cycle = new DirectedCycle(g);
        if(!cycle.hasCycle()){
            DepthFirstOrder dfsOrder = new DepthFirstOrder(g);
            order = dfsOrder.getReversePost();
        }
    }
    
    public Iterable<Integer> order(){
        return order;
    }
    
    public static void main(String[] args){
        Digraph g = new Digraph(13);
        g.addEdge(0, 5);
        g.addEdge(0, 6);
        g.addEdge(2, 1);
        g.addEdge(0, 1);
        g.addEdge(2, 3);
          g.addEdge(3, 5);
        g.addEdge(5,4 );
        g.addEdge(6, 4);
        g.addEdge(6, 9);
        g.addEdge(7, 6);
        g.addEdge(8, 7);
        g.addEdge(9, 11);
        g.addEdge(9,12 );
        g.addEdge(11,12 );
        g.addEdge(9, 10);
        
        Toplogical top = new Toplogical(g);
        for(int i : top.order){
            System.out.println(i);
        }
        
    }
    
    
}
