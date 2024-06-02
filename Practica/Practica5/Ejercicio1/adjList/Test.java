package tp5.ejercicio1Alumno.adjList;

import tp5.ejercicio1.Vertex;

import tp5.ejercicio2.Recorridos;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdjListGraph<Integer> grafo = new AdjListGraph<>();
		
		grafo.createVertex(5);
		grafo.createVertex(6);
		
		AdjListVertex<Integer> vert1 = new AdjListVertex<Integer>(5,0);
		AdjListVertex<Integer> vert2 = new AdjListVertex<Integer>(6,1);
		grafo.connect(vert1, vert2);
		
		Recorridos recorridos = new Recorridos();
		
		recorridos.dfs(grafo);
	}

}
