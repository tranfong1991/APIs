package andytran.apis.graph.models;

public final class GraphFactory {
	
	private GraphFactory(){};
	
	public static Graph getGraph(boolean isDirected){
		if(isDirected)
			return new DirectedGraph();
		return new UndirectedGraph();
	}
	
}
