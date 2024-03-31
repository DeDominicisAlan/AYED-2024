package tp2.ejercicio1;

//import java.util.LinkedList;

public class Arbol<T> {
	T data;
	Arbol<T> leftChild ;
	Arbol<T> rightChild ;
	
	public Arbol(){
	
	}
	
	public Arbol(T dato) {
		data = dato;
		leftChild = null;
		rightChild = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Arbol<T> getLeftChild() {
		return leftChild;
	}

	public void addLeftChild(Arbol<T> leftChild) {
		this.leftChild = leftChild;
	}

	public Arbol<T> getRightChild() {
		return rightChild;
	}

	public void addRightChild(Arbol<T> rightChild) {
		this.rightChild = rightChild;
	}
	
	public void removeLeftChild() {
		this.leftChild = null;
	}
	
	public void removeRightChild() {
		this.rightChild = null;
	}
	
	public boolean hasLeftChild() {
		return this.leftChild != null;
	}
	
	public boolean hasRightChild() {
		return this.rightChild != null;
	}
	
	public boolean isLeaf() {
		return !hasLeftChild() && !hasRightChild();
	}
	
	public boolean isEmpty() {
		return data == null;
	}
	
	public int contarHojas() {
		
		int contador = 0;
		
		if(!isEmpty()) {
			if(this.isLeaf()) {
				contador++;
			}
			if(this.hasLeftChild())
				contador+=this.getLeftChild().contarHojas();
			
			if(this.hasRightChild())
				contador+=this.getRightChild().contarHojas();
		}
				
		return contador;
		
	}
	
	public Arbol<T> espejo() {
		
		if(this.isEmpty()) {
			return new Arbol<>();
		}
		
		Arbol<T> espejo = new Arbol<>(this.getData());
		
		if(this.hasLeftChild()) {
			espejo.addLeftChild(this.getRightChild().espejo());
		}
		
		if(this.hasRightChild()) {
			espejo.addRightChild(this.getLeftChild().espejo());
		}
		
		return espejo;
	}
}
