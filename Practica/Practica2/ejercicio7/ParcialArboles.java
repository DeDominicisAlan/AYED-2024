package tp2.ejercicio7;

import tp2.ejercicio1.BinaryTree;

public class ParcialArboles {
	private BinaryTree<Integer> arbol;
	
	public ParcialArboles(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public ParcialArboles() {
		arbol = new BinaryTree<>();
	}
	
	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		
		boolean es = false;
		
		if(!arbol1.getData().equals(arbol2.getData()))
			return es;
		 
		es = true;
		
		if(arbol1.hasLeftChild() && arbol2.hasLeftChild()) {
			es = esPrefijo(arbol1.getLeftChild(), arbol2.getLeftChild());
		}
		
		if(arbol1.hasRightChild() && arbol2.hasRightChild()) {
			es = esPrefijo(arbol1.getRightChild(), arbol2.getRightChild());
		}
		
		return es;
		
	}
	
	public boolean isLeftTree(int num) {
		boolean mayor = false;
		
		
		BinaryTree<Integer> aux = busqueda(arbol, num);
		
		if(aux == null || aux.isLeaf()) {
			return false;
		}
		
		int left = contar(aux.getLeftChild());
		int right = contar(aux.getRightChild());
				
		System.out.println("Left: " + left);
		System.out.println("Right: " + right);
		
		if(left <= right)
			return false;
		
		return true;
		
	}
	
	private int contar(BinaryTree<Integer> aux) {
		if(aux  == null || aux.isLeaf()) {
			return 0; 
		}
	
		int contador = 0;
		
		if((aux.hasLeftChild() && !aux.hasRightChild()) || (!aux.hasLeftChild() && aux.hasRightChild())) {
			contador = 1;
		}
		
		contador += contar(aux.getLeftChild());
		contador += contar(aux.getRightChild());
		
		return contador;
		
		
	}
	
	private BinaryTree<Integer> busqueda(BinaryTree<Integer> arbol, int num) {
		if(arbol == null) {
			return null;
		}
		
		BinaryTree<Integer> aux = busqueda(arbol.getLeftChild(), num);
		
		if(aux != null) {
			return aux;
		}
		
		if(arbol.getData() == num) {
			return arbol;
		}
		
		aux = busqueda(arbol.getRightChild(), num);
		
		if(aux != null) {
			return aux;
		}
		
		return null;
		
	}
		
}
