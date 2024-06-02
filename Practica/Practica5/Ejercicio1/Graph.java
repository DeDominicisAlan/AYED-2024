package tp5.ejercicio1Alumno;

import java.util.List;

public interface Graph<T> {
	
	/**Crea un vertice con el dato recibido y lo retorna
	 * 
	 * @return data dato a crear en el vertice
	 */
	public Vertex<T> createVertex(T data);
	
	/**Eliminar el vertice del Grafo
	 * 
	 * En caso de que el vertice este relacionado con otros, estas relaciones tambien se eliminan
	 * 
	 * @param vertex vertice a eliminar
	 */
	public void removeVertex(Vertex<T> vertex);
	
	/**Busca y retorna el primer vertice cuyo dato es igual al parametro recibido
	 * 
	 * retorna null si no existe tal dato
	 *
	 *@return data | null ; retorna el dato pasado como parametro, null en caso que no exista tal dato
	 */
	public Vertex<T> search(T data);
	
	/**
	 * Conecta el vertice origen con el vertice destino
	 * 
	 * Verifica que ambos vertices existan, en caso contrario no realiza ninguna conexion
	 * 
	 * @param origin vertice origen
	 * @param destination  vertice destino
	 */
	public void connect(Vertex<T> origin, Vertex<T> destination);
	
	/**
	  * Conecta el vertice origen con el vertice destino con peso. 
	  * 
	  * Verifica que ambos existan, caso contrario no realiza ninguna conexion.
	  * 
	  * @param origin vertice origen
	  * @param destination vertice destino
	  * @param weight peso
	  */
	public void connect(Vertex<T> origin, Vertex<T> destination, int weight);
	 
	/**
	  * Desconecta el vertice origen con el destino.
	  * 
	  * Verifica que ambos vertices existan, caso contrario no realiza ninguna desconexion.
	  * 
	  * En caso de existir conexion destino-->origen, esta permanecera sin cambios.
	  * 
	  * Se desconecta cuando destino es adyacente de origen, origen --> destino
	  * 
	  * @param origin
	  * @param destination
	  * 
	  */
	 public void disconnect(Vertex<T> origin, Vertex<T> destination);
	 
	 /**
	   * Retorna true si existe una arista entre el vertice origen y el destino
	   * 
	   * @param origin
	   * @param destination
	   * @return boolean
	   */
	 public boolean existsEdge(Vertex<T> origin, Vertex<T> destination);
	  
	 /**
	  * Retorna si el grafo no contiene datos (sin vertices creados)
	  * 
	  * @return boolean
	  */
	 public boolean isEmpty();
	 
	 /**
	  * Retorna la lista de vertices
	  * 
	  * @return
	  */
	 public List<Vertex<T>> getVertices();

	 /**
	  * Retorna el peso entre 2 vertices
	  * 
	  * En caso de no existir la arista, retorna 0.
	  * 
	  * @param origin
	  * @param destination
	  * @return
	  */
	 public int Weight(Vertex<T> origin, Vertex<T> destination);
	
	 /**
	  * Retorna la lista de adyacentes al vertice recibido
	  * 
	  * @param v
	  * @return
	  */
	 public List<Edge<T>> getEdges(Vertex<T> v);
	 
	 /**
	  * Obtiene el vertice en la posicion recibida
	  * 
	  * @param position
	  * @return
	  */
	 public Vertex<T> getVertex(int position);
	 
	 /**
	  * Retorna la cantidad de vertices del grafo
	  * 
	  * @return
	  */
	 public int getSize();
}
