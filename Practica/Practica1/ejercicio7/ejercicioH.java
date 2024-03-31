package ejercicio7;

//h. Implemente un método recursivo que invierta el orden de los elementos en un ArrayList.
//public void invertirArrayList(ArrayList<Integer> lista)

import java.util.ArrayList;

public class ejercicioH {

	public static void invertirArrayList(ArrayList<Integer> lista) {
		
		if(lista.size() <= 1) {
			return;
		}
			
		Integer first = lista.remove(0);
		invertirArrayList(lista);
		lista.add(first);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> lista = new ArrayList<Integer>();
		
		for(int i = 1; i < 6; i++) {
			lista.add(i);
		}
		
		System.out.println(lista);
		
		invertirArrayList(lista);
		
		System.out.println(lista);
		
	}
	
}
