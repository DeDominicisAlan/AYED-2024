package tp2.ejercicio9;

import tp2.ejercicio1.*;

public class ParcialArboles {
	
	public ParcialArboles() {
		
	}
	
	public static BinaryTree<Sumydif> sumAndDif(BinaryTree<Integer> arbol){
		BinaryTree<Sumydif> abb = new BinaryTree<Sumydif>();
		sumAndDif(abb,arbol,0,0);
		return abb;
	}
	
	private static void sumAndDif(BinaryTree<Sumydif> abb, BinaryTree<Integer> arbol, int suma, int dif) {
		Sumydif syd = new Sumydif(suma + arbol.getData(), arbol.getData() - dif);
		abb.setData(syd);
		
		if(arbol.hasLeftChild()) {
			abb.addLeftChild(new BinaryTree<Sumydif>());
			sumAndDif(abb.getLeftChild(), arbol.getLeftChild(), syd.getSuma(), arbol.getData());
		}
		
		if(arbol.hasRightChild()) {
			abb.addRightChild(new BinaryTree<Sumydif>());
			sumAndDif(abb.getRightChild(), arbol.getRightChild(), syd.getSuma(), arbol.getData());
		}
	}
	
}
