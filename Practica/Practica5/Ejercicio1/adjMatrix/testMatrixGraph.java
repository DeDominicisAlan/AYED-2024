package tp5.ejercicio1Alumno.adjMatrix;

import tp5.ejercicio2.Recorridos;

public class testMatrixGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdjMatrixGraph<Integer> grafo = new AdjMatrixGraph<Integer>(4);
		grafo.createVertex(0);
		grafo.createVertex(1);
		grafo.createVertex(2);
		grafo.createVertex(3);
		
		// (0) <--> (1)
		// (0) --> (2)
		// (3) --> (2)
		// (3) --> (1)
		
		grafo.connect(grafo.getVertex(0), grafo.getVertex(1));
		grafo.connect(grafo.getVertex(1), grafo.getVertex(0));
		grafo.connect(grafo.getVertex(0), grafo.getVertex(2));
		grafo.connect(grafo.getVertex(3), grafo.getVertex(2));
		grafo.connect(grafo.getVertex(3), grafo.getVertex(1));
		
		System.out.println(grafo.existsEdge(grafo.getVertex(0), grafo.getVertex(1)));
		System.out.println(grafo.existsEdge(grafo.getVertex(3), grafo.getVertex(0)));
		
		Recorridos recorridos = new Recorridos();
		
		recorridos.dfs(grafo);
		
	}

}
