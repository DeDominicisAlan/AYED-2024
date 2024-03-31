package ejercicio11;

import java.util.Stack;

import ejercicio8.*;

//Con un objeto Micro que contenga Nombre y un Stack( de paradas) se puede hacer una linea.

public class ejercicio11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<Stack<String>> micros = new Queue<>();
		
		Stack<String> linea275 = new Stack<>();
		Stack<String> linea307 = new Stack<>();
		Stack<String> linea202 = new Stack<>();
		
		linea275.add("Plaza San Martin");
		linea275.add("Calle San Martin");
		linea275.add("Calle Moreno");
		linea275.add("Plaza San Martin");
		
		linea307.add("La Merced");
		linea307.add("Plaza Belgrano");
		linea307.add("Bossinga");
		
		linea202.add("Berisso");
		linea202.add("Gaggino");
		linea202.add("La Merced");
		if(args.length == 1) {
			linea202.add(args[0]);
		}
		
		
		micros.enqueue(linea275);
		micros.enqueue(linea307);
		micros.enqueue(linea202);
		
		while(!micros.isEmpty()) {
			System.out.println("Recorrido: " + micros.head());
			while(!micros.head().isEmpty()) {
				System.out.println("Parada actual: " + micros.head().peek());
				micros.head().pop();
			}
			micros.dequeue();
		}
		
	}

}
