package ejercicio8;

import java.util.*;

public class CircularQueue<T> extends Queue<T>{

	public CircularQueue() {
		super();
	}
	
	public T shift() {
		T dato = super.dequeue();
		super.enqueue(dato);
		return dato;
	}
	
}
