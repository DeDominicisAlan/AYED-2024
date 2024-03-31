package tp2.EDD;
import java.util.*;

public class Queue<T> extends Sequence{
	List<T> data;
	
	public Queue() {
		this.data = new ArrayList<T>();
	}

	@Override
	public boolean isEmpty() {
		return data.size() == 0;
	}

	@Override
	public int size() {
		return data.size();
	}
	
	public void enqueue(T dato) {
		data.add(dato);
	}
	
	public T dequeue() {
		try {
			return data.remove(0);
		}catch(Exception e) {
			System.out.println("No se puede devolver porque la cola esta vacia");
			return null;
		}
	}
	
	public T head() {
		return data.get(0);
	}
	
	public String toString() {
		String aux = "[";
		
		for(T dato: data) {
			aux += dato.toString() + ", ";
		}
		
		aux = aux.substring(0,aux.length()-2)+"]";
		
		return aux;
	}
	
}
