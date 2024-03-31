package tp2.ejercicio3;

import java.util.LinkedList;

import tp2.ejercicio1.BinaryTree;

public class Ejercicio3 {

	public static void main(String[] args) {
		//      14
    //         /  \
    //        53   2
    //       /    / \
    //      12   33 102
		// TODO Auto-generated method stub
		BinaryTree<Integer> num14 =new BinaryTree(14);
		BinaryTree<Integer> num53 =new BinaryTree(53);
		BinaryTree<Integer> num2 =new BinaryTree(2);
		BinaryTree<Integer> num12 =new BinaryTree(12);
		BinaryTree<Integer> num33 =new BinaryTree(33);
		BinaryTree<Integer> num102 =new BinaryTree(102);
		
		num2.addLeftChild(num33);
		num2.addRightChild(num102);
		num53.addLeftChild(num12);
		num14.addLeftChild(num53);
		num14.addRightChild(num2);
		
		System.out.println("En Orden: ");
		
		LinkedList<Integer> lista = new LinkedList<>();
		
		ContadorArbol contador = new ContadorArbol(num14);
		
		lista = contador.InOrdenPares();
		
		System.out.println(lista);
		
		System.out.println("Post Orden: ");
		
		lista = contador.PostOrdenPares();
		
		System.out.println(lista);
		
	}

}
