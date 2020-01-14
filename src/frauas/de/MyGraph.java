package frauas.de;

import java.util.*;

public class MyGraph {

	private Map<String,MyNode> nodes;
	private Map<Integer,MyEdge> edges;
    private String id;
    private String edgeDefault;
    public MyGraph(){
        nodes = new HashMap<>();
        edges = new HashMap<>();
    }


    public Map<String,MyNode> getNodes(){
        return this.nodes;
    }

    public Map<Integer,MyEdge> getEdges(){
        return this.edges;
    }

    public String getID(){
        return this.id;
    }

    public void setID(String id){
        this.id = id;
    }

    public String getEdgeDefault(){
        return this.edgeDefault;
    }
    
    public void setEdgeDefault(String edgedefault){
        this.edgeDefault = edgedefault;
    }
	
}