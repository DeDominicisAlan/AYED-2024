package tp5.ejercicio4;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class VisitaOslo {

	public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos){
		List<String> camino = new LinkedList<String>();
		
		if(!lugares.isEmpty() && lugares.search(destino) != null && lugares.search("Ayuntamiento") != null) {
			boolean[] visitados = new boolean[lugares.getSize()];
			Vertex<String> origen = lugares.search("Ayuntamiento");
			Vertex<String> dest = lugares.search(destino);
			paseoEnBici(lugares,origen,dest,maxTiempo,lugaresRestringidos, camino, visitados, origen.getData());
		}
		
		return camino;
	}
	
	private void paseoEnBici(Graph<String> lugares,Vertex<String> actual ,Vertex<String> destino, int maxTiempo, List<String> lugaresRestringidos, List<String> camino, boolean[] marca, String origen) {
		marca[actual.getPosition()] = true;
		camino.add(actual.getData());
		if(camino.contains(origen)  && camino.contains(destino.getData())) {
			return;
		}
		List<Edge<String>> adyacentes = lugares.getEdges(actual);
		for(Edge<String> ady: adyacentes) {
			
			int j = ady.getTarget().getPosition();
			if(!marca[j]) {
				if(maxTiempo - ady.getWeight() >= 0 && !lugaresRestringidos.contains(actual.getData())) {
					paseoEnBici(lugares, ady.getTarget() ,destino,  maxTiempo-ady.getWeight(),  lugaresRestringidos,  camino,  marca, origen);
					if(camino.contains(origen)  && camino.contains(destino.getData())) {
						return;
					}
				}
			}
			
		}
		marca[actual.getPosition()] = false;
		camino.remove(camino.size()-1);
	}
}
