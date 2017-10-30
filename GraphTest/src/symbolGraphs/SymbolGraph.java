package symbolGraphs;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import graph.Graph;

public class SymbolGraph {

    private Map<String, Integer> st ;
    
    private String[] keys;
    
    private Graph G;
    
    public SymbolGraph(String path,String seprator) throws IOException{
        st = new HashMap<>();
        BufferedReader in1 = new BufferedReader(new FileReader(new File(path)));
        String str = null;
        while((str = in1.readLine()) != null){
            String[] a = str.split(seprator);
            for(String s : a){
                if(!st.containsKey(s)){
                    st.put(s, st.size());
                }
            }
        }
        in1.close();
        
        keys = new String[st.size()];
        Set<String> keySet = st.keySet();
        for(String key : keySet){
            keys[st.get(key)] = key;
        }
        
        G = new Graph(st.size());
        BufferedReader in2 = new BufferedReader(new FileReader(new File(path)));
        str = null;
        while((str = in2.readLine())!= null){
            String[] a = str.split(seprator);
            int v = st.get(a[0]);
            for(int i = 1; i < a.length; i++){
                G.addEdge(v, st.get(a[i]));
            }
        }
    }
    
    public boolean contains(String key){
        return st.containsKey(key);
    }
    
    public int index(String key){
        return st.get(key);
    }
    
    public String name(int v){
        return keys[v];
    }
    
    public Graph graph(){
        return G;
    }
}
