package tp2.ejercicio1;

public class prueba {

	public static BinaryTree<Integer> crearNodo(BinaryTree<Integer> arbol, Integer dato){
		if(arbol == null) {
			return arbol = new BinaryTree<>(dato);
		}else if(arbol.getData() > dato) {
			arbol.addLeftChild(crearNodo(arbol.getLeftChild(),dato));
		}else {
			arbol.addRightChild(crearNodo(arbol.getRightChild(),dato));
		}
		
		return arbol;
	}
	
	public static void imprimirArbol(BinaryTree<Integer> arbol) {
	    if (arbol != null) {
	        imprimirArbol(arbol.getLeftChild());
	        System.out.print(arbol.getData() + " ");
	        imprimirArbol(arbol.getRightChild());
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> arbol = null;
		
		arbol = crearNodo(arbol,2);
		
		crearNodo(arbol,0);
		crearNodo(arbol,-1);
		crearNodo(arbol,1);
		crearNodo(arbol,4);
		crearNodo(arbol,10);
		imprimirArbol(arbol);
		System.out.println();
		System.out.println(arbol.contarHojas());
		
		arbol = arbol.espejo();
		
		imprimirArbol(arbol);
		
		arbol.entreNiveles(1, 2);
	}

}
