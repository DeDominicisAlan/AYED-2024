package tp5.ejercicio1Alumno.adjList;

import java.util.List;

import java.util.ArrayList;

import tp5.ejercicio1Alumno.Edge;
import tp5.ejercicio1Alumno.Graph;
import tp5.ejercicio1Alumno.Vertex;

public class AdjListGraph<T> implements Graph<T>{

	private List<AdjListVertex<T>> vertices;
	
	public AdjListGraph() {
		vertices = new ArrayList<>();
	}
	
	@Override
	public Vertex<T> createVertex(T data) {
		int newPos = this.vertices.size();
		AdjListVertex<T> vertice = new AdjListVertex<T>(data, newPos);
		this.vertices.add(vertice);
		return vertice;
	}

	@Override
	public void removeVertex(Vertex<T> vertex) {
		int pos = vertex.getPosition();
		if(vertices.get(pos) != vertex) {
			return;
		}
		vertices.remove(pos);
		for(; pos < vertices.size(); pos++) {
			this.vertices.get(pos).decrementPosition();
		}
	}

	@Override
	public Vertex<T> search(T data) {
		for(Vertex<T> vertex: vertices) {
			if(vertex.getData().equals(data))
				return vertex;
		}
		return null;
	}
	
	private boolean belongs(Vertex<T> vertex) {
		int pos = vertex.getPosition();
		return pos >= 0 && pos < this.vertices.size() 
			&& this.vertices.get(pos) == vertex;
	}

	@Override
	public void connect(Vertex<T> origin, Vertex<T> destination) {
		if(this.belongs(origin) && this.belongs(destination)) {
			((AdjListVertex) origin).connect(destination);
		}
	}

	@Override
	public void connect(Vertex<T> origin, Vertex<T> destination, int weight) {
		if(this.belongs(origin) && this.belongs(destination)) {
			((AdjListVertex) origin).connect(destination, weight);
		}
	}

	@Override
	public void disconnect(Vertex<T> origin, Vertex<T> destination) {
		if(this.belongs(origin)) {
			((AdjListVertex<T>) origin).disconnect(destination);
		}
	}

	@Override
	public boolean existsEdge(Vertex<T> origin, Vertex<T> destination) {
		if(this.belongs(origin)) {
			AdjListEdge edge = (AdjListEdge) ((AdjListVertex) origin).getEdge(destination);
			if(edge != null)
				return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return (this.vertices.size() > 0);
	}

	@Override
	public List<Vertex<T>> getVertices() {
		return new ArrayList<>(this.vertices);
	}

	@Override
	public int Weight(Vertex<T> origin, Vertex<T> destination) {
		if(this.belongs(origin)) {
			AdjListEdge edge = (AdjListEdge) ((AdjListVertex) origin).getEdge(destination);
			if(edge != null)
				return edge.getWeight();
		}
		return 0;
	}

	@Override
	public List<Edge<T>> getEdges(Vertex<T> v) {
		if(this.belongs(v)) {
			return ((AdjListVertex<T>) v).getEdges();
		}
		return null;
	}

	@Override
	public Vertex<T> getVertex(int position) {
		if(position >= vertices.size() && position > 0) {
			return null;
		}
		return vertices.get(position);
	}

	@Override
	public int getSize() {
		return vertices.size();
	}

}
