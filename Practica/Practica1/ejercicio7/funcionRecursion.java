package ejercicio7;

import java.util.LinkedList;

public class funcionRecursion {

	public static int recursion(int n, LinkedList<Integer> lista) {
		if(n != 1) {
			if(n % 2 == 0) {
				recursion(n/2, lista);
			}else{
				recursion((3*n)+1, lista);
			}
		}
		
		lista.addFirst(n);
		
		return n;
	}
	
	public static LinkedList<Integer> calcularSucesion(int n){
		LinkedList<Integer> lista = new LinkedList<>();
		
		recursion(n,lista);
		
		return lista;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<Integer> lista = new LinkedList<>();
		
		lista = calcularSucesion(6);
		
		System.out.println(lista);
		
	}

}
