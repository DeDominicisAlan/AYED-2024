package ejercicio7;

//Implemente un método recursivo que calcule la suma de los elementos en un
//LinkedList.
//public int sumarLinkedList(LinkedList<Integer> lista)


import java.util.ArrayList;

public class ejercicioI {

	public static int sumaRecursiva(ArrayList<Integer> lista) {
		
		int suma = 0;
		
		if(lista.size() == 0) {
			return 0;
		}
			
		Integer first = lista.remove(0);
		suma += sumaRecursiva(lista);
		lista.add(0,first);
		
		return suma + first;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> lista = new ArrayList<Integer>();
		
		for(int i = 1; i < 11; i++) {
			lista.add(i);
		}
		
		System.out.println(lista);
		
		Integer suma = sumaRecursiva(lista);
		
		System.out.println(lista);
		
		System.out.println("Suma de todos los elementos recurisva: " + suma);
		
	}
	
}