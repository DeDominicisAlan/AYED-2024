package tp5.ejercicio1Alumno.adjList;

import tp5.ejercicio1Alumno.*;

import java.util.ArrayList;
import java.util.List;

public class AdjListVertex<T> implements Vertex<T>{
	private T data;
	private int position;
	private List<Edge<T>> edges;
	
	public AdjListVertex(T data, int position) {
		this.data = data;
		this.position = position;
		this.edges = new ArrayList<>();
	}
	
	@Override
	public T getData() {
		return data;
	}

	@Override
	public void SetData(T data) {
		this.data = data;
	}

	@Override
	public int getPosition() {
		return position;
	}
	
	public List<Edge<T>> getEdges(){
		return edges;
	}
	
	void decrementPosition() {
		this.position--;
	}
	
	void connect(Vertex<T> destination) {
		this.connect(destination, 1);
	}
	
	void connect(Vertex<T> destination, int weight) {
		Edge<T> edge = getEdge(destination);
		if(edge == null) {
			edges.add(new AdjListEdge<T>(destination, weight));
		}
	}
	
	void disconnect(Vertex<T> destination) {
		Edge<T> edge = getEdge(destination);
		if(edge != null)
			edges.remove(edge);
	}
	
	public Edge<T> getEdge(Vertex<T> target){
		for(Edge <T> edge : edges) {
			if(edge.target() == target)
				return edge;
		}
		
		return null;
	}

}
