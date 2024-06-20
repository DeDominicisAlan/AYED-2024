package tp5.ejercicio3;

import java.util.ArrayList;
import java.util.List;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph<String> ciudades = new AdjListGraph<>();

		Vertex<String> v1 = ciudades.createVertex("Buenos Aires");
		Vertex<String> v2 = ciudades.createVertex("Santiago");
		Vertex<String> v3 = ciudades.createVertex("Asunción");
		Vertex<String> v4 = ciudades.createVertex("Caracas");
		Vertex<String> v5 = ciudades.createVertex("Roma");
		Vertex<String> v6 = ciudades.createVertex("Madrid");
		Vertex<String> v7 = ciudades.createVertex("Mexico");
		Vertex<String> v8 = ciudades.createVertex("Quito");
		Vertex<String> v9 = ciudades.createVertex("Paris");
		ciudades.connect(v1, v2, 3); // "Buenos Aires", "Santiago"
		ciudades.connect(v1, v3, 6); // "Buenos Aires", "Asunción"
		ciudades.connect(v2, v5, 4); // "Santiago", "Roma"
		ciudades.connect(v1, v4, 4); // Buenos Aires, Caracas
		ciudades.connect(v5, v6, 14); // Roma, Madrid
		ciudades.connect(v3, v6, 2); // Asuncion, Madrid
		ciudades.connect(v2, v3, 8); // Santiago, Asuncion
		ciudades.connect(v6, v5, 50); // "Madrid", "Roma"
		ciudades.connect(v4, v7, 10); //"Caracas", "Mexico"
		ciudades.connect(v7, v8, 10);//"Mexico", "Quito"
		ciudades.connect(v8, v9, 10);//"Quito", "Paris"
		ciudades.connect(v9, v6, 7); //"Paris", "Madrid"
		ciudades.connect(v7, v3, 8);//"Mexico", "Asuncion"
		ciudades.connect(v3, v7, 40);//"Asuncion", "Mexico"
		Mapa mapa = new Mapa(ciudades);

		System.out.println("Devolver Camino --- Camino desde Santiago hasta Roma");

		List<String> lista = mapa.devolverCamino("Buenos Aires", "Paris");

		if (lista != null)
			System.out.println(lista.toString());

		System.out.println("--------------------------------");

		List<String> ciudadesList = new ArrayList<String>();

		ciudadesList.add("Santiago");
		ciudadesList.add("Asunción");

		System.out.println("Camino exceptuando Santiago - Asuncion");
		
		System.out.println("--------------------------------");

		
		List<String> listaexp = mapa.devolverCaminoExceptuando("Buenos Aires", "Roma", ciudadesList);

		System.out.println(listaexp.toString());

		System.out.println("--------------------------------");

		
		System.out.println("------ Camino mas corto ------");

		List<String> corto = mapa.caminoMasCorto("Santiago", "Paris");

		if (corto != null)
			System.out.println(corto.toString());
		
		List<String> listaexp2 = mapa.caminoExceptuando("Buenos Aires", "Roma", ciudadesList);
		System.out.println("Camino exceptuando Santiago - Asuncion");
		
		System.out.println("--------------------------------");
		
		System.out.println(listaexp2.toString());
	}

}
