package tp2.ejercicio4;

import tp2.EDD.Queue;
import tp2.ejercicio1.BinaryTree;

public class Ejercicio4 {

	public static int sumarTotal(BinaryTree actual) {
		int suma = 0;
		int num = 0;
		BinaryTree<Integer> arbol = null;
		Queue<BinaryTree<Integer>> cola = new Queue<>();
		cola.enqueue(actual);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			arbol = cola.dequeue();
			if(arbol !=null) {
				if(arbol.getData() > num)
					num = arbol.getData();
				System.out.println(arbol.getData() + " " + num);
				if(arbol.hasLeftChild()) {
					cola.enqueue(arbol.getLeftChild());
				}
				if(arbol.hasRightChild()) {
					cola.enqueue(arbol.getRightChild());
				}
			}else if(!cola.isEmpty()) {
				suma += num;
				cola.enqueue(null);
			}
		}
		
		suma += num; //Sumo el ultimo num del ultimo nivel
		
		return suma;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		14
    //         /  \
    //        53   	2
    //       /  \  	/ \
    //      12  55 33 202
	
	BinaryTree<Integer> num14 =new BinaryTree(14);
	BinaryTree<Integer> num53 =new BinaryTree(53);
	BinaryTree<Integer> num2 =new BinaryTree(2);
	BinaryTree<Integer> num12 =new BinaryTree(12);
	BinaryTree<Integer> num33 =new BinaryTree(33);
	BinaryTree<Integer> num202 =new BinaryTree(202);
	BinaryTree<Integer> num55 =new BinaryTree(55);
	
	num2.addLeftChild(num33);
	num2.addRightChild(num202);
	num53.addLeftChild(num12);
	num53.addRightChild(num55);
	num14.addLeftChild(num53);
	num14.addRightChild(num2);
	
	int suma = sumarTotal(num14);
	System.out.println(suma);
	}

}
