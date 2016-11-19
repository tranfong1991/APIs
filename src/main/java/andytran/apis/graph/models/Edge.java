package andytran.apis.graph.models;

public class Edge {
	
	private Vertex startVertex;
	private Vertex endVertex;
	private Number weight;
	
	public Edge(String start, String end){
		this.startVertex = new Vertex(start);
		this.endVertex = new Vertex(end);
	}
	
	public Edge(String start, String end, Number weight){
		this(start, end);
		this.weight = weight;
	}
	
	public Edge(Vertex start, Vertex end){
		this.startVertex = start;
		this.endVertex = end;
	}
	
	public Edge(Vertex start, Vertex end, Number weight){
		this(start, end);
		this.weight = weight;
	}

	public Vertex getStartVertex() {
		return startVertex;
	}

	public void setStartVertex(Vertex startVertex) {
		this.startVertex = startVertex;
	}

	public Vertex getEndVertex() {
		return endVertex;
	}

	public void setEndVertex(Vertex endVertex) {
		this.endVertex = endVertex;
	}

	public Number getWeight() {
		return weight;
	}

	public void setWeight(Number weight) {
		this.weight = weight;
	}
	
	public Vertex opposite(Vertex vertex){
		if(!isIncidentOn(vertex))
			return null;
		return this.startVertex.equals(vertex) ? this.endVertex : this.startVertex;
	}
	
	public boolean isAdjacentTo(Edge edge){
		return this.startVertex.equals(edge.getStartVertex())
				|| this.startVertex.equals(edge.getEndVertex())
				|| this.endVertex.equals(edge.getStartVertex())
				|| this.endVertex.equals(edge.getEndVertex());
	}
	
	public boolean isIncidentOn(Vertex vertex){
		return this.startVertex.equals(vertex) 
				|| this.endVertex.equals(vertex);
	}

	@Override
	public boolean equals(Object obj) {
		Edge edge = (Edge)obj;
		
		return this.startVertex.equals(edge.getStartVertex()) 
				&& this.endVertex.equals(edge.getEndVertex())
				&& this.weight.equals(edge.getWeight());
	}
	
}
