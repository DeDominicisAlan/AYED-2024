package tp5.ejercicio1Alumno;

public interface Edge<T> {

	public Vertex<T> target();
	/**
	 * Retorna el vertice destino de la arista
	 * Es decir, A apunta a B
	 * entonces retorna B
	 * @return
	 */
	
	public int getWeight();
	
	/**
	 * Retorna el peso de la arista
	 * 
	 * @return
	 */
	
}
