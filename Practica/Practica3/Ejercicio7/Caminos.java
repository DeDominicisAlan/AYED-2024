package tp3;

import java.util.List;
import java.util.LinkedList;

public class Caminos {
	private GeneralTree<Integer> arbol = new GeneralTree<Integer>();
	
	public Caminos() {

	}

	public Caminos(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}

	public GeneralTree<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public List<Integer> caminoAHojaMasLejana(){
		List<Integer> lista = new LinkedList<Integer>();
		System.out.println("La altura es de: " + arbol.altura());
		//El caso del camino mas largo es cuando tenemos altura N, entonces el tamaño de la lista debe ser N+1
		return caminoAHojaMasLejana(arbol,lista,arbol.altura());
	}
	
	private List<Integer> caminoAHojaMasLejana(GeneralTree<Integer> arbolAux,List<Integer> lista, int alturaMax) {
		if(arbolAux.isEmpty()) {
			return lista; //En caso que este vacio se devuelve la lista
		}
		lista.add(arbolAux.getValue()); //Agrego el valor actual a la lista
		//System.out.println("Lista actual: "+lista);
		if(arbolAux.hasChildren()) {
			List<GeneralTree<Integer>> listaAux = arbolAux.getChildren();
			for(GeneralTree<Integer> nodo: listaAux) {
				lista = caminoAHojaMasLejana(nodo,lista,alturaMax);
				if(lista.size() == alturaMax + 1) //Si la lista tiene el tamaño de la altura del arbol+1 (la raiz cuenta como nivel 0), entonces es el camino mas largo
					return lista;
				
				lista.remove(lista.size()-1); //La rama no es la mas larga, saco los nodos
			}
			
		}
		 
		
		
		return lista;
		
	}
	
	public void Hojas() {
		int max = 0;
		max = Hojas(this.arbol, 0, max);
		System.out.println(max);
	}
	
	private int Hojas(GeneralTree<Integer> ab, int num, int max) {
		if(arbol.isEmpty()) {
			return num;
		}
		
		num += ab.getValue();
		
		if(ab.hasChildren())
		for(GeneralTree<Integer> nodo: ab.getChildren()) {
			max = Hojas(nodo, num,max);
		}
		
		if(num > max)
			max = num;
		
		System.out.println("Suma de la rama: " + num);
		System.out.println(max);
		
		return max;
	}
	
	}
