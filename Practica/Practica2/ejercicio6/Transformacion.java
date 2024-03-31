package tp2.ejercicio6;

import tp2.ejercicio1.BinaryTree;

public class Transformacion {
	BinaryTree<Integer> arbol;
	
	public Transformacion(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public BinaryTree<Integer> suma(){
		sumarArbol(arbol);
		
		return arbol;
	}
	
	private int sumarArbol(BinaryTree<Integer> arbol) {
		if(arbol.isLeaf()) {
			Integer aux = arbol.getData();
			arbol.setData(0);
			return aux;
		}
		
		int resultado = 0;
		
		if(arbol.hasLeftChild()) {
			resultado += sumarArbol(arbol.getLeftChild());
		}
		
		if(arbol.hasRightChild()) {
			resultado += sumarArbol(arbol.getRightChild());
		}
		
		Integer aux = arbol.getData();
		
		
		
		arbol.setData(resultado);
		
		System.out.println("Aux = "+ aux + " resultado = " + resultado);
		
		return resultado+aux;
	}
	
}
