package tp5.ejercicio1Alumno;

public interface Vertex<T> {

	public T getData();
	/**
	 * Retorna el dato del vertice o nodo.
	*
	*@return
	*/
	
	public void SetData(T data);
	/**
	 * Reemplaza el valor del vertice o nodo.
	 * 
	 * @param data
	 */
	
	public int getPosition();
	/**Retorna la posicion del vertice o nodo, en el grafo.
	 * 
	 * @return 
	 */
	
	
}
