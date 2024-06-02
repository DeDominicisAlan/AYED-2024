package tp5.ejercicio2;

import tp5.ejercicio1Alumno.*;
import java.util.List;

public class Recorridos<T> {
	
	public void dfs(Graph<T> grafo) {
		boolean[] marca = new boolean[grafo.getSize()];
		for(int i=0; i < grafo.getSize(); i++) {
			if(!marca[i]) {
				System.out.println("largo con: "+grafo.getVertex(i).getData());
				dfs(i,grafo,marca);
			}
		}
	}
	
	public void dfs(int i, Graph<T> grafo, boolean[] marca) {
		marca[i] = true;
		Vertex<T> v = grafo.getVertex(i);
		System.out.println(v.getData());
		List<Edge<T>> adyacentes = grafo.getEdges(v);
		for(Edge<T> e : adyacentes) {
			int j = e.target().getPosition();
			if(!marca[j]) {
				dfs(j,grafo,marca);
			}
		}
		
	}
	
	public List<T> bfs(Graph<T> grafo){
		
		return null
	}
	
}
