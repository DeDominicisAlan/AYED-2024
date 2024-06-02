package tp5.ejercicio1Alumno.adjMatrix;

import tp5.ejercicio1Alumno.Vertex;

public class AdjMatrixVertex<T> implements Vertex<T>{
	private T data;
	private int position;
	
	public AdjMatrixVertex(T data, int position) {
		this.data = data;
		this.position = position;
	}
	
	@Override
	public T getData() {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public void SetData(T data) {
		// TODO Auto-generated method stub
		this.data = data;
	}

	@Override
	public int getPosition() {
		// TODO Auto-generated method stub
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	public void decrementPosition() {
		this.position--;
	}
	
}
