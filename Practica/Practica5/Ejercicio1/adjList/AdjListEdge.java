package tp5.ejercicio1Alumno.adjList;

import tp5.ejercicio1Alumno.*;

public class AdjListEdge<T> implements Edge<T>{
	private Vertex<T> target;
	private int weight;
	
	public AdjListEdge(Vertex<T> target, int weight) {
		this.weight = weight;
		this.target = target;
	}
	
	@Override
	public Vertex<T> target() {
		return target;
	}

	@Override
	public int getWeight() {
		return weight;
	}

}
