package tp2.ejercicio1;

public class probarArbol {

	public static void enOrden(Arbol<Integer> arbol) {
		if(!arbol.isEmpty()) {
			if(arbol.hasLeftChild())
				enOrden(arbol.getLeftChild());
			System.out.print(arbol.getData() + " ");
			if(arbol.hasRightChild())
				enOrden(arbol.getRightChild());
		}
	}
	
	public static void PreOrden(Arbol<Integer> arbol) {
		if(!arbol.isEmpty()) {
			
			System.out.print(arbol.getData() + " ");
			
			if(arbol.hasLeftChild())
				enOrden(arbol.getLeftChild());
			
			if(arbol.hasRightChild())
				enOrden(arbol.getRightChild());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arbol<Integer> arbol = new Arbol<>(5);
		
		Arbol<Integer> arbol20 = new Arbol<>(20);
		Arbol<Integer> arbol10 = new Arbol<>(10);
		Arbol<Integer> arbol4 = new Arbol<>(4);
		Arbol<Integer> arbol15 = new Arbol<>(15);
		
		arbol.addRightChild(arbol15);
		arbol15.addLeftChild(arbol10);
		arbol15.addRightChild(arbol20);
		arbol.addLeftChild(arbol4);
		
	
	
		Arbol<Integer> arbolCopia = new Arbol<>(5);
		
		arbolCopia = arbol.espejo();
		
		enOrden(arbol);
		
		System.out.println();
		
		enOrden(arbolCopia);
		
		System.out.println();
		
		PreOrden(arbol);
		
		System.out.println();
		
		PreOrden(arbolCopia);
		
		System.out.println();
		
		System.out.println(arbol.contarHojas());
	
	
	}

}
