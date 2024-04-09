package tp2.ejercicio9;

import tp2.ejercicio1.*;

public class ejercicio9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> arbol = new BinaryTree<Integer>();
		
		
		System.out.println("arbolito: ");
		arbol.porNivel();
		
		System.out.println("sumAndDif: ");
		ParcialArboles.sumAndDif(arbol).porNivel();
	}

}
