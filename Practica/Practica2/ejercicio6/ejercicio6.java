package tp2.ejercicio6;

import tp2.ejercicio1.*;

public class ejercicio6 {
	
	public static int suma(BinaryTree<Integer> arbol) {
		if(arbol.isLeaf()) {
			Integer aux = arbol.getData();
			arbol.setData(0);
			return aux;
		}
		
		int resultado = 0;
		
		if(arbol.hasLeftChild()) {
			resultado += suma(arbol.getLeftChild());
		}
		
		if(arbol.hasRightChild()) {
			resultado += suma(arbol.getRightChild());
		}
		
		Integer aux = arbol.getData();
		
		arbol.setData(resultado);
		
		return resultado+aux;
	}
	
	public static void inOrden(BinaryTree<Integer> arbol) {
		if(arbol.hasLeftChild()) {
			inOrden(arbol.getLeftChild());
		}
		
		System.out.println(arbol.getData());
		
		if(arbol.hasRightChild()) {
			inOrden(arbol.getRightChild());
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		//post orden y devolviendo suma y actualizando creo
		
		BinaryTree<Integer> arbol = new BinaryTree<>(1);
		BinaryTree<Integer> arbol2 = new BinaryTree<>(2);
		BinaryTree<Integer> arbol4 = new BinaryTree<>(4);
		BinaryTree<Integer> arbol3 = new BinaryTree<>(3);
		BinaryTree<Integer> arbol5 = new BinaryTree<>(5);
		BinaryTree<Integer> arbol6 = new BinaryTree<>(6);
		BinaryTree<Integer> arbol7 = new BinaryTree<>(7);
		BinaryTree<Integer> arbol8 = new BinaryTree<>(8);
		
		arbol2.addRightChild(arbol4);
		arbol.addLeftChild(arbol2);
		arbol5.addLeftChild(arbol7);
		arbol5.addRightChild(arbol8);
		arbol3.addRightChild(arbol6);
		arbol3.addLeftChild(arbol5);
		arbol.addRightChild(arbol3);
		
		Transformacion tr = new Transformacion(arbol);
		
		arbol.entreNiveles(0, 4);
		
		tr.suma();
		
		System.out.println("Arbol modificado: ");
		
		arbol.entreNiveles(0, 4);
		
	}

}
