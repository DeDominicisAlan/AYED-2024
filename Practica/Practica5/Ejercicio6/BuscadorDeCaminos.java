package tp5.ejercicio6;

import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

import java.util.LinkedList;

public class BuscadorDeCaminos {
	Graph<String> bosque;
	
	public BuscadorDeCaminos(Graph<String> bosque) {
		 this.bosque = bosque;
	}
	
	public List <List<String>> recorridosMasSeguro(){
		
		List<List<String>> caminos = new LinkedList<List<String>>();
		
		if(bosque.search("Casa Caperucita") != null && bosque.search("Casa Abuelita") != null) {
			
			Vertex<String> origen = bosque.search("Casa Caperucita");
			Vertex<String> destino = bosque.search("Casa Abuelita");
			boolean[] visitados = new boolean[bosque.getVertices().size()];
 			
			recorridosMasSeguros(origen,destino, caminos, new LinkedList<String>(), visitados);
			
		}
		
		return caminos;
	}
	
	private void recorridosMasSeguros(Vertex<String> origen,Vertex<String> destino, List<List<String>> caminos, List<String> caminoActual, boolean[] visitados) {
		
		caminoActual.add(origen.getData());
		
		visitados[origen.getPosition()] = true;

		if(caminoActual.contains(destino.getData())) {
			List<String> aux = new LinkedList<String>(caminoActual);
			caminos.add(aux);
			visitados[origen.getPosition()] = false;
			caminoActual.remove(caminoActual.size()-1);
			return;
		}
		
		List<Edge<String>> adyacentes = this.bosque.getEdges(origen);
		for(Edge<String> ady: adyacentes) {
			if(ady.getWeight() <= 5) {
				int j = ady.getTarget().getPosition();
				if(!visitados[j]) {
					recorridosMasSeguros(ady.getTarget(), destino, caminos, caminoActual, visitados);
				}
			}
		}
		
		visitados[origen.getPosition()] = false;
		caminoActual.remove(caminoActual.size()-1);
		
	}

	
}
