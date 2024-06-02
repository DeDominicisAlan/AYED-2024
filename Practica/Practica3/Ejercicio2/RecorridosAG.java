package tp3;

import java.util.LinkedList;
import java.util.List;

import EDD.Queue;

public class RecorridosAG {
	
	

	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n){
		List<Integer> lis = new LinkedList<Integer>();
		PreOrden(lis, a, n);
		return lis;
	}

	private void PreOrden(List<Integer> l, GeneralTree <Integer> a, Integer n) {
		if(a.getValue() % 2 != 0 && a.getValue() > n) {
			l.add(a.getValue());
		}
		List<GeneralTree<Integer>> childs = a.getChildren();
		for (GeneralTree<Integer> child : childs) {
			PreOrden(l,child,n);
		}
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n){
		List<Integer> lis = new LinkedList<Integer>();
		inOrden(lis, a ,n);
		return lis;
	}

	private void inOrden(List<Integer> l,GeneralTree<Integer> nodo, Integer n) {
		if (nodo == null)
	        return;

	    // Procesar el primer hijo si existe
		
	    if (!nodo.getChildren().isEmpty()) {
	    	inOrden(l,nodo.getChildren().get(0), n);
	    }

	    // Agregar el valor del nodo raíz
	    
	    if(nodo.getValue() % 2 != 0 && nodo.getValue() > n)
	    	l.add(nodo.getValue());

	    // Procesar los hijos restantes
	    
	    for (int i = 1; i < nodo.getChildren().size(); i++) {
	    	inOrden(l,nodo.getChildren().get(i), n);
	    }
	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,Integer n){
		List<Integer> lis = new LinkedList<Integer>();
		postOrden(lis, a ,n);
		return lis;
	}
	
	private void postOrden(List<Integer> l,GeneralTree <Integer> a,Integer n) {
		List<GeneralTree<Integer>> lista = a.getChildren();
		for(GeneralTree<Integer> nodo: lista) {
			postOrden(l, nodo, n);
		}
		if(a.getValue() % 2 != 0 && a.getValue() > n)
			l.add(a.getValue());
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,Integer n){
		List<Integer> lis = new LinkedList<Integer>();
		PorNiveles(lis, a ,n);
		return lis;
	}
	
	public void PorNiveles(List<Integer> lis, GeneralTree <Integer> a,Integer n) {
		Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
		GeneralTree<Integer> tree_aux;
		queue.enqueue(a);
		while (!queue.isEmpty()) {
			tree_aux = queue.dequeue();
			if(a.getValue() % 2 != 0 && a.getValue() > n)
				lis.add(a.getValue());
			List<GeneralTree<Integer>> childs = tree_aux.getChildren();
			for (GeneralTree<Integer> child : childs) {
				queue.enqueue(child);
			}
		}
	}
}
