package tp3;

import EDD.Queue;
import java.util.List;

public class AnalizadorArbol {
	

	public double mayorPromedio(GeneralTree<Integer> arbol) {
		int cant = 0;
		double promedio = 0;
		double mayor = 0;
		int nivel = 0;
		Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
		queue.enqueue(arbol);
		queue.enqueue(null);
		while(!queue.isEmpty()) {
			GeneralTree<Integer> tree_aux = queue.dequeue();
			if(tree_aux == null) {
				promedio = promedio / cant;
				System.out.println("Promedio del nivel " + nivel + " : " + promedio);
				if(promedio > mayor)
					mayor = promedio;
				cant = 0;
				promedio = 0;
				nivel++;
				if(!queue.isEmpty())
					queue.enqueue(null);
			}else {
				
			cant++;
			promedio += tree_aux.getValue();
			
			List<GeneralTree<Integer>> lista = tree_aux.getChildren();
			for(GeneralTree<Integer> child: lista)
				queue.enqueue(child);
			}
		}
		
		
		return mayor;
	}
}
