package ejercicio7;

import java.util.LinkedList;
import java.util.Scanner;

import ejercicio3.Estudiante;

public class TestLinkedList {
	
	public static LinkedList<Estudiante> nuevaLista() {
		
		LinkedList<Estudiante> lista= new LinkedList<>();
		
		lista.add(new Estudiante("Jose","Perez",5,"joseperez@hotmail.com","Buenos Aires 123"));
		
		lista.add(new Estudiante("Pepito","Perez",2,"pepitoperez@hotmail.com","Buenos Aires 122"));
		
		lista.add(new Estudiante("Mauro","Jose",5,"MauroJose@hotmail.com","Mauro's house"));
		
		for(Estudiante e: lista) {
			System.out.println(e.tusDatos());
		}
		
		return lista;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<Estudiante> lista2= nuevaLista();
		
		Scanner s = new Scanner(System.in);
		
		LinkedList<Integer> lista= new LinkedList<>();
		
		
		
		System.out.print("Ingresa un numero: ");
		
		int n = s.nextInt();
		
		while(n != 0) {
			lista.add(n);
			System.out.print("Ingresa un numero: ");
			n = s.nextInt();
		}
		
		for(Integer num: lista) {
			System.out.print(num + " ");
		}
		
		LinkedList<Estudiante> listaCopia = lista2;
		
		listaCopia.add(new Estudiante("JoseLopez","Jose",5,"MauroJose@hotmail.com","Mauro's house"));
		
		lista2.get(0).setNombre("Manzana");
		
		for(Estudiante e: lista2) {
			System.out.println(e.tusDatos());
		}
		
		listaCopia.get(1).setNombre("Lolo");
		
		System.out.println(" Lista Copia: ");
		
		for(int i=0; i < listaCopia.size();i++) {
			System.out.println(listaCopia.get(i).tusDatos() + " ");
		}
	
		
        //5131903800
	}
	

}

