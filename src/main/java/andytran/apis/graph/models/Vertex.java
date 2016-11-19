package andytran.apis.graph.models;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	private String name;
	private List<Edge> incidentEdges;
	
	public Vertex(String name){
		this.name = name;
		this.incidentEdges = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Edge> getIncidentEdges() {
		return incidentEdges;
	}

	public void setIncidentEdges(List<Edge> edgeList) {
		this.incidentEdges = edgeList;
	}
	
	public boolean isAdjacentTo(Vertex vertex){
		for(int i = 0; i < incidentEdges.size(); i++){
			if(incidentEdges.get(i).getEndVertex().equals(vertex))
				return true;
		}
		return false;
	}
	
	public void addEdge(Vertex end, Number weight){
		if(end == null)
			return;
		incidentEdges.add(new Edge(this, end, weight));
	}
	
	public void addEdge(Vertex end){
		if(end == null)
			return;
		addEdge(end, null);
	}
	
	public void removeEdge(Edge edge){
		for(int i = 0; i < incidentEdges.size(); i++){
			Edge e = incidentEdges.get(i);
			if(e.equals(edge)){
				incidentEdges.remove(i);
				return;
			}
		}
	}
	
	@Override
	public boolean equals(Object obj){
		Vertex vertex = (Vertex)obj;
		return this.name.equals(vertex.getName());
	}
	
}
