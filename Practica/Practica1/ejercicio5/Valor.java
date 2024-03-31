package ejercicio5;

public class Valor {
	private int maximo = 0;
	private int minimo = 9999;
	private int promedio = 0;
	
	public Valor() {
	}
	
	

	public Valor(int maximo, int minimo, int promedio) {
		super();
		this.maximo = maximo;
		this.minimo = minimo;
		this.promedio = promedio;
	}

	public int getMaximo() {
		return maximo;
	}
	
	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}

	public void buscarMaximo(int[] array) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] > maximo)
				setMaximo(array[i]);
		}
	}
	
	public void buscarMinimo(int[] array) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] < minimo)
				setMinimo(array[i]);
		}
	}
	
	public void buscarPromedio(int[] array) {
		for(int i = 0; i < array.length; i++) {
			promedio += array[i];
		}
		promedio /= array.length;
	}

	public int getMinimo() {
		return minimo;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	public int getPromedio() {
		return promedio;
	}

	public void setPromedio(int promedio) {
		this.promedio = promedio;
	}
	
	public String toString() {
		return getMaximo() + " " + getMinimo() + " " + getPromedio();
	}
}
