package tp5.ejercicio1Alumno.adjMatrix;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1Alumno.Edge;
import tp5.ejercicio1Alumno.Graph;
import tp5.ejercicio1Alumno.Vertex;

public class AdjMatrixGraph<T> implements Graph<T>{
	private static final int EMPTY_VALUE = 0;
	private int maxVertices;
	private List<AdjMatrixVertex<T>> vertices;
	private int[][] adjMatrix;
	
	
	public AdjMatrixGraph(int maxVert) {
		maxVertices = maxVert;
		vertices = new ArrayList<>();
		adjMatrix = new int[maxVertices][maxVertices];
		for(int i = 0; i < maxVertices; i++) {
			for(int j = 0; j < maxVertices; j++) {
				adjMatrix[i][j] = EMPTY_VALUE;
			}
		}
	}
	
	@Override
	public Vertex<T> createVertex(T data) {
		if(vertices.size() == maxVertices) {
			return null;
		}
		AdjMatrixVertex<T> vertice = new AdjMatrixVertex<T>(data,vertices.size());
		vertices.add(vertice);
		return vertice;
	}
	
	

	@Override
	public void removeVertex(Vertex<T> vertex) {
		int pos = vertex.getPosition();
		int max = vertices.size();
		
		//Si no pertenece al grafo, corto ejecucion
		if(vertices.get(pos) != vertex) {
			return;
		}
		
		//Elimino la fila
		for(int fila=pos; fila < max; fila++) {
			adjMatrix[fila] = adjMatrix[fila+1];
		}
		
		//Elimino la columna
		 for (int fila = 0; fila < max; fila++) {
	            for (int col = pos; col < max; col++) {
	            	adjMatrix[fila][col] = adjMatrix[fila][col + 1];
	            }
	      }
		
		 //Reasignar posiciones
		 for(int i = pos; i < max; i++) {
			 vertices.get(i).decrementPosition();
		 }
		 //Limpiamos ultima columna
		 for(int i=0; i<max; i++) {
			 adjMatrix[i][max] = EMPTY_VALUE;
		 }
		 //Limpiamos ultima fila
		 for(int i=0; i<max; i++) {
			 adjMatrix[max][i] = EMPTY_VALUE;
		 }
		 
	}

	private boolean belongs(Vertex<T> vertex) {
		int pos = vertex.getPosition();
		return pos >= 0 && pos < this.vertices.size() 
			&& this.vertices.get(pos) == vertex;
	}
	
	@Override
	public Vertex<T> search(T data) {
		for(Vertex<T> vertice: vertices)
			if(vertice.getData().equals(data))
				return vertice;
		
		return null;
	}

	@Override
	public void connect(Vertex<T> origin, Vertex<T> destination) {
		// TODO Auto-generated method stub
		connect(origin,destination,1);
		
	}

	@Override
	public void connect(Vertex<T> origin, Vertex<T> destination, int weight) {
		if(this.belongs(origin) && this.belongs(destination)) {
			this.adjMatrix[ ((AdjMatrixVertex<T>) origin).getPosition()][((AdjMatrixVertex<T>) destination).getPosition()] = weight;
		}
		
	}

	@Override
	public void disconnect(Vertex<T> origin, Vertex<T> destination) {
		// TODO Auto-generated method stub
		connect(origin, destination, EMPTY_VALUE);
	}

	@Override
	public boolean existsEdge(Vertex<T> origin, Vertex<T> destination) {
		// TODO Auto-generated method stub
		if(this.belongs(origin) && this.belongs(destination))
			return this.adjMatrix[origin.getPosition()][destination.getPosition()] != EMPTY_VALUE;
		
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return vertices.isEmpty();
	}

	@Override
	public List<Vertex<T>> getVertices() {
		// TODO Auto-generated method stub
		return new ArrayList<>(this.vertices);
	}

	@Override
	public int Weight(Vertex<T> origin, Vertex<T> destination) {
		// TODO Auto-generated method stub
		if(this.existsEdge(origin, destination))
			return this.adjMatrix[origin.getPosition()][destination.getPosition()];
		
		return 0;
	}

	@Override
	public List<Edge<T>> getEdges(Vertex<T> v) {
		// TODO Auto-generated method stub
		List<Edge<T>> ady = new ArrayList<Edge<T>>();
		int verticePos = v.getPosition();
		for(int i = 0; i < vertices.size();i++) {
			if(adjMatrix[verticePos][i] != EMPTY_VALUE) {
				ady.add(new AdjMatrixEdge<T>(vertices.get(i),adjMatrix[verticePos][i]));
			}
		}
		return ady;
	}

	@Override
	public Vertex<T> getVertex(int position) {
		// TODO Auto-generated method stub
		if(position < 0 || this.vertices.size() <= position)
			return null;
		
		return vertices.get(position);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return vertices.size();
	}

}
