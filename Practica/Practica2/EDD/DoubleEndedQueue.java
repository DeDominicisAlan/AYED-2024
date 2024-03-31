package tp2.EDD;
import java.util.*;

public class DoubleEndedQueue<T> extends Queue<T> {
	
	public DoubleEndedQueue() {
		
	}
	
	public void enqueueFirst(T dato){
		List<T> aux = new ArrayList<>();
		
		aux.add(dato);
		
		for(T data: super.data) {
			aux.add(data);
		}
		
		super.data = aux;
		
	}
	
}
