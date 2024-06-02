package tp3;

import java.util.LinkedList;
import java.util.List;

import EDD.BinaryTree;
import EDD.Queue;

public class ParcialArboles {
	GeneralTree<Integer> arbol = new GeneralTree<Integer>();

	public ParcialArboles() {
		
	}
	
	public ParcialArboles(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}

	public GeneralTree<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public boolean esDeSeleccion() {
		return esDeSeleccion(this.arbol);
	}
	
	private static boolean esDeSeleccion (GeneralTree<Integer> arbol) {
		if(arbol.isEmpty() || arbol.isLeaf()) {
			return true;
		}
		
		for(GeneralTree<Integer> nodo: arbol.getChildren()) {
			if(nodo.getValue() < arbol.getValue()) {
				return false;
			}
			if(esDeSeleccion(nodo) == false)
				return false;
			
		}
		
		return true;
	}
	
	public boolean esCreciente() {
		Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
		queue.enqueue(this.arbol);
		queue.enqueue(null);
		int nivel = 0;
		int nodos = 1;
		while (!queue.isEmpty()) {
			GeneralTree<Integer> tree_aux = queue.dequeue();
			if(tree_aux == null) { //llegue al final o finalice un nivel
				if(nodos != nivel+1) //Si no es creciente, corto la ejecucion
					return false;
				nivel++;
				System.out.println();
				if(!queue.isEmpty()) {
					queue.enqueue(null);
				}
			} else {
			
			System.out.println(tree_aux.getValue() + " ");
			
			List<GeneralTree<Integer>> childs = tree_aux.getChildren();
			for (GeneralTree<Integer> child : childs) {
				queue.enqueue(child);
				nodos++; //aumento la cantidad de nodos
			}
		}
	
			}
		return true;
		}
	
	/*public static List<Integer> resolver(GeneralTree<Integer> arbol){
		List<Integer> lista = new LinkedList<Integer>();
		resolver(arbol,0,0, lista);
		return lista;
		
	}
	
	private static void resolver(GeneralTree<Integer> arbol, int nivel, int caminoActual, List<Integer> lista){
		
		if(arbol.isEmpty()) {
			return; //en caso que este vacio devolvemos la lista
		}
		
		
		caminoActual += arbol.getValue() * nivel;
			
		if(arbol.getValue() == 1)
			lista.add(arbol.getValue());
	
		if(arbol.isLeaf()) {
			if(caminoActual > )
		}
	}*/

	
}
