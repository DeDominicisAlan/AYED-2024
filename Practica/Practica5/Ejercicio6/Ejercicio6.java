package tp5.ejercicio6;

import java.util.List;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class Ejercicio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph<String> grafo = new AdjListGraph<String>();
		
		BuscadorDeCaminos busc = new BuscadorDeCaminos(grafo);
		
		Vertex<String> v = grafo.createVertex("Casa Caperucita");
		Vertex<String> v1 =grafo.createVertex("Claro 1");
		Vertex<String> v2 =grafo.createVertex("Claro 2");
		Vertex<String> v3 =grafo.createVertex("Claro 3");
		Vertex<String> v4 =grafo.createVertex("Claro 4");
		Vertex<String> v5 =grafo.createVertex("Claro 5");
		Vertex<String> v6 =grafo.createVertex("Casa Abuelita");
		
		grafo.connect(v, v1, 3);
		grafo.connect(v, v2, 4);
		grafo.connect(v, v3, 4);
		grafo.connect(v1, v2, 4);
		grafo.connect(v2, v1, 4);
		grafo.connect(v3, v5, 15);
		grafo.connect(v5, v6, 4);
		grafo.connect(v1, v5, 3);
		grafo.connect(v2, v4, 10);
		grafo.connect(v4, v6, 9);
		grafo.connect(v2, v5, 11);
		
		List<List<String>> caminos = busc.recorridosMasSeguro();
		
		System.out.println("Caminos: " + caminos);
		
		}

	}


