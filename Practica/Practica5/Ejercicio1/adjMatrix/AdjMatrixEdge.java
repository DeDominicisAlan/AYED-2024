package tp5.ejercicio1Alumno.adjMatrix;

import tp5.ejercicio1Alumno.Edge;
import tp5.ejercicio1Alumno.Vertex;

public class AdjMatrixEdge<T> implements Edge<T>{
	private Vertex<T> target;
	private int weight;

	public AdjMatrixEdge(Vertex<T> target,int weight) {
		this.weight = weight;
		this.target = target;
	}
	
	public int getWeight() {
		return weight;
	}

	@Override
	public Vertex<T> target() {
		// TODO Auto-generated method stub
		return target;
	}
	
	
}
