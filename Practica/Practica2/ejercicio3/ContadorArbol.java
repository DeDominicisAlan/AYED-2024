package tp2.ejercicio3;

import java.util.LinkedList;

import tp2.ejercicio1.BinaryTree;

public class ContadorArbol {
	BinaryTree<Integer> arbol;
	
	public ContadorArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public ContadorArbol() {
		arbol = new BinaryTree<>();
	}

	public BinaryTree<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public LinkedList<Integer> InOrdenPares(){
		LinkedList<Integer> lista = new LinkedList<>();
		InOrdenPares(arbol,lista);
		return lista;
	}
	
	private LinkedList<Integer> InOrdenPares(BinaryTree<Integer> arbol, LinkedList<Integer> lista){
		
		if(arbol.hasLeftChild()) {
			InOrdenPares(arbol.getLeftChild(), lista);
		}
		
		if(arbol.getData() % 2 == 0) {
			lista.add(arbol.getData());
		}
		
		if(arbol.hasRightChild()) {
			InOrdenPares(arbol.getRightChild(), lista);
		}
		
		return lista;
	}
	
	public LinkedList<Integer> PostOrdenPares(){
		LinkedList<Integer> lista = new LinkedList<>();
		PostOrdenPares(arbol,lista);
		return lista;
	}
	
	private LinkedList<Integer> PostOrdenPares(BinaryTree<Integer> arbol, LinkedList<Integer> lista){
		
		if(arbol.hasLeftChild()) {
			InOrdenPares(arbol.getLeftChild(), lista);
		}
		
		if(arbol.hasRightChild()) {
			InOrdenPares(arbol.getRightChild(), lista);
		}
		
		if(arbol.getData() % 2 == 0) {
			lista.add(arbol.getData());
		}
		
		return lista;
	}
}
