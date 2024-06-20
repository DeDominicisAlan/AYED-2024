package tp5.ejercicio3;

import java.util.List;

import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class Ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph<String> ciudades = new AdjListGraph<>();
		
		System.out.println("Grafo con conexion completa");
		
		Graph<String> ciudades2 = new AdjListGraph<>();

		Vertex<String> vb1 = ciudades2.createVertex("A");
		Vertex<String> vb2 = ciudades2.createVertex("B");
		Vertex<String> vb3 = ciudades2.createVertex("C");
		Vertex<String> vb4 = ciudades2.createVertex("D");
		Vertex<String> vb5 = ciudades2.createVertex("E");

		ciudades2.connect(vb1, vb2, 3); // A -> B
		ciudades2.connect(vb1, vb3, 6); // A -> C
		ciudades2.connect(vb1, vb4, 9); // A -> D
		ciudades2.connect(vb1, vb5, 14); // A -> E

		ciudades2.connect(vb2, vb3, 4); // B -> C
		ciudades2.connect(vb2, vb4, 7); // B -> D
		ciudades2.connect(vb2, vb5, 2); // B -> E

		ciudades2.connect(vb3, vb4, 1); // C -> D
		ciudades2.connect(vb3, vb5, 8); // C -> E

		ciudades2.connect(vb4, vb5, 5); // D -> E

		Mapa mapa2 = new Mapa(ciudades2);

		// Test cases
		List<String> camino3 = mapa2.caminoSinCargarCombustible("A", "E", 20);
		System.out.println(camino3.toString());

		List<String> camino4 = mapa2.caminoSinCargarCombustible("A", "D", 10);
		System.out.println(camino4.toString());
		
		System.out.println("Grafo Desconexo");
		
		Graph<String> ciudades3 = new AdjListGraph<>();

		Vertex<String> vc1 = ciudades3.createVertex("A");
		Vertex<String> vc2 = ciudades3.createVertex("B");
		Vertex<String> vc3 = ciudades3.createVertex("C");
		Vertex<String> vc4 = ciudades3.createVertex("D");
		Vertex<String> vc5 = ciudades3.createVertex("E");

		ciudades3.connect(vc1, vc2, 5); // A -> B
		ciudades3.connect(vc2, vc3, 10); // B -> C

		ciudades3.connect(vc4, vc5, 3); // D -> E

		Mapa mapa3 = new Mapa(ciudades3);

		// Test cases
		List<String> camino5 = mapa3.caminoSinCargarCombustible("A", "C", 15);
		System.out.println(camino5.toString());

		List<String> camino6 = mapa3.caminoSinCargarCombustible("A", "E", 10);
		System.out.println(camino6.toString());
		

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
		ciudades.connect(v4, v9, 5); //"Caracas", "Paris"

		Mapa mapa = new Mapa(ciudades);
		System.out.println("Grafo Ciudades ");
		System.out.print( " | ");
		for(Vertex<String> ciudad: ciudades.getVertices())
			System.out.print(ciudad.getData() + ", ");
		System.out.print( " | ");
		System.out.println();

		List<String> camino = mapa.caminoSinCargarCombustible("Asunción","Paris" , 60);
		System.out.println(camino.toString());
		//Mismo camino, solamente llega si el tanque no se queda en 0
		List<String> camino7 = mapa.caminoSinCargarCombustible("Asunción","Paris" , 61);
		System.out.println(camino7.toString());
		
		List<String> camino2 = mapa.caminoSinCargarCombustible("Buenos Aires","Madrid" , 20);
		System.out.println(camino2.toString());
	}

}
