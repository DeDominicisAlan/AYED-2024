package ejercicio7;

import java.util.ArrayList;

public class ejercicioJ {

	public static ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2){
		
		ArrayList<Integer> lista3 = new ArrayList<>();
		
		int indexLista1 = 0;
		int indexLista2 = 0;
		
		while(indexLista1 < lista1.size() && indexLista2 < lista2.size()) {
			if(lista1.get(indexLista1) < lista2.get(indexLista2)) {
				lista3.add(lista1.get(indexLista1));
				indexLista1++;
			}else {
				lista3.add(lista2.get(indexLista2));
				indexLista2++;
			}
		}
		
		
		while(indexLista1 < lista1.size()) {
			lista3.add(lista1.get(indexLista1));
			indexLista1++;
		}
		
		while(indexLista2 < lista2.size()) {
			lista3.add(lista2.get(indexLista2));
			indexLista2++;
		}
		
		return lista3;
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> lista1 = new ArrayList<>();
		ArrayList<Integer> lista2 = new ArrayList<>();
		
		ArrayList<Integer> lista3 = new ArrayList<>();
		
		for(int i = 0; i < 5; i++) {
			lista1.add(i+1);
		}
		
		for(int i = 6; i < 11; i++) {
			lista2.add(i);
		}
		
		System.out.println(lista1);
		
		System.out.println(lista2);
		
		lista3 = combinarOrdenado(lista1,lista2);
		
		System.out.println(lista3);
		
		
		

	}

}
