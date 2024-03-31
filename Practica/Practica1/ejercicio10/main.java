package ejercicio10;

import ejercicio8.Queue;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		Queue<Persona> cola = new Queue<>();
		Queue<Persona> colaEspecial = new Queue<>();
		
		String sexo = s.next();
		
		while(sexo.equals("Hombre") || sexo.equals("Mujer")) {
			
			System.out.println("Ingresa nombre: ");
			String nombre = s.next();
			System.out.println("Ingresa edad: ");
			int edad = s.nextInt();
			System.out.println("Posee alguna discapacidad: ");
			boolean disc = s.nextBoolean();
			
			if(sexo.equals("Hombre")) {
				Hombre p = new Hombre(nombre,edad,disc);
				if(p.getEdad() > 70 || p.isEsp()) {
					colaEspecial.enqueue(p);
				}else {
					cola.enqueue(p);
				}
			}else {
				System.out.println("Esta embarazada: ");
				boolean emb = s.nextBoolean();
				Mujer p = new Mujer(nombre,edad,disc,emb);
				if(p.getEdad() > 70 || p.isEsp() || p.estaEmbarazada()) {
					colaEspecial.enqueue(p);
				}else {
					cola.enqueue(p);
				}
				
			}
			
			sexo = s.next();
			
		}
		
		System.out.println(cola.toString());
		System.out.println(colaEspecial.toString());

		
	}

}
