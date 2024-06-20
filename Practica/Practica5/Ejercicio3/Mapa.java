package tp5.ejercicio3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Mapa {
	private Graph<String> mapaCiudades;

	public Mapa(Graph<String> grafo) {
		mapaCiudades = grafo;
	}

	public List<String> devolverCamino(String ciudad1, String ciudad2) {
		List<String> lista = new ArrayList<String>();

		Boolean encontre = false;
		boolean[] visitado = new boolean[mapaCiudades.getSize()];
		if (mapaCiudades.search(ciudad1) != null && mapaCiudades.search(ciudad2) != null) {
			int i = 0;

			while (!encontre && i < mapaCiudades.getSize()) {
				// Recorro todo el grafo hasta encontrar el camino o hasta que no haya mas por
				// recorrer
				devolverCamino(i, lista, ciudad1, ciudad2, visitado);
				i++;
				if (lista.contains(ciudad1) && lista.contains(ciudad2))
					encontre = true;
			}
			
		}

		if (!encontre)
			return null;

		return lista;
	}

	// Devuelve el camino desde ciudad 1 hasta ciudad 2

	private List<String> devolverCamino(int i, List<String> lista, String ciudad1, String ciudad2, boolean[] visitado) {
		if (lista.contains(ciudad1) && lista.contains(ciudad2)) {
			return lista;
			// si lo encontre, termino la ejecucion
		}
		visitado[i] = true;
		Vertex<String> v = mapaCiudades.getVertex(i);
		lista.add(v.getData());
		List<Edge<String>> adyacentes = mapaCiudades.getEdges(v);
		// recorro los adyacentes
		for (Edge<String> ady : adyacentes) {
			int j = ady.getTarget().getPosition();
			if(!visitado[j])
			devolverCamino(j, lista, ciudad1, ciudad2, visitado);
		}
		// Si no se encontró, elimino el dato
		if (!lista.contains(ciudad1) || !lista.contains(ciudad2))
			lista.remove(v.getData());
		
		return lista;
	}

	// Devuelve el camino de "ciudad1" a "ciudad2" solamente con los elementos que
	// estan entre el camino de ambas ciudades

	public List<String> devolverCamino2(String ciudad1, String ciudad2) {
		List<String> lista = new ArrayList<String>();

		if (mapaCiudades.search(ciudad1) != null && mapaCiudades.search(ciudad2) != null) {
			Vertex<String> v = mapaCiudades.search(ciudad1);

			devolverCamino2(v.getPosition(), lista, ciudad1, ciudad2);
			return lista;
		}

		return null;
	}

	private List<String> devolverCamino2(int i, List<String> lista, String ciudad1, String ciudad2) {
		if (lista.contains(ciudad1) && lista.contains(ciudad2)) {
			return lista;
			// si lo encontre, termino la ejecucion
		}

		Vertex<String> v = mapaCiudades.getVertex(i);

		lista.add(v.getData());

		if (v.getData().equals(ciudad2)) {
			return lista;
		}

		// recorro los adyacentes
		for (Edge<String> ady : mapaCiudades.getEdges(v)) {
			int j = ady.getTarget().getPosition();
			devolverCamino2(j, lista, ciudad1, ciudad2);
		}

		// Si no se encontró, elimino el dato
		if (!lista.contains(ciudad1) || !lista.contains(ciudad2))
			lista.remove(v.getData());

		return lista;
	}

	/*
	 * devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String>
	 * ciudades): List<String> Retorna la lista de ciudades que forman un camino
	 * desde ciudad1 a ciudad2, sin pasar por las ciudades que están contenidas en
	 * la lista ciudades pasada por parámetro, si no existe camino retorna la lista
	 * vacía. (Sin tener en cuenta el combustible).
	 * 
	 */

	public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades) {

		List<String> lista = new ArrayList<>();

		if (this.mapaCiudades.search(ciudad1) != null && this.mapaCiudades.search(ciudad2) != null) {
			boolean[] visitados = new boolean[this.mapaCiudades.getSize()];
 
			for(int i = 0; i < this.mapaCiudades.getSize(); i++)
				if(!visitados[i])
					devolverCaminoExceptuando(ciudad1, ciudad2, ciudades, lista, visitados,i);

			if (lista.contains(ciudad1) && lista.contains(ciudad2)) {
				return lista;
			}

		}

		return null;
	}

	private List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades,
			List<String> lista, boolean[] visitados, int i) {
		
		if (lista.contains(ciudad1) && lista.contains(ciudad2)) {
			return lista;
		}

		visitados[i] = true;
		
		Vertex<String> v = this.mapaCiudades.getVertex(i);
				
		if (!ciudades.contains(v.getData())) {
			lista.add(v.getData());

			for (Edge<String> ady : this.mapaCiudades.getEdges(v)) {
				int j = ady.getTarget().getPosition();
				if(!visitados[j])
				devolverCaminoExceptuando(ciudad1, ciudad2, ciudades, lista, visitados, j);
			}

			if (!lista.contains(ciudad1) || !lista.contains(ciudad2))
				lista.remove(v.getData());
		}
		return null;
	}
	
	
	public List<String> caminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades){
		List<String> camino = new LinkedList<String>();
		
		if(this.mapaCiudades.search(ciudad1) != null && this.mapaCiudades.search(ciudad2) != null) {
			boolean[] visitados = new boolean[this.mapaCiudades.getSize()];
			Vertex<String> origen = this.mapaCiudades.search(ciudad1);
			Vertex<String> destino = this.mapaCiudades.search(ciudad2);
			caminoExceptuando(origen,destino,visitados,ciudad1,ciudades,camino );
		}
		
		return camino;
	}
	
	private void caminoExceptuando(Vertex<String> origen, Vertex<String> destino, boolean[] visitados, String ciudad1,List<String> ciudades,List<String> camino  ) {
		
		visitados[origen.getPosition()] = true;
		
		if(camino.contains(ciudad1) && camino.contains(destino.getData())) {
			return;
		}
		
		if(ciudades.contains(origen.getData())) {
			return;
		}
		
		camino.add(origen.getData());
		for(Edge<String> ady: this.mapaCiudades.getEdges(origen)) {
			int j = ady.getTarget().getPosition();
			if(!visitados[j])
				caminoExceptuando(ady.getTarget(), destino,visitados,ciudad1,ciudades,camino);
		}
		
		if(!camino.contains(destino.getData())) {
			camino.remove(camino.size()-1);
		}
		
	}

	

	public List<String> caminoMasCorto(String ciudad1, String ciudad2){
		
		List<String> camino = new LinkedList<String>();
		
		if(this.mapaCiudades.search(ciudad1) != null && this.mapaCiudades.search(ciudad2) != null) {
			boolean[] visitados = new boolean[this.mapaCiudades.getSize()];
			Vertex<String> origen = this.mapaCiudades.search(ciudad1);
			Vertex<String> destino = this.mapaCiudades.search(ciudad2);
			caminoMasCorto(origen, destino, camino, new LinkedList<String>(), visitados, 0, Integer.MAX_VALUE);
		}
		
		return camino;
	}
	
	private int caminoMasCorto(Vertex<String> origen, Vertex<String> destino,List<String> caminoMin , List<String> camino ,boolean[] visitados,int total,int min){
		visitados[origen.getPosition()] = true;
		camino.add(origen.getData());
		if(origen == destino && total < min) {
			caminoMin.clear();
			caminoMin.addAll(new ArrayList<>(camino));
			min = total;
		}else {
			List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);
			for(Edge<String> arista: ady) {
				int j = arista.getTarget().getPosition();
				int aux = total + arista.getWeight();
				if(!visitados[j] && aux < min) {
					min = caminoMasCorto(arista.getTarget(), destino, caminoMin, camino,visitados,aux,min);
				}
			}
		}
		visitados[origen.getPosition()] = false;
		camino.remove(camino.size()-1);
		return min;
	}
	
	 /*
	  * 
	  * caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto): List<String>
		Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2. El auto no debe
		quedarse sin combustible y no puede cargar. Si no existe camino retorna la lista vacía
	  * 
	  */
	
	public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		
		List<String> camino = new LinkedList<String>();
		
		if(this.mapaCiudades.search(ciudad1) != null && this.mapaCiudades.search(ciudad2) != null) {
			System.out.println("Tanque lleno = "+tanqueAuto);

			boolean[] visitados = new boolean[this.mapaCiudades.getSize()];
			Vertex<String> origen = this.mapaCiudades.search(ciudad1);
			Vertex<String> destino = this.mapaCiudades.search(ciudad2);
			caminoSinCargarCombustible(origen,destino,tanqueAuto,visitados, camino, ciudad1, ciudad2);
		}
		
		return camino;
		
	}
	
	private void caminoSinCargarCombustible(Vertex<String> actual, Vertex<String> destino, int tanqueAuto, boolean visitados[], List<String> lista, String ciudad1, String ciudad2) {
		
		visitados[actual.getPosition()] = true;
		
		if(lista.contains(ciudad1) && lista.contains(ciudad2)) {
			return;
		}
		
		lista.add(actual.getData());
		
		if(tanqueAuto > 0){
			if(actual != destino){
				
			List<Edge<String>> adyacentes = this.mapaCiudades.getEdges(actual);

			for(Edge<String> ayd: adyacentes) {
				int j = ayd.getTarget().getPosition();
				if(!visitados[j])
					caminoSinCargarCombustible(ayd.getTarget(), destino, tanqueAuto-ayd.getWeight(), visitados, lista, ciudad1, ciudad2);
			}
			
			}
		}
				
		//Para que llegue siempre con al menos 1 de combustible
		if(!lista.contains(ciudad1) || !lista.contains(ciudad2) || tanqueAuto <= 0) {
			//Si el camino no encontro las ciudades, desmarco para poder volver a recorrerlo desde otro camino
			visitados[actual.getPosition()] = false;
			lista.remove(lista.size()-1);
		}
		
	}
	
	public List<String> caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto){
		
		List<String> caminoMin = new LinkedList<String>();
		if(this.mapaCiudades.search(ciudad1) != null && this.mapaCiudades.search(ciudad2) != null) {
			List<String> camino = new LinkedList<String>();
			
			boolean[] visitados = new boolean[this.mapaCiudades.getSize()];
			Vertex<String> origen = this.mapaCiudades.search(ciudad1);
			Vertex<String> destino = this.mapaCiudades.search(ciudad2);
			caminoConMenorCargaDeCombustible(origen,destino,tanqueAuto,visitados, camino,caminoMin, Integer.MAX_VALUE ,0, tanqueAuto);
		}
		
		return caminoMin;
		
	}
	
	private int caminoConMenorCargaDeCombustible(Vertex<String> origen,Vertex<String> destino,int tanqueAuto, boolean[] visitados,List<String> camino,List<String> caminoMin ,int min, int act
			, int tanqueMax) {
		
		visitados[origen.getPosition()] = true;
		camino.add(origen.getData());
		//si llegamos y cargamos menos veces el tanque, actualizamos
		if(origen == destino && act < min) {
			caminoMin.clear();
			caminoMin.addAll(camino);
			min = act;
		}else {
			
			for(Edge<String> ady: this.mapaCiudades.getEdges(origen)) {
				int j = ady.getTarget().getPosition();
				//Salteamos el viaje si no nos llega la gasolina maxima del tanque
				if(tanqueMax - ady.getWeight() > 0) {
					//En caso que si llegue la gasolina maxima del tanque, pero no tenemos la suficiente cargada, volvemos a cargar y actualizamos que cargamos el auto
					if(tanqueAuto-ady.getWeight() <= 0) {
						tanqueAuto = tanqueMax;
						act++;
						}
					if(!visitados[j]) {
						min = caminoConMenorCargaDeCombustible(ady.getTarget(),destino,tanqueAuto-ady.getWeight(),visitados, camino,caminoMin, min ,act, tanqueAuto);
				}
				
				}
			}
			
			
		}
		
		//Desmarcamos por si tenemos que volver al mismo destino desde otro camino
		visitados[origen.getPosition()] = false;
		camino.remove(camino.size()-1);
		
		return min;
	}
		
	
}
