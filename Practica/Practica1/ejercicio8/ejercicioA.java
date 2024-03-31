package ejercicio8;

public class ejercicioA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularQueue<Integer> colaCircular = new CircularQueue<>();
		
		colaCircular.enqueue(1);
		colaCircular.enqueue(2);
		colaCircular.enqueue(3);
		colaCircular.enqueue(4);
		
		System.out.println(colaCircular);
		
		System.out.println(colaCircular.shift());
		System.out.println(colaCircular.shift());
		
		System.out.println(colaCircular);
		
		DoubleEndedQueue<Integer> cola = new DoubleEndedQueue<>();
		
		cola.enqueue(1);
		cola.enqueue(2);
		cola.enqueue(3);
		cola.enqueue(4);
		
		System.out.println(cola);
		
		cola.enqueueFirst(0);
		
		System.out.println(cola);
		
		Queue<Integer> cola3 = new Queue<>();
		
		System.out.println(cola3.dequeue());
		
	}

}
