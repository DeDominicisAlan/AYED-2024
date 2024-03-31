package ejercicio1;

public class ejercicio1 {

	public static void numerosEntre(int a, int b) {
		for(int i=a; i <= b; i++) {
			System.out.println(i);
			}
	}
	
	public static void numerosEntre1(int a, int b) {
		while(a <= b) {
			System.out.println(a);
			a++;
		}
	}
	
	public static void numerosEntre2(int a, int b) {
		System.out.println(a);
		if(a<b) {	
			a++;
			numerosEntre2(a,b);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Numeros Entre: For:");
		numerosEntre(5,15);
		System.out.println("Numeros Entre: While:");
		numerosEntre1(5,15);
		System.out.println("Numeros Entre: Recursion:");
		numerosEntre2(5,10);
		
		
	}

}
