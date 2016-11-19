package andytran.apis.graph.models;

import java.util.List;

public abstract class Graph {
	
	private List<Vertex> vertices;
	private List<Edge> edges;
	
	public List<Vertex> getVertices() {
		return vertices;
	}
	
	public List<Edge> getEdges() {
		return edges;
	}
	
	public abstract void insertVertex(Vertex vertex);
	public abstract void insertEdge(Edge edge);
	
	public void removeVertex(Vertex vertex){	
		int index= vertices.indexOf(vertex);
		if(index == -1)
			return;
		
		Vertex v = vertices.get(index);
		v.getIncidentEdges().forEach(edge -> {
			removeEdge(edge);
		});
		vertices.remove(index);
	}
	
	public void removeEdge(Edge edge){
		int index = edges.indexOf(edge);
		if(index == -1)
			return;
		
		Edge e = edges.get(index);
		Vertex startVertex = e.getStartVertex();
		Vertex endVertex = e.getEndVertex();
		
		startVertex.removeEdge(edge);
		endVertex.removeEdge(edge);
		edges.remove(index);
	}
}
