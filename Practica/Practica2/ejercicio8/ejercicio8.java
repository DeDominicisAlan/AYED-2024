package tp2.ejercicio8;

import tp2.ejercicio1.BinaryTree;
import tp2.ejercicio7.ParcialArboles;


public class ejercicio8 {

	public static void inOrden(BinaryTree<Integer> arbol) {
		
		System.out.println(arbol.getData());
		
		if(arbol.hasLeftChild()) {
			inOrden(arbol.getLeftChild());
		}
		
		
		
		if(arbol.hasRightChild()) {
			inOrden(arbol.getRightChild());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> nodo65 = new BinaryTree<>(65);
        BinaryTree<Integer> nodo37 = new BinaryTree<>(37);
        BinaryTree<Integer> nodo81 = new BinaryTree<>(81);
        BinaryTree<Integer> nodo22 = new BinaryTree<>(22);
        BinaryTree<Integer> nodo47 = new BinaryTree<>(47);
        BinaryTree<Integer> nodo76 = new BinaryTree<>(76);
        BinaryTree<Integer> nodo93 = new BinaryTree<>(93);
        BinaryTree<Integer> nodo11 = new BinaryTree<>(11);
        BinaryTree<Integer> nodo29 = new BinaryTree<>(29);
        BinaryTree<Integer> nodo85 = new BinaryTree<>(85);
        BinaryTree<Integer> nodo94 = new BinaryTree<>(94);

        nodo65.addLeftChild(nodo37);
        nodo65.addRightChild(nodo81);
        nodo37.addLeftChild(nodo22);
        nodo37.addRightChild(nodo47);
        nodo22.addLeftChild(nodo11);
        nodo22.addRightChild(nodo29);
        nodo81.addLeftChild(nodo76);
        nodo81.addRightChild(nodo93);
        nodo93.addLeftChild(nodo85);
        nodo93.addRightChild(nodo94);
        
       	inOrden(nodo65);
       	
       	BinaryTree<Integer> nod65 = new BinaryTree<>(65);
        BinaryTree<Integer> nod37 = new BinaryTree<>(37);
        BinaryTree<Integer> nod81 = new BinaryTree<>(81);
        BinaryTree<Integer> nod47 = new BinaryTree<>(47);
        BinaryTree<Integer> nod91 = new BinaryTree<>(93);

        // Construimos el árbol
        nod65.addLeftChild(nod37);
        nod65.addRightChild(nod81);
        nod37.addRightChild(nod47);
        nod81.addRightChild(nod91);
        
        System.out.println();
        inOrden(nod65);
        
        ParcialArboles parcial = new ParcialArboles();
        System.out.println( parcial.esPrefijo( nod65, nodo65) );
	}

}
