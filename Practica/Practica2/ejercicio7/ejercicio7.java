package tp2.ejercicio7;

import tp2.ejercicio1.BinaryTree;

public class ejercicio7 {
	
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
		
        
		BinaryTree<Integer> arbol2 = new BinaryTree<>(2);
		BinaryTree<Integer> arbol7 = new BinaryTree<>(7);
		BinaryTree<Integer> arbol5 = new BinaryTree<>(-5);
		BinaryTree<Integer> arbol19 = new BinaryTree<>(19);
		BinaryTree<Integer> arbol4 = new BinaryTree<>(4);
		BinaryTree<Integer> arbol18 = new BinaryTree<>(18);
		BinaryTree<Integer> arbol6 = new BinaryTree<>(6);
		BinaryTree<Integer> arbol55 = new BinaryTree<>(55);
		BinaryTree<Integer> arbol11 = new BinaryTree<>(11);
		BinaryTree<Integer> arbol23 = new BinaryTree<>(23);
		BinaryTree<Integer> arbol3 = new BinaryTree<>(-3);
		
		arbol2.addLeftChild(arbol7);
		arbol2.addRightChild(arbol5);
		arbol5.addLeftChild(arbol19);
		arbol19.addRightChild(arbol4);
		arbol4.addLeftChild(arbol18);
		arbol7.addLeftChild(arbol23);
		arbol23.addLeftChild(arbol3);
		arbol7.addRightChild(arbol6);
		arbol6.addLeftChild(arbol55);
		arbol6.addRightChild(arbol11);
		
		inOrden(arbol2);
		
		ParcialArboles parcial = new ParcialArboles(arbol2);
		
		System.out.println(parcial.isLeftTree(-5));
		
	}

}
