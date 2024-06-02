package tp3;

import java.util.LinkedList;
import java.util.List;

public class RedDeAguaPotable {
	private GeneralTree<Character> arbol = new GeneralTree<Character>();

	public RedDeAguaPotable() {
		
	}
	
	public RedDeAguaPotable(GeneralTree<Character> arbol) {
		this.arbol = arbol;
	}
	
	public GeneralTree<Character> getArbol() {
		return arbol;
	}

	public void setArbol(GeneralTree<Character> arbol) {
		this.arbol = arbol;
	}
	
	public double minimoCaudal(double caudal) {
		double minimo = caudal;
		System.out.println(minimo);
		if(arbol.hasChildren()) {
			
			List<GeneralTree<Character>> lista = arbol.getChildren();
			double min = caudal / lista.size();
		
			for(int i=0; i < lista.size(); i++) {
				RedDeAguaPotable hijo = new RedDeAguaPotable(lista.get(i));
				minimo = Math.min(hijo.minimoCaudal(min),minimo);
			}
			
		}
		
		return minimo;
	}
	
	
	
}
