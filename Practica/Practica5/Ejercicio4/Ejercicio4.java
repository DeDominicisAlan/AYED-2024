package tp5.ejercicio4;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph<String> ciudades = new AdjListGraph<>();

		Vertex<String> v1 = ciudades.createVertex("Holmenkollen");
		Vertex<String> v2 = ciudades.createVertex("Parque Vigeland");
		Vertex<String> v3 = ciudades.createVertex("Galería Nacional");
		Vertex<String> v4 = ciudades.createVertex("Parque Botánico");
		Vertex<String> v5 = ciudades.createVertex("Museo Munch");
		Vertex<String> v6 = ciudades.createVertex("Ayuntamiento");
		Vertex<String> v7 = ciudades.createVertex("Palacio Real");
		Vertex<String> v8 = ciudades.createVertex("Akker Brigge");
		Vertex<String> v9 = ciudades.createVertex("FolkMuseum");
		Vertex<String> v10 = ciudades.createVertex("Museo Fram");
		Vertex<String> v11 = ciudades.createVertex("Museo Vikingo");
		Vertex<String> v12 = ciudades.createVertex("Museo del Barco Polar");
		Vertex<String> v13 = ciudades.createVertex("El Tigre");
		Vertex<String> v14 = ciudades.createVertex("La Opera");
		Vertex<String> v15 = ciudades.createVertex("Fortaleza Akershus");

		// Conectar vértices con aristas y pesos
		ciudades.connect(v1, v2, 30); // Holmenkollen, Parque Vigeland
		ciudades.connect(v2, v3, 10); // Parque Vigeland, Galería Nacional
		ciudades.connect(v3, v4, 15); // Galería Nacional, Parque Botánico
		ciudades.connect(v4, v5, 1);  // Parque Botánico, Museo Munch
		ciudades.connect(v6, v4, 10); // Ayuntamiento, Parque Botánico
		ciudades.connect(v3, v6, 10); // Galería Nacional, Ayuntamiento
		ciudades.connect(v6, v7, 5);  // Ayuntamiento, Palacio Real
		ciudades.connect(v6, v8, 20); // Ayuntamiento, Akker Brigge
		ciudades.connect(v7, v8, 30); // Palacio Real, Akker Brigge
		ciudades.connect(v2, v9, 20); // Parque Vigeland, FolkMuseum
		ciudades.connect(v9, v10, 5); // FolkMuseum, Museo Fram
		ciudades.connect(v10, v11, 5); // Museo Fram, Museo Vikingo
		ciudades.connect(v11, v12, 5); // Museo Vikingo, Museo del Barco Polar
		ciudades.connect(v6, v13, 15); // Ayuntamiento, El Tigre
		ciudades.connect(v13, v14, 5); // El Tigre, La Opera
		ciudades.connect(v14, v15, 10); // La Opera, Fortaleza Akershus
		ciudades.connect(v6, v7, 5);
		ciudades.connect(v6, v8, 20);
		ciudades.connect(v15, v5, 20);
		ciudades.connect(v5, v15, 20);

		VisitaOslo oslo = new VisitaOslo();
		
		List<String> lugaresRestringidos = new LinkedList<>();
		lugaresRestringidos.add("La Opera");
		
		System.out.println(oslo.paseoEnBici(ciudades, "Museo Munch", 120, lugaresRestringidos));
		System.out.println(oslo.paseoEnBici(ciudades, "Fortaleza Akershus", 120, lugaresRestringidos));
		System.out.println(oslo.paseoEnBici(ciudades, "La Opera", 20, lugaresRestringidos));
		System.out.println(oslo.paseoEnBici(ciudades, "Museo Fram", 120, lugaresRestringidos));
	}

}
