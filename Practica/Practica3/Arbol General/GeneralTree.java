package tp3;

import java.util.*;

import EDD.Queue;

public class GeneralTree<T> {
	private T dato;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();

	public GeneralTree() {
		
	}
	
	public GeneralTree(T dato) {
		this.dato = dato;
	}

	public GeneralTree(T dato, List<GeneralTree<T>> children) {
		this.dato = dato;
		if (children == null) {
			children = new LinkedList<GeneralTree<T>>();
		} else {
			this.children = children;
		}
	}

	public T getValue() {
		return dato;
	}

	public void setValue(T dato) {
		this.dato = dato;
	}

	public List<GeneralTree<T>> getChildren() {
		return children;
	}

	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}

	public void addChildNode(GeneralTree<T> hijo) {
		this.getChildren().add(hijo);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}

	public boolean hasChildren() {
		return !this.children.isEmpty();
	}

	public boolean isEmpty() {
		return this.dato == null && !this.hasChildren();
	}

	public void removeChildNode(GeneralTree<T> hijo) {
		if (this.hasChildren()) {
			List<GeneralTree<T>> hijos = this.getChildren();
			if (hijos.contains(hijo))
				hijos.remove(hijo);
		}
	}

	public List<T> preOrden() {
		List<T> lis = new LinkedList<T>();
		this.preOrden(lis);
		return lis;
	}

	private void preOrden(List<T> l) {
		l.add(this.getValue());
		List<GeneralTree<T>> childs = this.getChildren();
		for (GeneralTree<T> child : childs) {
			child.preOrden(l);
		}
	}
	
	public List<T> postOrden() {
		List<T> lis = new LinkedList<T>();
		this.postOrden(lis);
		return lis;
	}

	private void postOrden(List<T> l) {
		List<GeneralTree<T>> childs = this.getChildren();
		for (GeneralTree<T> child : childs) {
			child.postOrden(l);
		}
		l.add(this.getValue());
	}
	
	public List<T> inOrden(){
		List<T> list = new LinkedList<T>();
		inOrden(this, list);
		return list;
	}
	
	private void inOrden(GeneralTree<T> nodo, List<T> l) {
		if (nodo == null)
	        return;

	    // Procesar el primer hijo si existe
		
	    if (!nodo.getChildren().isEmpty()) {
	    	inOrden(nodo.getChildren().get(0), l);
	    }

	    // Agregar el valor del nodo raíz
	    
	    l.add(nodo.getValue());

	    // Procesar los hijos restantes
	    
	    for (int i = 1; i < nodo.getChildren().size(); i++) {
	    	inOrden(nodo.getChildren().get(i), l);
	    }
	}
	
	/*private void inOrden(List<T> l) {
		if(this.isLeaf()) {
			l.add(this.getValue());
			return;
		}
		List<GeneralTree<T>> childs = this.getChildNodes();
		if(childs.size() == 1) {
			childs.get(0).inOrden(l);
			l.add(this.getValue());
		}else
		for(int i = 0; i < childs.size(); i++) {
				if(i==1) {
					l.add(this.getValue());
				}
				childs.get(i).inOrden(l);
		}
	}*/
		

	public List<T> getPorNiveles() {
		List<T> result = new LinkedList<T>();
		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
		GeneralTree<T> tree_aux;
		queue.enqueue(this);
		while (!queue.isEmpty()) {
			tree_aux = queue.dequeue();
			result.add(tree_aux.getValue());
			List<GeneralTree<T>> childs = tree_aux.getChildren();
			for (GeneralTree<T> child : childs) {
				queue.enqueue(child);
			}
		}
		return result;
	}
	
	public void PorNiveles() {
		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
		queue.enqueue(this);
		queue.enqueue(null);
		while (!queue.isEmpty()) {
			GeneralTree<T> tree_aux = queue.dequeue();
			if(tree_aux == null) {
				System.out.println();
				if(!queue.isEmpty()) {
					queue.enqueue(null);
				}
			} else {
			
			System.out.println(tree_aux.getValue() + " ");
			
			List<GeneralTree<T>> childs = tree_aux.getChildren();
			for (GeneralTree<T> child : childs) {
				queue.enqueue(child);
			}
		}
	
			}
		}
	
	public int altura() {
		if(this.isEmpty()) {
			return 0;
		}
		int h = -1;
		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
		queue.enqueue(this);
		queue.enqueue(null);
		while (!queue.isEmpty()) {
			GeneralTree<T> tree_aux = queue.dequeue();
			if(tree_aux == null) {
				h++;
				if(!queue.isEmpty()) {
					queue.enqueue(null);
				}
				}else {
			
			List<GeneralTree<T>> childs = tree_aux.getChildren();
			for (GeneralTree<T> child : childs) {
				queue.enqueue(child);
			}
		}
	
			}
		return h;
		}
	
	/*public int altura() {
		if(this.isEmpty())
			return 0;
		
		int h = -1;
		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
		GeneralTree<T> tree_aux;
		queue.enqueue(this);
		while(!queue.isEmpty()) {
			int tamañoNivelActual = queue.size();
			for(int i = 0; i < tamañoNivelActual; i++) {
				tree_aux = queue.dequeue();
				List<GeneralTree<T>> childs = tree_aux.getChildren();
				for(GeneralTree<T> nodo: childs) {
					queue.enqueue(nodo);
				}
			}
			
			h++;
		}
		
		return h;
	}
	*/
	
	public int nivel(T dato) {
		return nivel(this,dato, 0);
	}
	
	private int nivel(GeneralTree<T> nodo, T dato, int n) {
		if(nodo.isEmpty()) {
			return -1;
		}
		
		if(nodo.getValue().equals(dato)) {
			return n;
		}
		
		List<GeneralTree<T>> childs = nodo.getChildren();
		for (GeneralTree<T> child : childs) {
			int actual = nivel(child,dato,n+1);
			if(actual != -1)
				return actual;
		}
		
		
		return -1;
	}
	
	
	public int ancho() {
		int max = 0;
		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
		GeneralTree<T> tree_aux;
		queue.enqueue(this);
		while (!queue.isEmpty()) {
			tree_aux = queue.dequeue();
			if(tree_aux.children.size() > max)
				max = tree_aux.children.size();
			List<GeneralTree<T>> childs = tree_aux.getChildren();
			for (GeneralTree<T> child : childs) {
				queue.enqueue(child);
			}
		}
		return max;
	}
	
	
	
	private boolean esAncestro(T value, GeneralTree<T> a) {
		if(a.isEmpty()) {
			return false;
		}
		
		if(a.getValue().equals(value)) {
			return true;
			}
		
		List<GeneralTree<T>> L = a.getChildren();
		for(GeneralTree<T> nodo: L) {
			if(esAncestro(value, nodo))
				return true;
		}
		
		return false;
	}
	
	public GeneralTree<T> buscarNodo(GeneralTree<T> arbol, T dato){
		if(arbol.isEmpty()) {
			return null;
		}
		
		if(arbol.getValue().equals(dato)) {
			return arbol;
		}
		
		List<GeneralTree<T>> L = arbol.getChildren();
		for(GeneralTree<T> nodo: L) {
			GeneralTree<T> aux = buscarNodo(nodo,dato);
			if(aux != null)
				return aux;
		}
		
		return null;
	}
	
	public boolean esAncestro(T a, T b) {
		GeneralTree<T> aux = buscarNodo(this,a);
		
		if(aux == null)
			return false;
		
		return esAncestro(b,aux);
	}
	

	
}
	
